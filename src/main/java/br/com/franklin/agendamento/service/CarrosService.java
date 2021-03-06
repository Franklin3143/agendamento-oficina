package br.com.franklin.agendamento.service;

import br.com.franklin.agendamento.controller.dto.CarrosDto;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepository carrosRepository;

    public CarrosDto insert (Carros carros) {
        Assert.isNull(carros.getId(), "Não foi possível inserir registo de veículo!!");
        return CarrosDto.create(carrosRepository.save(carros));
    }

    public void delete(Long id) {
        carrosRepository.deleteById(id);
    }

    public CarrosDto update(Carros carros, Long id) {
        Assert.notNull(id,"Não foi possível atualizar registro");

        Optional<Carros> optional = carrosRepository.findById(id);
        if (optional.isPresent()) {
            Carros db = optional.get();
            db.setNome(carros.getNome());
            db.setMarca(carros.getMarca());
            db.setMontadora(carros.getMontadora());

            carrosRepository.save(db);

            return CarrosDto.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar registro!!");
        }
    }

//    public CarrosDto getCarroById(Long id) throws ObjectNotFoundException {
//        Optional<Carros> carros = agendamentoRepository.findById(id);
//
//        return carros.map(CarrosDto::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
//    }
}
