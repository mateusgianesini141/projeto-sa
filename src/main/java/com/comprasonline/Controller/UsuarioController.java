package com.comprasonline.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.comprasonline.Services.UsuarioService;
import com.comprasonline.dto.UsuarioRequestDTO;
import com.comprasonline.dto.UsuarioResponseDTO;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // LISTAR USUÁRIOS
    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.listar();
    }

    // SALVAR USUÁRIO
    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.salvar(dto);
    }

    // EXCLUIR USUÁRIO
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return "Usuário excluído com sucesso!";
    }
}