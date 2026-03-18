package com.comprasonline.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.comprasonline.Services.LojaOnlineService;
import com.comprasonline.dto.LojaOnlineRequestDTO;

@RestController
@RequestMapping("/lojas")
@CrossOrigin(origins = "*") // resolve problema de CORS
public class LojaOnlineController {

    private final LojaOnlineService lojaService;

    public LojaOnlineController(LojaOnlineService lojaService) {
        this.lojaService = lojaService;
    }

    // LISTAR TODAS
    @GetMapping
    public List<LojaOnlineRequestDTO> listar() {
        return lojaService.listarLojaOnline();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public LojaOnlineRequestDTO buscar(@PathVariable Long id) {
        return lojaService.buscarLojaOnline(id);
    }

    // SALVAR
    @PostMapping
    public LojaOnlineRequestDTO salvar(@RequestBody LojaOnlineRequestDTO dto) {
        return lojaService.salvarLojaOnline(dto);
        
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        lojaService.excluirPorId(id);
        return "Loja excluída com sucesso!";
    }
}