package br.com.franklin.agendamento.controller.dto;

import br.com.franklin.agendamento.modelo.Carros;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CarrosDto {

    private Long id;
    private String nome;
    private String marca;
    private String montadora;

    public CarrosDto() {
    }

    public CarrosDto(Long id, String nome, String marca, String montadora) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.montadora = montadora;
    }

    public CarrosDto(Carros carros) {
        this.id = carros.getId();
        this.nome = carros.getNome();
        this.marca = carros.getMarca();
        this.montadora = carros.getMontadora();
    }

    public static List<CarrosDto> converter(List<Carros> carros) {
        return carros.stream().map(CarrosDto::new).collect(Collectors.toList());
    }

    public static CarrosDto create(Carros c) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, CarrosDto.class);
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
