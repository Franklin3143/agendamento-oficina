package br.com.franklin.agendamento.service;

import br.com.franklin.agendamento.controller.dto.CarrosDto;
import br.com.franklin.agendamento.modelo.Carros;
import br.com.franklin.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class CarrosService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public CarrosDto insert (Carros carros) {
        Assert.isNull(carros.getId(), "Não foi possível inserir registo de veículo!!");
        return CarrosDto.create(agendamentoRepository.save(carros));
    }

    public void delete(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public CarrosDto update(Carros carros, Long id) {
        Assert.notNull(id,"Não foi possível atualizar registro");

        Optional<Carros> optional = agendamentoRepository.findById(id);
        if (optional.isPresent()) {
            Carros db = optional.get();
            db.setNome(carros.getNome());
            db.setMarca(carros.getMarca());
            db.setMontadora(carros.getMontadora());

            agendamentoRepository.save(db);

            return CarrosDto.create(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar registro!!");
        }
    }
}
