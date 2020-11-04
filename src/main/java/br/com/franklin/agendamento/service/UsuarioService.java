package br.com.franklin.agendamento.service;

import br.com.franklin.agendamento.controller.dto.UsuarioDto;
import br.com.franklin.agendamento.modelo.Usuario;
import br.com.franklin.agendamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto insert (Usuario usuario) {
        Assert.isNull(usuario.getId(), "Não foi possível Criar usuario");
        return UsuarioDto.create(usuarioRepository.save(usuario));
    }
}
