package desafio.spring.dio.AcademiaDigital.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AvaliacaoFisicaDto {
    //@Positive(message = "O Id do aluno precisa ser positivo.")
    //@NotNull(message = "O '${validatedValue}' é obrigatório")
    //private Long idAluno;

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "${validatedValue}' precisa ser positivo.")
    private double peso;

    @NotNull(message = "Preencha o campo corretamente.")
    @Positive(message = "${validatedValue}' precisa ser positivo.")
    @DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
    private double altura;

    private Long idAvaliacao;
}
