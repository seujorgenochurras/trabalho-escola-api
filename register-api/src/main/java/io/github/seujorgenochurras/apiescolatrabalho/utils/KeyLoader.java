package io.github.seujorgenochurras.apiescolatrabalho.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyLoader {

   private KeyLoader(){
      //Utility class
   }
   private static final KeyFactory keyFactory;

   static {
      try {
         keyFactory = KeyFactory.getInstance("RSA");
      } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);//Impossible to happen
      }
   }


   public static PrivateKey loadPrivateKey(Path path) throws IOException, InvalidKeySpecException {
      String privateKey = Files.readString(path);
      privateKey = getOnlyKey(privateKey, KeyType.PRIVATE);

      byte[] privateKeyEncoded = Base64.getDecoder().decode(privateKey);
      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyEncoded);
      return keyFactory.generatePrivate(keySpec);
   }

   public static PublicKey loadPublicKey(Path path) throws IOException, InvalidKeySpecException {
      String publicKey = Files.readString(path);
      publicKey = getOnlyKey(publicKey, KeyType.PUBLIC);

      byte[] publicKeyEncoded = Base64.getDecoder().decode(publicKey);
      X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyEncoded);
      return keyFactory.generatePublic(publicKeySpec);
   }

   private static String getOnlyKey(String rawKey, KeyType keyType){
      final String keyJunkName = keyType.name();
      return rawKey.replace("-----BEGIN " + keyJunkName + " KEY-----", "")
              .replace(System.lineSeparator(), "")
              .replace("-----END " + keyJunkName + " KEY-----", "");
   }

   private enum KeyType{
      PRIVATE,
      PUBLIC
   }
}
