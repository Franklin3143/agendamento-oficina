package br.com.franklin.agendamento.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated
    private StatusAgendamento statusAgendamento = StatusAgendamento.ABERTO;

    @ManyToOne
    private Usuario nomeCliente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Usuario getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(Usuario nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
