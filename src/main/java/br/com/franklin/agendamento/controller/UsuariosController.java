package br.com.franklin.agendamento.controller;

import br.com.franklin.agendamento.controller.dto.UsuarioDto;
import br.com.franklin.agendamento.modelo.Usuario;
import br.com.franklin.agendamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody Usuario usuario) {
        UsuarioDto u = usuarioService.insert(usuario);
        URI location = getURI(u.getId());
        return ResponseEntity.created(location).build();
    }

    private URI getURI(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
