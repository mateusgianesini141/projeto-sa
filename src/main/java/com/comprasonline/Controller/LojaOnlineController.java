package com.comprasonline.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Services.LojaOnlineService;
import com.comprasonline.dto.LojaOnlineRequestDTO;
import com.comprasonline.dto.LojaOnlineResponseDTO;

@RestController
@RequestMapping("/lojas")
@CrossOrigin(origins = "*")
public class LojaOnlineController {

    private final LojaOnlineService lojaService;

    public LojaOnlineController(LojaOnlineService lojaService) {
        this.lojaService = lojaService;
    }

    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<LojaOnlineResponseDTO>> listar() {
        return ResponseEntity.ok(lojaService.listar());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<LojaOnline>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(lojaService.buscarPorId(id));
    }

    // SALVAR (SEM ID)
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody LojaOnlineRequestDTO dto) {
        return (ResponseEntity<Object>) ResponseEntity.ok();
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        lojaService.excluirPorId(id);
        return ResponseEntity.ok("Loja excluída com sucesso!");
    }
}