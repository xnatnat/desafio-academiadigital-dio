package desafio.spring.dio.AcademiaDigital.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cad_alunos")
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
