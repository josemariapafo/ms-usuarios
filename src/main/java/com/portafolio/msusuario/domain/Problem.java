package com.portafolio.msusuario.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Problem {

    private String title;

    private String description;

    private String statusCode;
}
