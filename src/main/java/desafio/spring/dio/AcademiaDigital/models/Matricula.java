package desafio.spring.dio.AcademiaDigital.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cad_matriculas")
public class Matricula extends BaseEntity{

    private LocalDateTime dataDaMatricula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}

