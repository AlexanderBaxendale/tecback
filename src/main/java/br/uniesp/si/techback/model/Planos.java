package br.uniesp.si.techback.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Planos")
public class Planos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo_plano", length = 100)
    private String tipo;

    @Column(name = "Preco", length = 100)
    private String valor;

    @Column(name = "Forma_pagamento", length = 100)
    private String Forma_pagamento;
    
}

