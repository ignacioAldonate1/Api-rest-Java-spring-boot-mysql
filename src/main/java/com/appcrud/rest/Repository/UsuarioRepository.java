package com.appcrud.rest.Repository;

import com.appcrud.rest.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
