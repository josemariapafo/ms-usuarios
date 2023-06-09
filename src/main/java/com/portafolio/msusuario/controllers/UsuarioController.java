package com.portafolio.msusuario.controllers;

import com.portafolio.msusuario.domain.Experiences;
import com.portafolio.msusuario.domain.Skill;
import com.portafolio.msusuario.domain.User;
import com.portafolio.msusuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{nombre}")
    public ResponseEntity<User> obtenerUsuarioPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok().body(usuarioService.obtenerUsuario(nombre));
    }

    @GetMapping("/habilidades/{nombre}")
    public ResponseEntity<Set<Skill>> obtenerSkillsPorUsuarioNombre(@PathVariable String nombre) {
        return ResponseEntity.ok().body(usuarioService.obtenerSkillsPorUsuario(nombre));
    }

    @GetMapping("/experiencias")
    public ResponseEntity<List<Experiences>> obtenerSkillsPorUsuarioNombre() {
        return ResponseEntity.ok().body(usuarioService.obtenerExperiences());
    }

    @GetMapping("/experiencias/{userId}")
    public ResponseEntity<List<Experiences>> obtenerSkillsPorUsuarioNombre(@PathVariable Long userId) {
        return ResponseEntity.ok().body(usuarioService.obtenerTodasLasExperienciasPorUsuarioID(userId));
    }
}
