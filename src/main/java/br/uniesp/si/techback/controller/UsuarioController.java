package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioservice;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioservice.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(usuarioservice.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioservice.salvar(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        try {
            Usuario usuarioAtualizado = usuarioservice.atualizar(id, usuario);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            usuarioservice.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
