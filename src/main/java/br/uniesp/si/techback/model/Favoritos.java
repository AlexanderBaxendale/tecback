package br.uniesp.si.techback.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Favoritos")
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_Filme", length = 100)
    private String nome_filme;

    @Column(name = "nome_Usuário", length = 100)
    private String nome_usuario;




}

