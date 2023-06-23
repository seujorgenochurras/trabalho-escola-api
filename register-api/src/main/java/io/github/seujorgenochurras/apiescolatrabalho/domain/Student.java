package io.github.seujorgenochurras.apiescolatrabalho.domain;

import io.github.seujorgenochurras.apiescolatrabalho.domain.image.Image;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student extends User {
   @ManyToOne
   private Image studentPhoto;
   @OneToOne
   private CEP studentCep;

   public CEP getStudentCep() {
      return studentCep;
   }

   public Student setStudentCep(CEP studentCep) {
      this.studentCep = studentCep;
      return this;
   }

   public Image getStudentPhoto() {
      return studentPhoto;
   }

   public Student setStudentPhoto(Image studentPhoto) {
      this.studentPhoto = studentPhoto;
      return this;
   }
}
