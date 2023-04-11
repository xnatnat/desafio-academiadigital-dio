package models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cad_avaliacoes")

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class AvaliacaoFisica extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime dataDaAvaliacao;

    private double peso;

    private double altura;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
