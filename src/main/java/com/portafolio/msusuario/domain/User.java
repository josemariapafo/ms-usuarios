package com.portafolio.msusuario.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder(toBuilder = true)
@Table(
        name = "users",
        schema = "portafolio"
)
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    @JsonIgnore
    private Set<Skill> skills;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "latitud", nullable = false)
    private String latitud;

    @Column(name = "longitud", nullable = false)
    private String longitud;

    @Column(name = "mail", nullable = false)
    private String mail;
}

