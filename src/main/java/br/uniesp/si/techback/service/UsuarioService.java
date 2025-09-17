package br.uniesp.si.techback.service;
import java.util.List;

import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
}
