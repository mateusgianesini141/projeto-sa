package com.comprasonline.services;

import static org.junit.jupiter.api.Assertions.*;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Services.LojaOnlineService;
import com.comprasonline.dto.LojaOnlineResponseDTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class LojaOnlineServiceIntegrationTest {

    @Autowired
    private LojaOnlineService service;
    private LojaOnline salva;

    @Test
    @DisplayName("Deve salvar uma loja online com sucesso")
    void deveSalvarLojaComSucesso() {

        LojaOnline loja = new LojaOnline();
        loja.setNome("Amazon");
        loja.setUrl("www.amazon.com");
        loja.setCategoria("E-commerce");

        

        Object resposta = null;
        assertNotNull(resposta);
        assertNotNull(((LojaOnline) resposta).getId());
        assertEquals("Amazon", ((LojaOnline) resposta).getNome());
    }

    @Test
    @DisplayName("Deve listar lojas cadastradas")
    void deveListarLojas() {

        LojaOnline loja1 = new LojaOnline();
        loja1.setNome("Shopee");
        loja1.setUrl("www.shopee.com");
        loja1.setCategoria("Marketplace");
        service.salvar1(loja1);

        LojaOnline loja2 = new LojaOnline();
        loja2.setNome("Mercado Livre");
        loja2.setUrl("www.mercadolivre.com");
        loja2.setCategoria("Marketplace");
        service.salvar1(loja2);

        List<LojaOnlineResponseDTO> lojas = service.listar();

        assertNotNull(lojas);
        assertTrue(lojas.size() >= 2);
    }

    @Test
    @DisplayName("Deve buscar loja por ID")
    void deveBuscarLojaPorId() {

        LojaOnline loja = new LojaOnline();
        loja.setNome("Magalu");
        loja.setUrl("www.magazineluiza.com");
        loja.setCategoria("E-commerce");

            

        service.salvar1(loja);
        Optional<LojaOnline> encontrada = service.buscarPorId(salva.getId());
        assertNotNull(encontrada);
        assertEquals("Magalu", encontrada.get().getNome());

    }

    @Test
    @DisplayName("Deve deletar loja com sucesso")
    void deveDeletarLojaComSucesso() {

        LojaOnline loja = new LojaOnline();
        loja.setNome("Ebay");
        loja.setUrl("www.ebay.com");
        loja.setCategoria("Marketplace");

      

      

        service.salvar1(loja);
        service.excluirPorId(salva.getId());
        Optional<LojaOnline> encontrada = service.buscarPorId(salva.getId());

            

        assertNull(encontrada); // ou use assertThrows se seu service lançar exceção
    }
}