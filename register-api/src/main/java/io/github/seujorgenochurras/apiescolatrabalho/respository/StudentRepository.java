package io.github.seujorgenochurras.apiescolatrabalho.respository;

import io.github.seujorgenochurras.apiescolatrabalho.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
