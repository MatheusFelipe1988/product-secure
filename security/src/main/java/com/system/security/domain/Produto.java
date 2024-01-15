package com.system.security.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
