package br.com.franklin.agendamento.controller.dto;

import br.com.franklin.agendamento.modelo.Carros;

import java.util.List;
import java.util.stream.Collectors;

public class CarrosDto {

    private Long id;
    private String nome;
    private String marca;
    private String montadora;

    public CarrosDto(Carros carros) {
        this.id = carros.getId();
        this.nome = carros.getNome();
        this.marca = carros.getMarca();
        this.montadora = carros.getMontadora();
    }

    public static List<CarrosDto> converter(List<Carros> carros) {
        return carros.stream().map(CarrosDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getMontadora() {
        return montadora;
    }
}
