package io.github.seujorgenochurras.apiescolatrabalho.config;

import io.github.seujorgenochurras.apiescolatrabalho.exception.UserNotFoundException;
import io.github.seujorgenochurras.apiescolatrabalho.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class ApplicationConfig {

   @Autowired
   private UserRepository userRepository;
   @Bean
   public UserDetailsService userDetailsService() {
      return name -> userRepository.findUserByUsername(name)
              .orElseThrow(() -> new UserNotFoundException("User " + name + " not found"));
   }
}
