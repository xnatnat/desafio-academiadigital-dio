package models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cad_alunos")

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Aluno extends BaseEntity{

    @Column(nullable = false)
    private String  nome;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate dataDeNascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<AvaliacaoFisica> avaliacoesFisicas;

}
