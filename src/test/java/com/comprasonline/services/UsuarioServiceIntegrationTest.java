package com.comprasonline.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.UsuarioRepository;
import com.comprasonline.Services.UsuarioService;


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

        Usuario novo = new Usuario();
        novo.setNome("João");
        novo.setEmail("joao@email.com");

        Usuario salvo = usuarioService.salvar(novo);

        assertNotNull(salvo);
        assertNotNull(salvo.getId());
        assertEquals("João", salvo.getNome());
    }

    @Test
    @DisplayName("Deve listar usuários com sucesso")
    void deveListarUsuariosComSucesso() {

        List<Usuario> usuarios = usuarioService.listar();

        assertNotNull(usuarios);
        assertTrue(usuarios.size() >= 1);
    }

    @Test
    @DisplayName("Deve buscar usuário por id com sucesso")
    void deveBuscarUsuarioPorIdComSucesso() {

        Usuario encontrado = usuarioService.buscarPorId(usuario.getId());

        assertNotNull(encontrado);
        assertEquals(usuario.getId(), encontrado.getId());
    }

    @Test
    @DisplayName("Deve atualizar usuário com sucesso")
    void deveAtualizarUsuarioComSucesso() {

        Usuario atualizado = new Usuario();
        atualizado.setNome("Mateus Silva");
        atualizado.setEmail("mateus.silva@email.com");

        Usuario resultado = usuarioService.atualizar(usuario.getId(), atualizado);

        assertNotNull(resultado);
        assertEquals("Mateus Silva", resultado.getNome());
    }

    @Test
    @DisplayName("Deve lançar exceção ao atualizar usuário inexistente")
    void deveLancarExcecaoAoAtualizarUsuarioInexistente() {

        Usuario atualizado = new Usuario();
        atualizado.setNome("Teste");
        atualizado.setEmail("teste@email.com");

        assertThrows(RuntimeException.class, () -> {
            usuarioService.atualizar(999L, atualizado);
        });
    }

    @Test
    @DisplayName("Deve excluir usuário com sucesso")
    void deveExcluirUsuarioComSucesso() {

        usuarioService.excluir(usuario.getId());

        Usuario resultado = usuarioRepository.findById(usuario.getId()).orElse(null);

        assertNull(resultado);
    }
}