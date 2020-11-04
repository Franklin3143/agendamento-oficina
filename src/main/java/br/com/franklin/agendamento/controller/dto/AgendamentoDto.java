package br.com.franklin.agendamento.controller.dto;

import br.com.franklin.agendamento.modelo.Agendamento;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.modelo.StatusAgendamento;
import br.com.franklin.agendamento.modelo.Usuario;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AgendamentoDto {

    private Long id;
    private LocalDateTime dataCriacao;
    private String nomeCliente;
    private StatusAgendamento statusAgendamento;

    public AgendamentoDto() {
    }

    public AgendamentoDto (Agendamento agendamento) {
        this.id = agendamento.getId();
        this.dataCriacao = agendamento.getDataCriacao();
        this.nomeCliente = agendamento.getNomeCliente();
        this.statusAgendamento = agendamento.getStatusAgendamento();
    }

    public static AgendamentoDto create(Agendamento a) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(a,AgendamentoDto.class);
    }

    public static List<AgendamentoDto> converter(List<Agendamento> agendamentos) {
        return agendamentos.stream().map(AgendamentoDto::new).collect(Collectors.toList());
    }

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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }
}
