package com.portafolio.msusuario.services;

import com.portafolio.msusuario.domain.Experiences;
import com.portafolio.msusuario.domain.Skill;
import com.portafolio.msusuario.domain.User;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    public User obtenerUsuario(String nombre);

    Set<Skill> obtenerSkillsPorUsuario(String nombre);

    List<Experiences> obtenerExperiences();

    List<Experiences> obtenerTodasLasExperienciasPorUsuarioID(Long usuarioId);
}
