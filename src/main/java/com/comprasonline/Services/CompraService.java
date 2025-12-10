package com.comprasonline.Services;

import org.springframework.stereotype.Service;
import com.comprasonline.Model.Compra;
import com.comprasonline.Repository.CompraRepository;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    public Compra salvar(Compra compra) {
        return repository.save(compra);
    }

    public List<Compra> listar() {
        return repository.findAll();
    }

    public Compra buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
            





}
