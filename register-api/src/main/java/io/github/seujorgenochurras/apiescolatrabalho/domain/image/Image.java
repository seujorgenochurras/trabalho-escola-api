package io.github.seujorgenochurras.apiescolatrabalho.domain.image;

import jakarta.persistence.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Entity
public class Image implements CompressibleImage, UncompressibleImage {

   @Lob
   private byte[] rawImageData;

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String imageId;

   private String name;

   public String getImageId() {
      return imageId;
   }

   public Image setImageId(String imageId) {
      this.imageId = imageId;
      return this;
   }

   public String getName() {
      return name;
   }

   public Image setName(String name) {
      this.name = name;
      return this;
   }

   @Override
   public byte[] compressImage() {
      Deflater deflater = new Deflater();
      deflater.setLevel(Deflater.BEST_COMPRESSION);
      deflater.setInput(rawImageData);
      deflater.finish();

      try (var outputStream = new ByteArrayOutputStream(rawImageData.length)) {
         byte[] tmp = new byte[8 * 1024];
         while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
         }
         return outputStream.toByteArray();
      } catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }

   @Override
   public byte[] uncompressImage() {
      Inflater inflater = new Inflater();
      inflater.setInput(rawImageData);

      try (var outputStream = new ByteArrayOutputStream(rawImageData.length)) {
         byte[] tmp = new byte[8 * 1024];
         while (!inflater.finished()) {
            int count = inflater.inflate(tmp);
            outputStream.write(tmp, 0, count);
         }
         return outputStream.toByteArray();
      } catch (IOException | DataFormatException e) {
         e.printStackTrace();
         return null;
      }
   }
}
