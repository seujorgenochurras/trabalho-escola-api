package io.github.seujorgenochurras.apiescolatrabalho.service;


import com.google.gson.Gson;
import io.github.seujorgenochurras.apiescolatrabalho.domain.CEP;
import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import io.github.seujorgenochurras.apiescolatrabalho.exception.CepNotFoundException;
import io.github.seujorgenochurras.apiescolatrabalho.respository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class CepService {
    @Autowired
    private CepRepository cepRepository;

    public CEP fetchCep(String cep) {
        return cepRepository.findById(cep).orElse(requestCep(cep));
    }

    private CEP requestCep(String cep) {
        Gson gson = new Gson();
        try {
            URL url = new URL("https://brasilapi.com.br/api/cep/v1/" + cep);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            connection.disconnect();
            if(responseCode != 200){
                throw new CepNotFoundException("Cep " + cep + " not found");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return gson.fromJson(response.toString(), CEP.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
