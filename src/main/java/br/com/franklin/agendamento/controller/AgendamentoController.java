package br.com.franklin.agendamento.controller;

import br.com.franklin.agendamento.controller.dto.AgendamentoDto;
import br.com.franklin.agendamento.modelo.Agendamento;
import br.com.franklin.agendamento.repository.AgendamentoRepository;
import br.com.franklin.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<AgendamentoDto> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return AgendamentoDto.converter(agendamentos);
    }

    @PostMapping
    public ResponseEntity  criarAgendamento(@RequestBody Agendamento agendamento) {
        AgendamentoDto ag = agendamentoService.insert(agendamento);
        URI location = getURI(ag.getId());
        return ResponseEntity.created(location).build();
    }

    private URI getURI(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity alteraAgendamento(@PathVariable("id") Long id, @RequestBody Agendamento agendamento) {
        agendamento.setId(id);
        AgendamentoDto a = agendamentoService.update(agendamento, id);
        return a != null ?
                ResponseEntity.ok(a) :
                ResponseEntity.notFound().build();
    }
}
