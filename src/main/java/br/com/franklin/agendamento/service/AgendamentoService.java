package br.com.franklin.agendamento.service;

import br.com.franklin.agendamento.controller.dto.AgendamentoDto;
import br.com.franklin.agendamento.modelo.Agendamento;
import br.com.franklin.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public AgendamentoDto insert(Agendamento agendamento) {
        Assert.isNull(agendamento.getId(), "Não foi possível criar agendamento!!");
        return AgendamentoDto.create(agendamentoRepository.save(agendamento));
    }

    public AgendamentoDto update(Agendamento agendamento, Long id) {
        Assert.notNull(id, "Não foi possível atualizar registro");

        Optional<Agendamento> optional = agendamentoRepository.findById(id);
        if (optional.isPresent()) {
            Agendamento db = optional.get();
            db.setDataAgendamento(agendamento.getDataAgendamento());
            db.setModeloCarro(agendamento.getModeloCarro());
            db.setNomeCliente(agendamento.getNomeCliente());
            db.setStatusAgendamento(agendamento.getStatusAgendamento());

            agendamentoRepository.save(db);

            return AgendamentoDto.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar registro!!");
        }
    }
}
