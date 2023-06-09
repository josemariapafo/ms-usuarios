package com.portafolio.msusuario.domain;


import jakarta.persistence.*;

@Entity
public class UserSkill {

    @EmbeddedId
    UserSkillKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User student;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    Skill course;
}
