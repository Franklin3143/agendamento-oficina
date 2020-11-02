package br.com.franklin.agendamento.controller;

import br.com.franklin.agendamento.controller.dto.CarrosDto;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<CarrosDto> listar () {
            List<Carros> carros = agendamentoRepository.findAll();
            return CarrosDto.converter(carros);
    }



}
