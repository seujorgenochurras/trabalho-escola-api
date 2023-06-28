package io.github.seujorgenochurras.apiescolatrabalho.respository;

import io.github.seujorgenochurras.apiescolatrabalho.domain.SimpleStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleStudentRepository extends JpaRepository<SimpleStudent, String> {
}
