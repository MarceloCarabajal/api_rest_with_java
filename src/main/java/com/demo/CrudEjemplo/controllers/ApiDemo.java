package com.demo.CrudEjemplo.controllers;

import com.demo.CrudEjemplo.model.Usuario;
import com.demo.CrudEjemplo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ApiDemo {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/saludar")
    public String saludar() {
        return "Hola mundo desde spring";
    }

    @GetMapping("/all")
    public ArrayList<Usuario> getAllUser(){
        return usuarioService.getAllUser();
    }

    @GetMapping("/find/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id") long id){
        return usuarioService.getUserById(id);
    }

    @PostMapping("/save")
    public Usuario saveUser(@RequestBody Usuario u){
        return usuarioService.saveUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        if(usuarioService.deleteUserById(id))
            return "Se ha eliminado el usuario";
        else
            return "No se ha eliminado el usuario";
    }

}
