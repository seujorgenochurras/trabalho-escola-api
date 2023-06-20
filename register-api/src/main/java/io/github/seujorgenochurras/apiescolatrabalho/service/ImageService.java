package io.github.seujorgenochurras.apiescolatrabalho.service;

import io.github.seujorgenochurras.apiescolatrabalho.respository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

   @Autowired
   private ImageRepository imageRepository;



}
