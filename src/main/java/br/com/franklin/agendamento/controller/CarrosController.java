package br.com.franklin.agendamento.controller;

import br.com.franklin.agendamento.controller.dto.CarrosDto;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.repository.CarrosRepository;
import br.com.franklin.agendamento.service.CarrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarrosController {

    @Autowired
    private CarrosRepository carrosRepository;

    @Autowired
    private CarrosService carrosService;

    @GetMapping
    public List<CarrosDto> listar () {
            List<Carros> carros = carrosRepository.findAll();
            return CarrosDto.converter(carros);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<CarrosDto> listarCarroPorId(@PathVariable ("id") Long id) {
        Optional<Carros> carros = carrosRepository.findById(id);
        if (carros.isPresent()) {
            return ResponseEntity.ok(new CarrosDto(carros.get()));
        }
        return ResponseEntity.notFound().build();
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

    @PutMapping("/{id}")
    public ResponseEntity atualizarCarro(@PathVariable("id") Long id, @RequestBody Carros carros) {
        carros.setId(id);
        CarrosDto c = carrosService.update(carros, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCarro(@PathVariable("id") Long id) {
        carrosService.delete(id);

        return ResponseEntity.ok().build();
    }




}
