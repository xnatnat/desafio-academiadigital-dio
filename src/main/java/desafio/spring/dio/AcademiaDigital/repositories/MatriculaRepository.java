package desafio.spring.dio.AcademiaDigital.repositories;

import desafio.spring.dio.AcademiaDigital.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
