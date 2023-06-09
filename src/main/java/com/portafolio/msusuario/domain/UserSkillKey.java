package com.portafolio.msusuario.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
class UserSkillKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "skill_id")
    Long skillId;
}