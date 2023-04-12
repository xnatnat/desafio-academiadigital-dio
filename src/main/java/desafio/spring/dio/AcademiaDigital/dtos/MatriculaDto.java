package desafio.spring.dio.AcademiaDigital.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatriculaDto {

    @NotNull(message = "O '${validatedValue}' é obrigatório")
    @Positive(message = "O Id do aluno precisa ser positivo.")
    private Long idAluno;

    private LocalDateTime dataDaMatricula;

    private Long id;
}
