package com.comprasonline.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
