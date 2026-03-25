package com.comprasonline.dto;

import java.time.LocalDate;

public class CompraResponseDTO {
    
     private Long id;
    private Long usuarioId;
    private Long lojaId;
    private Double valor;

    public CompraResponseDTO() {
    }

    public CompraResponseDTO(LocalDate data, Double valor, Long usuarioId, Long lojaId) {
      
        this.valor = valor;
        this.usuarioId = usuarioId;
        this.lojaId = lojaId;
    }

    public Long getId() {
        return id;
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
