package com.comprasonline.Services;

import java.util.List;
import java.util.stream.Collectors;

import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
import com.comprasonline.Exception.UsuarioException;
import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.UsuarioRepository;
import com.comprasonline.dto.UsuarioDTO;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //  LISTAR
    public List<UsuarioDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //  SALVAR
    public UsuarioDTO salvar(UsuarioDTO dto) {
        Usuario usuario = toEntity(dto);
        usuario = repository.save(usuario);
        return toDTO(usuario);
    }

    private Usuario toEntity(UsuarioDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    //  EXCLUIR
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    //  BUSCAR
    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioException("Usuário não encontrado com id: " + id));

        return toDTO(usuario);
    }

    //  ATUALIZAR
    public UsuarioDTO atualizar(Long id, Usuario atualizado) {
        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new UsuarioException("Usuário não encontrado com id: " + id));

        usuarioExistente.setNome(atualizado.getNome());
        usuarioExistente.setEmail(atualizado.getEmail());

        usuarioExistente = repository.save(usuarioExistente);

        return toDTO(usuarioExistente);
    }

    private UsuarioDTO toDTO(Usuario usuarioExistente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toDTO'");
    }

    public Usuario salvar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    public Usuario atualizar(long id, Usuario atualizado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    
}