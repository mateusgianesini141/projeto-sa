package com.comprasonline.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CompraResponseDTO> salvar(@RequestBody CompraRequestDTO dto) {
        return ResponseEntity.ok(service.salvarCompra(dto));
    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarCompra(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        service.excluirCompra(id);
        return ResponseEntity.ok("Compra excluída com sucesso!");
    }
}