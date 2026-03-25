package com.comprasonline.Services;

import java.util.List;
import java.util.Optional;
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
        return (List<LojaOnlineResponseDTO>) ((Object) repository.findAll());
                
               
    }

    // ✅ SALVAR
    public LojaOnlineResponseDTO salvar1(LojaOnline dto) {
        LojaOnline loja = toEntity(dto);
        loja = repository.save(loja);
        return toDTO(loja);
    }


    private LojaOnlineResponseDTO toDTO(LojaOnline loja) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

    private LojaOnline toEntity(LojaOnline dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    // ✅ BUSCAR
    public Optional<LojaOnline> buscarPorId(Long id) {
        return repository.findById(id);
               
                
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

    public Object salvar11(LojaOnline loja1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    public void salvar1(LojaOnlineRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    public <T extends Object> T salvar(LojaOnlineRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

}
