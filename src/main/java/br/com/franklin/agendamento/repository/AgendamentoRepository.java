package br.com.franklin.agendamento.repository;

import br.com.franklin.agendamento.modelo.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
