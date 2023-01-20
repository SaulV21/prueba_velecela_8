/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.prueba_velecela_8.controller;

import ista.edu.practica.prueba_velecela_8.model.Docente;
import ista.edu.practica.prueba_velecela_8.service.DocenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    DocenteService docenteService;
    

    @GetMapping("/listar")
    public ResponseEntity< List<Docente>> obtenerLista() {
        return new ResponseEntity<>(docenteService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Docente> crear(@RequestBody Docente c){
     return new ResponseEntity<>(docenteService.save(c), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Docente> eliminar(@PathVariable Integer id) {
        docenteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable Integer id, @RequestBody Docente c) {
        Docente docente = docenteService.findById(id);
        if (docente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                docente.setNombre(c.getNombre());
                docente.setApellido(c.getApellido());
                docente.setCelular(c.getCelular());
                docente.setEmail(c.getEmail());
                return new ResponseEntity<>(docenteService.save(docente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
