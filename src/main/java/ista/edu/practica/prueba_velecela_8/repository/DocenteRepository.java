/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ista.edu.practica.prueba_velecela_8.repository;

import ista.edu.practica.prueba_velecela_8.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 59398
 */
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

    @Query(value = "Select * from cliente c where c.cedula = :cedula", nativeQuery = true)
    public Docente buscarCliente(String cedula);
}
