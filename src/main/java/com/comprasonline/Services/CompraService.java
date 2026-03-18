package com.comprasonline.Services;

import org.springframework.stereotype.Service;
import com.comprasonline.Model.Compra;
import com.comprasonline.Repository.CompraRepository;
import com.comprasonline.dto.CompraRequestDTO;
import com.comprasonline.dto.CompraResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraService {

    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    public CompraResponseDTO salvarCompra(CompraRequestDTO dto) {
        
        Compra compra = toEntity(dto);
        compra = repository.save(compra);
        return toDTO(compra);
    }

    public List<CompraResponseDTO> listarCompras() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CompraResponseDTO buscarCompra(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public void excluirCompra(Long id) {
        repository.deleteById(id);
    }

    private Compra toEntity(CompraRequestDTO dto) {
        Compra compra = new Compra();
        compra.setData(dto.getData());
        compra.setValor(dto.getValor());
        return compra;
    }

    private CompraResponseDTO toDTO(Compra compra) {
        return new CompraResponseDTO(
                compra.getData(),
                compra.getValor(),
                compra.getUsuario() != null ? compra.getUsuario().getId() : null,
                compra.getLoja() != null ? compra.getLoja().getId() : null
        );
    }
}
