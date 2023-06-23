package io.github.seujorgenochurras.apiescolatrabalho.controller;

import io.github.seujorgenochurras.apiescolatrabalho.domain.image.Image;
import io.github.seujorgenochurras.apiescolatrabalho.respository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
public class ImageController {

   @Autowired
   private ImageRepository imageRepository;


   public void uploadImage(MultipartFile multipartFile){
      Image image = new Image(multipartFile);
      image.setImageId(UUID.randomUUID().toString());
   }

}
