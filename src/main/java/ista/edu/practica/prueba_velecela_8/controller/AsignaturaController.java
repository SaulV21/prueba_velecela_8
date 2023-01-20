package ista.edu.practica.prueba_velecela_8.controller;

import ista.edu.practica.prueba_velecela_8.model.Asignatura;
import ista.edu.practica.prueba_velecela_8.model.Docente;
import ista.edu.practica.prueba_velecela_8.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
        @Autowired
        AsignaturaService asignaturaService;


        @GetMapping("/listar")
        public ResponseEntity<List<Asignatura>> obtenerLista() {
            return new ResponseEntity<>(asignaturaService.findByAll(), HttpStatus.OK);
        }

        @PostMapping("/crear")
        public ResponseEntity<Asignatura> crear(@RequestBody Asignatura c){
            return new ResponseEntity<>(asignaturaService.save(c), HttpStatus.CREATED);
        }

        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity<Asignatura> eliminar(@PathVariable Integer id) {
            asignaturaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("/actualizar/{id}")
        public ResponseEntity<Asignatura> actualizar(@PathVariable Integer id, @RequestBody Asignatura c) {
            Asignatura asig = asignaturaService.findById(id);
            if (asig == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                try {
                    asig.setNombre(c.getNombre());
                    asig.setCarrera(c.getCarrera());
                    asig.setHora_ini(c.getHora_ini());
                    asig.setHora_fin(c.getHora_fin());
                    return new ResponseEntity<>(asignaturaService.save(asig), HttpStatus.CREATED);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }

        }
}
