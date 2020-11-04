package br.com.franklin.agendamento.repository;

import br.com.franklin.agendamento.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
