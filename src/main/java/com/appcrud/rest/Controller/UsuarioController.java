package com.appcrud.rest.Controller;

import com.appcrud.rest.Model.Usuario;
import com.appcrud.rest.Repository.UsuarioRepository;
import com.appcrud.rest.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping( path = "/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return  this.usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuario(@PathVariable ("id") long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "usuario id: "+id+" ha sido eliminado";
        }else{
            return "usuario no encontrado";
        }
    }
}
