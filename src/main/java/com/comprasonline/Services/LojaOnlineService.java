package com.comprasonline.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Repository.LojaOnlineRepository;

import com.comprasonline.dto.LojaOnlineRequestDTO;
import com.comprasonline.dto.LojaOnlineResponseDTO;

@Service
public class LojaOnlineService {

    private final LojaOnlineRepository repository;
    public LojaOnlineRequestDTO buscarLojaOnline;

    public LojaOnlineService(LojaOnlineRepository repository) {
        this.repository = repository;
    }

    // ✅ LISTAR
    public List<LojaOnlineResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ SALVAR
    public LojaOnlineResponseDTO salvar(LojaOnline loja2) {
        LojaOnline loja = toEntity(loja2);
        loja = repository.save(loja);
        return toDTO(loja);
    }

    private LojaOnline toEntity(LojaOnline loja2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    // ✅ BUSCAR
    public LojaOnlineResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // ✅ EXCLUIR
    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    // ✅ ATUALIZAR
    public LojaOnlineResponseDTO atualizar(Long id, LojaOnlineResponseDTO dto) {
        LojaOnline lojaExistente = repository.findById(id).orElse(null);

        if (lojaExistente != null) {
            lojaExistente.setNome(dto.getNome());
            lojaExistente.setEndereco(dto.getEndereco());

            lojaExistente = repository.save(lojaExistente);
            return toDTO(lojaExistente);
        }

        return null;
    }

    private LojaOnlineResponseDTO toDTO(LojaOnline lojaExistente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

    public List<LojaOnlineRequestDTO> listarLojaOnline() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarLojaOnline'");
    }

    public LojaOnlineRequestDTO salvarLojaOnline(LojaOnlineRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarLojaOnline'");
    }

    public LojaOnlineRequestDTO buscarLojaOnline(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLojaOnline'");
    }

}