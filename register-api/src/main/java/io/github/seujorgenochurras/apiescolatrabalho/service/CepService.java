package io.github.seujorgenochurras.apiescolatrabalho.service;


import com.google.gson.Gson;
import io.github.seujorgenochurras.apiescolatrabalho.domain.CEP;
import io.github.seujorgenochurras.apiescolatrabalho.exception.CepNotFoundException;
import io.github.seujorgenochurras.apiescolatrabalho.respository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CepService {
   @Autowired
   private CepRepository cepRepository;

   public CEP fetchCep(String cep) {
      return cepRepository.findById(cep).orElse(requestAndSaveCep(cep));
   }

   private CEP requestAndSaveCep(String cep) {
      Gson gson = new Gson();
      try {
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(new URI("https://brasilapi.com.br/api/cep/v1/" + cep))
                 .version(HttpClient.Version.HTTP_2)
                 .GET()
                 .build();
         HttpClient httpClient = HttpClient.newHttpClient();
         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
         if(response.statusCode() != 200){
            throw new CepNotFoundException("Cep '" + cep + "' not found");
         }
         CEP cepFound = gson.fromJson(response.body(), CEP.class);
         return save(cepFound);

      } catch (URISyntaxException | IOException | InterruptedException e) {
         e.printStackTrace();
      }
      return null;
   }

   public CEP save(CEP cep){
     return cepRepository.save(cep);
   }
}
