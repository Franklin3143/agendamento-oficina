package br.com.franklin.agendamento.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    private Usuario cliente;

    @Enumerated
    private StatusAgendamento statusAgendamento = StatusAgendamento.ABERTO;



    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public Usuario getNomeCliente() {
        return cliente;
    }

}
