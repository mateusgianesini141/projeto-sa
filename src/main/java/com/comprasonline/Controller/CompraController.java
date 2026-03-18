package com.comprasonline.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprasonline.Services.CompraService;
import com.comprasonline.dto.CompraRequestDTO;
import com.comprasonline.dto.CompraResponseDTO;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    public CompraResponseDTO salvarCompra(@RequestBody CompraRequestDTO compraRequestDto) {
        return service.salvarCompra(compraRequestDto);
    }

    @GetMapping
    public List<CompraResponseDTO> listarCompras() {
        return service.listarCompras();
    }

    @GetMapping("/{id}")
    public CompraResponseDTO buscarCompra(@PathVariable Long id) {
        return service.buscarCompra(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirCompra(@PathVariable Long id) {
        service.excluirCompra(id);
    }
}
