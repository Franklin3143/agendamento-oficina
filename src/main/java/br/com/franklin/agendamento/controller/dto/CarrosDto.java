package br.com.franklin.agendamento.controller.dto;

import br.com.franklin.agendamento.modelo.Carros;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CarrosDto {

    private Long id;
    private String nome;
    private String marca;
    private String montadora;
    private LocalDateTime dataCriacao;

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
        this.dataCriacao = carros.getDataCriacao();
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
