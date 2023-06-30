package io.github.seujorgenochurras.apiescolatrabalho.respository;

import io.github.seujorgenochurras.apiescolatrabalho.domain.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
