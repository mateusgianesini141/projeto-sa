package com.comprasonline.services;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Model.Usuario;
import com.comprasonline.Services.CompraService;
import com.comprasonline.dto.CompraDTO;

@SpringBootTest
@Transactional
class CompraServiceIntegrationTest {

    @Autowired
    private CompraService Service;

    @Test
    @DisplayName("Deve salvar uma compra com sucesso")
    void salvarCompra() {

        // criar e salvar dependências
        Usuario usuario = new Usuario();
        usuario.setNome("Mateus");
        
        LojaOnline loja = new LojaOnline();
        loja.setNome("Amazon");
      

        CompraDTO dto = new CompraDTO();
        dto.setData(LocalDate.now());
        dto.setValor(250.0);
        dto.setUsuarioId(usuario.getId());
        dto.setLojaId(loja.getId());
}

    @Test
    @DisplayName("Deve listar compras")
    void listarCompras() {
        List<CompraDTO> compras = Service.listar(); // again, lowercase
       
    }
    
    @Test
    @DisplayName("Deve buscar compra por ID")
    void buscarCompraPorId() {
        Usuario usuario = new Usuario();
        usuario.setNome("Mateus");
       
        LojaOnline loja = new LojaOnline();
        loja.setNome("Mercado Livre");
       

        CompraDTO dto = new CompraDTO();
        dto.setData(LocalDate.now());
        dto.setValor(500.0);
        dto.setUsuarioId(usuario.getId());
        dto.setLojaId(loja.getId());

    }

}


