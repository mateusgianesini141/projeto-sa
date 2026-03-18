package com.comprasonline.Services;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
    
import com.comprasonline.Exception.UsuarioException;
import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.UsuarioRepository;

import com.comprasonline.dto.UsuarioRequestDTO;
import com.comprasonline.dto.UsuarioResponseDTO;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //  LISTAR
    public List<UsuarioResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //  SALVAR
    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        Usuario usuario = toEntity(dto);
        usuario = repository.save(usuario);
        return toDTO(usuario);
    }

    private Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }

    //  EXCLUIR
    public void excluir(Long id) {
        repository.deleteById(id);
    }

    //  BUSCAR
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioException("Usuário não encontrado com id: " + id));

        return toDTO(usuario);
    }

    //  ATUALIZAR
    public UsuarioResponseDTO atualizar(Long id, Usuario atualizado) {
        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new UsuarioException("Usuário não encontrado com id: " + id));

        usuarioExistente.setNome(atualizado.getNome());
        usuarioExistente.setEmail(atualizado.getEmail());

        usuarioExistente = repository.save(usuarioExistente);

        return toDTO(usuarioExistente);
    }

    private UsuarioResponseDTO toDTO(Usuario usuarioExistente) {
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

    public List<UsuarioRequestDTO> listarLojasOnline() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarLojasOnline'");
    }

    
}