package com.comprasonline.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comprasonline.Exception.UsuarioException;
import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.UsuarioRepository;
import com.comprasonline.Services.UsuarioService;
import com.comprasonline.dto.UsuarioDTO;


import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class UsuarioServiceIntegrationTest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

     @BeforeEach
    void setup() {
        usuarioRepository.deleteAll();

        usuario = new Usuario();
        usuario.setNome("Mateus");
        usuario.setEmail("mateus@email.com");

        usuario = usuarioRepository.save(usuario);
    }
    @Test
@DisplayName("Deve salvar um usuário com sucesso")
void deveSalvarUsuarioComSucesso() {

    // Arrange
    Usuario novo = new Usuario();
    novo.setNome("João");
    novo.setEmail("joao@email.com");
}


      @Test
    @DisplayName("Deve listar usuários com sucesso")
    void deveListarUsuariosComSucesso() {

       }
      @Test
    @DisplayName("Deve buscar usuário por id com sucesso")
    void deveBuscarUsuarioPorIdComSucesso() {
     Object encontrado = null;
        
       
    }
  @Test
    @DisplayName("Deve atualizar usuário com sucesso")
    void deveAtualizarUsuarioComSucesso() {

        Usuario atualizado = new Usuario();
        atualizado.setNome("Mateus Silva");
        atualizado.setEmail("mateus.silva@email.com");
}
      @Test
    @DisplayName("Deve lançar exceção ao atualizar usuário inexistente")
    void deveLancarExcecaoAoAtualizarUsuarioInexistente() {

        Usuario atualizado = new Usuario();
        atualizado.setNome("Teste");
        atualizado.setEmail("teste@email.com");

        }
       @Test
    @DisplayName("Deve excluir usuário com sucesso")
    void deveExcluirUsuarioComSucesso() {

        usuarioService.excluir(usuario.getId());

        Usuario resultado = usuarioRepository.findById(usuario.getId()).orElse(null);

        assertNull(resultado);
    }
}

