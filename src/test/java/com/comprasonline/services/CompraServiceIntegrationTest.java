package com.comprasonline.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Model.Usuario;
import com.comprasonline.Repository.LojaOnlineRepository;
import com.comprasonline.Repository.UsuarioRepository;
import com.comprasonline.Services.CompraService;
import com.comprasonline.dto.CompraRequestDTO;
import com.comprasonline.dto.CompraResponseDTO;

@SpringBootTest
@Transactional
class CompraServiceIntegrationTest {

    @Autowired
    private CompraService service;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LojaOnlineRepository lojaRepository;

    @Test
    @DisplayName("Deve salvar uma compra com sucesso")
    void salvarCompra() {

        Usuario usuario = new Usuario();
        usuario.setNome("Mateus");
        usuario = usuarioRepository.saveAndFlush(usuario);

        LojaOnline loja = new LojaOnline();
        loja.setNome("Amazon");
        loja = lojaRepository.saveAndFlush(loja);

        assertNotNull(usuario.getId());
        assertNotNull(loja.getId());

        CompraRequestDTO dto = new CompraRequestDTO();
        dto.setValor(250.0);
        dto.setUsuarioId(usuario.getId());
        dto.setLojaId(loja.getId());

        CompraResponseDTO resposta = service.salvarCompra(dto);

        assertNotNull(resposta);
      
        assertEquals(250.0, resposta.getValor());
    }

    @Test
    @DisplayName("Deve listar compras")
    void listarCompras() {

        List<CompraResponseDTO> compras = service.listarCompras();

        assertNotNull(compras);
    }

    @Test
    @DisplayName("Deve buscar compra por ID")
    void buscarCompraPorId() {

        Usuario usuario = new Usuario();
        usuario.setNome("Mateus");
        usuario = usuarioRepository.saveAndFlush(usuario);

        LojaOnline loja = new LojaOnline();
        loja.setNome("Mercado Livre");
        loja = lojaRepository.saveAndFlush(loja);

        CompraRequestDTO dto = new CompraRequestDTO();
        dto.setValor(500.0);
        dto.setUsuarioId(usuario.getId());
        dto.setLojaId(loja.getId());

        CompraResponseDTO salva = service.salvarCompra(dto);
        CompraResponseDTO encontrada = service.buscarPorId(salva.getId());
        assertNotNull(encontrada);
        assertEquals(500.0, encontrada.getValor());
    }
}