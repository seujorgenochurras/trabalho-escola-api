package io.github.seujorgenochurras.apiescolatrabalho.respository;

import io.github.seujorgenochurras.apiescolatrabalho.domain.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammerRepository extends JpaRepository<Programmer, String> {

}
