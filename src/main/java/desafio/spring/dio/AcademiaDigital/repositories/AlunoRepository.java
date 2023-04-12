package desafio.spring.dio.AcademiaDigital.repositories;

import desafio.spring.dio.AcademiaDigital.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
