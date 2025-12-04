package com.comprasonline.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCompra = LocalDateTime.now();

    private Double total;

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
