package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "titor")
public class Titor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  String nome;
    @Column
    private String apelidos;
    @OneToMany(mappedBy = "titor",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Alumno> alumnos = new ArrayList<>();

    public Titor() {
    }

    public Titor(String nome, String apelidos) {
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public Titor(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}

