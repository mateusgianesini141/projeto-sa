package com.comprasonline.dto;

import java.time.LocalDate;

public class CompraResponseDTO {
    
    private Long id;
    private LocalDate data;
    private Double valor;
    private Long usuarioId;
    private Long lojaId;
    
    public CompraResponseDTO() {
    }

    public CompraResponseDTO(LocalDate data, Double valor, Long usuarioId, Long lojaId) {
        this.data = data;
        this.valor = valor;
        this.usuarioId = usuarioId;
        this.lojaId = lojaId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLojaId() {
        return lojaId;
    }

    public void setLojaId(Long lojaId) {
        this.lojaId = lojaId;
    }

    

}
