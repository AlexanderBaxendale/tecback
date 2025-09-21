package br.uniesp.si.techback.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Estado", length = 100)
    private String estado;

    @Column(name = "nome_bairro", length = 100)
    private String nome_bairo;

    @Column(name = "numero", length = 100)
    private String numero;

    @Column(name = "cep")
    private String cep;

}

