package com.portafolio.msusuario.feignclients;

import com.portafolio.msusuario.domain.Experiences;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "ms-experiencias", url = "http://localhost:9092/")
public interface ExperienciaFeignClient {

    @GetMapping("/experiencia/{userId}")
    List<Experiences> obtenerExperienciasUsuario(@PathVariable Long userId);
}
