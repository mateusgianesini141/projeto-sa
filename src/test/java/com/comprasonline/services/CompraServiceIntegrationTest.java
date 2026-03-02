package com.comprasonline.services;

import com.comprasonline.Model.Compra;
import com.comprasonline.Model.Usuario;
import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Services.CompraService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CompraServiceIntegrationTest {

    @Autowired
    private CompraService service;

    @Test
    @DisplayName("Deve salvar uma compra com sucesso")
    void deveSalvarCompraComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setNome("Mateus");

        LojaOnline loja = new LojaOnline();
        loja.setNome("Amazon");

        Compra compra = new Compra();
        compra.setQuantidade(2);
        compra.setTotal(7000.00);
        compra.setStatus("PENDENTE");
        compra.setUsuario(usuario);
        compra.setLoja(loja);

        Compra compraSalva = service.salvar(compra);

        assertNotNull(compraSalva.getId());
        assertEquals(2, compraSalva.getQuantidade());
        assertEquals(7000.00, compraSalva.getTotal(), 0.01);
        assertEquals("PENDENTE", compraSalva.getStatus());
        assertEquals("Mateus", compraSalva.getUsuario().getNome());
        assertEquals("Amazon", compraSalva.getLoja().getNome());
    }

    @Test
    @DisplayName("Deve listar compras cadastradas")
    void deveListarCompras() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");

        LojaOnline loja = new LojaOnline();
        loja.setNome("Mercado Livre");

        Compra compra1 = new Compra();
        compra1.setQuantidade(1);
        compra1.setTotal(2000.00);
        compra1.setStatus("APROVADA");
        compra1.setUsuario(usuario);
        compra1.setLoja(loja);

        Compra compra2 = new Compra();
        compra2.setQuantidade(3);
        compra2.setTotal(4500.00);
        compra2.setStatus("PENDENTE");
        compra2.setUsuario(usuario);
        compra2.setLoja(loja);

        service.salvar(compra1);
        service.salvar(compra2);

        

    

    }

    @Test
    @DisplayName("Deve buscar compra por ID")
    void deveBuscarCompraPorId() {
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");

        LojaOnline loja = new LojaOnline();
        loja.setNome("Shopee");

        Compra compra = new Compra();
        compra.setQuantidade(5);
        compra.setTotal(1000.00);
        compra.setStatus("APROVADA");
        compra.setUsuario(usuario);
        compra.setLoja(loja);

        Compra compraSalva = service.salvar(compra);

        Compra resultado = service.buscar(compraSalva.getId());

        assertNotNull(resultado);
        assertEquals(5, resultado.getQuantidade());
        assertEquals("APROVADA", resultado.getStatus());
        assertEquals("Maria", resultado.getUsuario().getNome());
        assertEquals("Shopee", resultado.getLoja().getNome());
    }

    @Test
    @DisplayName("Deve deletar compra com sucesso")
    void deveDeletarCompraComSucesso() {
        Usuario usuario = new Usuario();
        usuario.setNome("Carlos");

        LojaOnline loja = new LojaOnline();
        loja.setNome("Magalu");

        Compra compra = new Compra();
        compra.setQuantidade(1);
        compra.setTotal(1200.00);
        compra.setStatus("PENDENTE");
        compra.setUsuario(usuario);
        compra.setLoja(loja);

        Compra compraSalva = service.salvar(compra);

        

        Compra resultado = service.buscar(compraSalva.getId());

        
    }
}
