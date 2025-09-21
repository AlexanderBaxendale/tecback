package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.Favoritos;
import br.uniesp.si.techback.service.FavoritosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Favoritos")
@RequiredArgsConstructor
public class FavoritosController {

    private final FavoritosService favoritosService;

    @GetMapping
    public List<Favoritos> listar() {
        return favoritosService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favoritos> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(favoritosService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Favoritos> criar(@Valid @RequestBody Favoritos favoritos) {
        Favoritos favoritosSalvo = favoritosService.salvar(favoritos);
        return ResponseEntity.ok(favoritosSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favoritos> atualizar(@PathVariable Long id, @Valid @RequestBody Favoritos favoritos) {
        try {
            Favoritos usuarioAtualizado = favoritosService.atualizar(id, favoritos);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            favoritosService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
