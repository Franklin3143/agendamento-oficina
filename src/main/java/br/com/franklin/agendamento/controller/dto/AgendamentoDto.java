package br.com.franklin.agendamento.controller.dto;

import br.com.franklin.agendamento.modelo.Agendamento;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.modelo.StatusAgendamento;
import br.com.franklin.agendamento.modelo.Usuario;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AgendamentoDto {

    private Long id;
    private String nomeCliente;
    private String modeloCarro;
    private String dataAgendamento;
    private LocalDateTime dataCriacao;
    private StatusAgendamento statusAgendamento;

    public AgendamentoDto() {
    }

    public AgendamentoDto (Agendamento agendamento) {
        this.id = agendamento.getId();
        this.nomeCliente = agendamento.getNomeCliente();
        this.modeloCarro = agendamento.getModeloCarro();
        this.dataAgendamento = agendamento.getDataAgendamento();
        this.dataCriacao = agendamento.getDataCriacao();
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
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
}
