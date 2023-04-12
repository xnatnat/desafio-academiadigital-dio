package desafio.spring.dio.AcademiaDigital.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cad_avaliacoes")
public class AvaliacaoFisica extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime dataDaAvaliacao;

    private double peso;

    private double altura;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
