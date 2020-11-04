package br.com.franklin.agendamento.controller.dto;

import br.com.franklin.agendamento.modelo.Usuario;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;

    public UsuarioDto() {
    }

    public UsuarioDto (Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public static List<UsuarioDto> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }

    public static UsuarioDto create(Usuario u) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(u, UsuarioDto.class);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


}
