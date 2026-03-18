package com.comprasonline.services;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Services.LojaOnlineService;

import com.comprasonline.dto.LojaOnlineResponseDTO;

        
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@SpringBootTest
@Transactional
class LojaOnlineServiceIntegrationTest {

    @Autowired
    private LojaOnlineService service;

    @Test
    @DisplayName("Deve salvar uma loja online com sucesso")
    void deveSalvarLojaComSucesso() {
        LojaOnline loja = new LojaOnline();
        loja.setNome("Amazon");
        loja.setUrl("www.amazon.com");
        loja.setCategoria("E-commerce");
    }
        
    @Test
    @DisplayName("Deve listar lojas cadastradas")
    void deveListarLojas() {
        LojaOnline loja1 = new LojaOnline();
        loja1.setNome("Shopee");
        loja1.setUrl("www.shopee.com");
        loja1.setCategoria("Marketplace");

        LojaOnline loja2 = new LojaOnline();
        loja2.setNome("Mercado Livre");
        loja2.setUrl("www.mercadolivre.com");
        loja2.setCategoria("Marketplace");
        List<LojaOnlineResponseDTO> lojas = service.listar();
 }

    @Test
    @DisplayName("Deve buscar loja por ID")
    void deveBuscarLojaPorId() {
        LojaOnline loja = new LojaOnline();
        loja.setNome("Magalu");
        loja.setUrl("www.magazineluiza.com");
        loja.setCategoria("E-commerce");
    }

    @Test
    @DisplayName("Deve deletar loja com sucesso")
    void deveDeletarLojaComSucesso() {
        LojaOnlineResponseDTO loja = new LojaOnlineResponseDTO();
        loja.setNome("Ebay");
        loja.setEmail("www.ebay.com");
        loja.setCategoria("Marketplace");
            
    }
}
       
       

        

   