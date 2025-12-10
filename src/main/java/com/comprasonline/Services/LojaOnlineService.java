package com.comprasonline.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Repository.LojaOnlineRepository;

@Service
public class LojaOnlineService {

    @Autowired
    private LojaOnlineRepository repository;

    public List<LojaOnline> listar() {
        return repository.findAll();
    }

    public LojaOnline salvar(LojaOnline loja) {
        return repository.save(loja);
    }

    public void excluirPorId(Long id) {
        repository.deleteById(id);
    }

    public LojaOnline buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public LojaOnline atualizar(Long id, LojaOnline lojaAtualizada) {
        LojaOnline lojaExistente = repository.findById(id).orElse(null);
        if (lojaExistente != null) {
            lojaExistente.setNome(lojaAtualizada.getNome());
            lojaExistente.setEndereco(lojaAtualizada.getEndereco());
            // Atualize outros campos conforme necessário

            return repository.save(lojaExistente);
        }
        return null;
    }
}
