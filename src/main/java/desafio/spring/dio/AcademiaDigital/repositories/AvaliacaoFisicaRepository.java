package desafio.spring.dio.AcademiaDigital.repositories;

import desafio.spring.dio.AcademiaDigital.models.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

    List<AvaliacaoFisica> findAllByAlunoId(Long id);
}
