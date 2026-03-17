package com.comprasonline.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import com.comprasonline.Model.LojaOnline;
import com.comprasonline.Services.LojaOnlineService;
import com.comprasonline.dto.LojaOnlineDTO;

@RestController
@RequestMapping("/lojas")
public class LojaOnlineController {

    private final LojaOnlineService lojaService;

    public LojaOnlineController(LojaOnlineService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping
    public List<LojaOnlineDTO> listar() {
        return lojaService.listar();
    }

    @PostMapping("/salvar")
    public LojaOnlineDTO salvar(@RequestBody LojaOnline loja) {
        return lojaService.salvar(loja);
    }

    @DeleteMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        lojaService.excluirPorId(id);
        return "Loja excluída com sucesso!";
    }

    @GetMapping("/{id}")
    public LojaOnlineDTO buscar(@PathVariable Long id) {
        return lojaService.buscarPorId(id);
    }
}
