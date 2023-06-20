package io.github.seujorgenochurras.apiescolatrabalho.domain;

import io.github.seujorgenochurras.apiescolatrabalho.domain.image.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private @NotNull String userId;

   private String username;
   @ManyToOne
   private Image studentPhoto;

   @OneToOne
   private CEP studentCep;

   @Enumerated(EnumType.STRING)
   private UserRole userRole;

   private OffsetDateTime birthDate;


   public String getUserId() {
      return userId;
   }

   public User setUserId(String userId) {
      this.userId = userId;
      return this;
   }

   public Image getStudentPhoto() {
      return studentPhoto;
   }

   public User setStudentPhoto(Image studentPhoto) {
      this.studentPhoto = studentPhoto;
      return this;
   }

   public User setUsername(String username) {
      this.username = username;
      return this;
   }

   public OffsetDateTime getBirthDate() {
      return birthDate;
   }

   public User setBirthDate(OffsetDateTime birthDate) {
      this.birthDate = birthDate;
      return this;
   }

   public CEP getStudentCep() {
      return studentCep;
   }

   public User setStudentCep(CEP studentCep) {
      this.studentCep = studentCep;
      return this;
   }

   public UserRole getUserRole() {
      return userRole;
   }

   public User setUserRole(UserRole userRole) {
      this.userRole = userRole;
      return this;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority(userRole.name()));
   }

   @Override
   public String getPassword(){
      return "";
   }
   @Override
   public String getUsername() {
      return username;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
}
