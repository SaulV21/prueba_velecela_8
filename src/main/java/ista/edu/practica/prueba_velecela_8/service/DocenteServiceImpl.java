/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.prueba_velecela_8.service;

import ista.edu.practica.prueba_velecela_8.model.Docente;
import ista.edu.practica.prueba_velecela_8.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class DocenteServiceImpl extends GenericServiceImpl<Docente, Integer> implements DocenteService {

    @Autowired
    DocenteRepository docenteRepository;

    @Override
    public CrudRepository<Docente, Integer> getDao() {
        return docenteRepository;
    }

    public Docente buscarCliente(String cedula) {
        return docenteRepository.buscarCliente(cedula);
    }

}
