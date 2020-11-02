package br.com.franklin.agendamento.controller;

import br.com.franklin.agendamento.controller.dto.CarrosDto;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.repository.AgendamentoRepository;
import br.com.franklin.agendamento.service.CarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private CarrosService carrosService;

    @GetMapping
    public List<CarrosDto> listar () {
            List<Carros> carros = agendamentoRepository.findAll();
            return CarrosDto.converter(carros);
    }

    @PostMapping
    public ResponseEntity cadastrarNovoCarro(@RequestBody Carros carros) {
        CarrosDto c = carrosService.insert(carros);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).build();
    }
    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCarro(@PathVariable("id") Long id) {
        carrosService.delete(id);

        return ResponseEntity.ok().build();
    }




}
