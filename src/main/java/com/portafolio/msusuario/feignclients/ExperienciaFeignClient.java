package com.portafolio.msusuario.feignclients;

import com.portafolio.msusuario.domain.Experiences;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-experiencias")
public interface ExperienciaFeignClient {

    @GetMapping("/experiencia/{userId}")
    List<Experiences> obtenerExperienciasUsuario(@PathVariable Long userId);
}
