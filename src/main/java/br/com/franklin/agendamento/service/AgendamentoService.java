package br.com.franklin.agendamento.service;

import br.com.franklin.agendamento.controller.dto.AgendamentoDto;
import br.com.franklin.agendamento.modelo.Agendamento;
import br.com.franklin.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoDto insert(Agendamento agendamento) {
        Assert.isNull(agendamento.getId(), "Não foi possível criar agendamento!!");
        return AgendamentoDto.create(agendamentoRepository.save(agendamento));
    }
}
