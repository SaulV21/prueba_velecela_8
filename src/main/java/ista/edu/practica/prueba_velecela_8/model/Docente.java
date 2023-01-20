/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.prueba_velecela_8.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
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
public class Docente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer id_docente;
    @Column(name = "nombre")
    @NotBlank(message = "400 Bad Request")
    private String nombre;
    @Column(name = "apellido")
    @NotBlank(message = "400 Bad Request")
    private String apellido;
    @Column(name = "celular")
    @NotBlank(message = "400 Bad Request")
    private String celular;
    @Column(name = "email")
    @NotBlank(message = "400 Bad Request")
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;
 

}
