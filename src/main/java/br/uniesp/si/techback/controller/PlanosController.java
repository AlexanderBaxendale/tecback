package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.Planos;
import br.uniesp.si.techback.service.PlanosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Planos")
@RequiredArgsConstructor
public class PlanosController {

    private final PlanosService planosService;

    @GetMapping
    public List<Planos> listar() {
        return planosService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planos> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(planosService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Planos> criar(@Valid @RequestBody Planos planos) {
        Planos planosSalvo = planosService.salvar(planos);
        return ResponseEntity.ok(planosSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planos> atualizar(@PathVariable Long id, @Valid @RequestBody Planos planos) {
        try {
            Planos usuarioAtualizado = planosService.atualizar(id, planos);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            planosService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
