package com.comprasonline.Services;

import org.springframework.stereotype.Service;
import com.comprasonline.Model.Compra;
import com.comprasonline.Repository.CompraRepository;
import com.comprasonline.dto.CompraDTO;

    
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraService {

    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    // ✅ SALVAR
    public CompraDTO salvar1(CompraDTO dto) {
        Compra compra = toEntity(dto);
        compra = repository.save(compra);
        return toDTO(compra);
    }

    // ✅ LISTAR
    public List<CompraDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ BUSCAR
    public CompraDTO buscar(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // ✅ EXCLUIR
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    // =============================
    // MÉTODOS DE CONVERSÃO
    // =============================

    private Compra toEntity(CompraDTO dto) {
        Compra compra = new Compra();
        compra.setId(dto.getId());
        compra.setData(dto.getData());
        compra.setValor(dto.getValor());
        // ajuste se tiver relacionamento com Usuario e Loja
        return compra;
    }

    private CompraDTO toDTO(Compra compra) {
        return new CompraDTO(
                compra.getId(),
                compra.getData(),
                compra.getValor(),
                null, // usuarioId (ajuste se tiver relacionamento)
                null  // lojaId (ajuste se tiver relacionamento)
        );
    }

    public CompraDTO buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    public CompraDTO Salvar(CompraDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Salvar'");
    }

    public List<CompraDTO> Listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Listar'");
    }

    public CompraDTO Buscar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Buscar'");
    }

    public Compra salvar1(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    public CompraDTO salvar(CompraDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }
}
