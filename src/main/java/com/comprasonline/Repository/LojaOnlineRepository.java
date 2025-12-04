package com.comprasonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comprasonline.Model.LojaOnline;

public interface LojaOnlineRepository extends JpaRepository<LojaOnline, Long> {

    // Consultas personalizadas opcionais
    LojaOnline findByNome(String nome);
}
