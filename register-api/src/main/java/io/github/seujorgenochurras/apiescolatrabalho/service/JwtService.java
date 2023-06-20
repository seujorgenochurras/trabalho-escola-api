package io.github.seujorgenochurras.apiescolatrabalho.service;

import io.github.seujorgenochurras.apiescolatrabalho.utils.KeyLoader;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.security.Key;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


   private static Key getSigningKey() {
      try {
         return KeyLoader.loadPrivateKey(Path.of("meupau.key"));
      } catch (IOException | InvalidKeySpecException e) {
         e.printStackTrace();
         return null;
      }
   }

   public String extractUsernameFromJwt(String jwt) {
      return extractClaim(jwt, Claims::getSubject);
   }

   public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
      final Claims claims = extractAllJwtClaims(jwt);
      return claimsResolver.apply(claims);
   }

   public String generateJwt(UserDetails userDetails) {
      return generateJwt(new HashMap<>(), userDetails);
   }

   public boolean validateToken(String jwt, UserDetails userDetails){
      final String username = extractUsernameFromJwt(jwt);
      return username.equals(userDetails.getUsername()) && !isTokenExpired(jwt);
   }
   public boolean isTokenExpired(String jwt) {
      return extractClaim(jwt, Claims::getExpiration).before(new Date());
   }

   public String generateJwt(Map<String, Object> extraClaims, UserDetails userDetails) {
      return Jwts.builder()
              .setClaims(extraClaims)
              .setSubject(userDetails.getUsername())
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
              .signWith(getSigningKey(), SignatureAlgorithm.RS256)
              .compact();

   }

   private Claims extractAllJwtClaims(String jwt) {
      return Jwts.parserBuilder()
              .setSigningKey(getSigningKey())
              .build()
              .parseClaimsJws(jwt)
              .getBody();
   }
}
