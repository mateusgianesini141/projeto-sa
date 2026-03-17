package com.comprasonline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.comprasonline.Exception.UsuarioException;

    
import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.UsuarioRepository;
import com.comprasonline.Services.UsuarioService;
import com.comprasonline.dto.UsuarioDTO;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // -------------------------
    // TESTE listar()
    // -------------------------
    @Test
    void testListarUsuarios() {
        Usuario u1 = new Usuario("Mateus", "mateus@email");
        Usuario u2 = new Usuario("João", "joao@email");

        when(repository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<UsuarioDTO> usuarios = service.listar();

        assertEquals(2, usuarios.size());
        verify(repository, times(1)).findAll();
    }

    // -------------------------
    // TESTE salvar()
    // -------------------------
   @Test
void testSalvarUsuario() {

    // Objeto enviado para salvar
    Usuario usuario = new Usuario();
    usuario.setNome("Carlos");
    usuario.setEmail("carlos@email");

    // Objeto que o mock do save() deve retornar
    Usuario usuarioSalvo = new Usuario();
    usuarioSalvo.setId(1L); // ID simulado
    usuarioSalvo.setNome("Carlos");
    usuarioSalvo.setEmail("carlos@email");

    when(repository.save(usuario)).thenReturn(usuarioSalvo);

    Usuario salvo = service.salvar(usuario);

    assertNotNull(salvo.getId());          
    assertEquals("Carlos", salvo.getNome());
    assertEquals("carlos@email", salvo.getEmail());

    verify(repository, times(1)).save(usuario);
}


    // -------------------------
    // TESTE buscarPorId()
    // -------------------------
    @Test
    void testBuscarPorId() {
        Usuario usuario = new Usuario("Ana", "ana@email");


        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        UsuarioDTO encontrado = service.buscarPorId(1L);

        assertNotNull(encontrado);
        assertEquals("Ana", encontrado.getNome());
    }
        
    // -------------------------
    // TESTE excluir()
    // -------------------------
    @Test
    void testExcluirUsuario() {
        doNothing().when(repository).deleteById(1L);

        service.excluir(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    // -------------------------
    // TESTE atualizar()
    // -------------------------
   @Test
void testAtualizarUsuario() {

    // Usuário existente no "banco"
    Usuario existente = new Usuario();
    existente.setId(1L);
    existente.setNome("Maria");
    existente.setEmail("maria@old");

}
    // -------------------------
    // TESTE atualizar() com exceção
    // -------------------------
    @Test
    void testAtualizarUsuarioNaoEncontrado() {

        when(repository.findById(1L)).thenReturn(Optional.empty());

        Usuario novo = new Usuario(null, "Teste");

    

        
    }
}

