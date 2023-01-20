/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.prueba_velecela_8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 59398
 */
@Getter
@Setter
@Entity
public class Asignatura implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @NotNull
  private Integer id;
  @Column(name = "nombre")
  @NotBlank(message = "400 Bad Request")
  private String nombre;
  @Column(name = "carrera")
  @NotBlank(message = "400 Bad Request")
  private String carrera;
  @Column(name = "hora_ini")
  @NotBlank(message = "400 Bad Request")
  private String hora_ini;
  @Column(name = "hora_fin")
  @NotBlank(message = "400 Bad Request")
  private String hora_fin;
  @ManyToOne
  @JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
  private Docente docente;
  

  
  
}
