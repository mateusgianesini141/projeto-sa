package com.comprasonline.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Repository.LojaOnlineRepository;
import com.comprasonline.dto.LojaOnlineDTO;

@Service
public class LojaOnlineService {

    private final LojaOnlineRepository repository;

    public LojaOnlineService(LojaOnlineRepository repository) {
        this.repository = repository;
    }

    // ✅ LISTAR
    public List<LojaOnlineDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ SALVAR
    public LojaOnlineDTO salvar(LojaOnline loja2) {
        LojaOnline loja = toEntity(loja2);
        loja = repository.save(loja);
        return toDTO(loja);
    }

    private LojaOnline toEntity(LojaOnline loja2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    // ✅ BUSCAR
    public LojaOnlineDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // ✅ EXCLUIR
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    // ✅ ATUALIZAR
    public LojaOnlineDTO atualizar(Long id, LojaOnlineDTO dto) {
        LojaOnline lojaExistente = repository.findById(id).orElse(null);

        if (lojaExistente != null) {
            lojaExistente.setNome(dto.getNome());
            lojaExistente.setEndereco(dto.getEndereco());

            lojaExistente = repository.save(lojaExistente);
            return toDTO(lojaExistente);
        }

        return null;
    }

    private LojaOnlineDTO toDTO(LojaOnline lojaExistente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

}