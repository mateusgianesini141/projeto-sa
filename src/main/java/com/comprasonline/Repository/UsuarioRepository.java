package com.comprasonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comprasonline.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}








