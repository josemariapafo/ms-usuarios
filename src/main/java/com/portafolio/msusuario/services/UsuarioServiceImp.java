package com.portafolio.msusuario.services;

import com.portafolio.msusuario.domain.Experiences;
import com.portafolio.msusuario.domain.Skill;
import com.portafolio.msusuario.domain.User;
import com.portafolio.msusuario.domain.UserRepository;
import com.portafolio.msusuario.exceptions.UsuarioNoEncontradoException;
import com.portafolio.msusuario.feignclients.ExperienciaFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExperienciaFeignClient experienciaFeignClient;

    @Override
    public User obtenerUsuario(String nombre) {

        Optional<User> usuario = userRepository.findByNombre(nombre);

        if(!usuario.isPresent()) {
            throw new UsuarioNoEncontradoException();
        }
        return usuario.get();
    }

    @Override
    public Set<Skill> obtenerSkillsPorUsuario(String nombre) {

        Optional<User> usuario = userRepository.findByNombre(nombre);

        System.out.print(usuario.get().getSkills());

        if(!(usuario.get().getSkills().size() > 0)) {
            throw new UsuarioNoEncontradoException();
        }
        return usuario.get().getSkills();
    }

    @Override
    public List<Experiences> obtenerExperiences() {

        List<Experiences> experiences = restTemplate.getForObject("http://localhost:9092/experiencia",List.class);
        return experiences;
    }

    @Override
    public List<Experiences> obtenerTodasLasExperienciasPorUsuarioID(Long usuarioId) {
        return experienciaFeignClient.obtenerExperienciasUsuario(usuarioId);
    }
}
