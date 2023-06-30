package io.github.seujorgenochurras.apiescolatrabalho.respository;

import io.github.seujorgenochurras.apiescolatrabalho.domain.CEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<CEP, String> {
}
