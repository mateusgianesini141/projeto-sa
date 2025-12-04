package com.comprasonline.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprasonline.Model.Compra;
import com.comprasonline.Services.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService service;

    public CompraController(CompraService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    public Compra salvar(@RequestBody Compra compra) {
        return service.salvar(compra);
    }

    @GetMapping
    public List<Compra> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Compra buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
