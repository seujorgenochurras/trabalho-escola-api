package io.github.seujorgenochurras.apiescolatrabalho.service;


import io.github.seujorgenochurras.apiescolatrabalho.respository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {
   @Autowired
   private CepRepository cepRepository;

}