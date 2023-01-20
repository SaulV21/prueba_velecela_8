/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.prueba_velecela_8.service;

import ista.edu.practica.prueba_velecela_8.model.Asignatura;
import ista.edu.practica.prueba_velecela_8.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class AsignaturaServiceImpl extends GenericServiceImpl<Asignatura, Integer> implements AsignaturaService {

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public CrudRepository<Asignatura, Integer> getDao() {
        return asignaturaRepository;
    }

}
