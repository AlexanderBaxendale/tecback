package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.service.GeneroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/genero")
@RequiredArgsConstructor
public class GeneroController {

        private final GeneroService generoService;

        @GetMapping
        public List<Genero> listar() {
            return generoService.listar();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Genero> buscarPorId(@PathVariable Long id) {
            try {
                return ResponseEntity.ok(generoService.buscarPorId(id));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public ResponseEntity<Genero> criar(@Valid @RequestBody Genero genero) {
            Genero generoSalvo = generoService.salvar(genero);
            return ResponseEntity.ok(generoSalvo);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            try {
                generoService.excluir(id);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

}
