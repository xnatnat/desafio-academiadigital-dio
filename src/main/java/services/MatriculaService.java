package services;

import dtos.MatriculaDto;
import org.springframework.stereotype.Service;
import repositories.MatriculaRepository;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public MatriculaDto salvar(MatriculaDto matricula){

    }

    public MatriculaDto buscarPorId(Long id){

    }

    public List<MatriculaDto> buscarTodos(){

    }

    public void deletar(Long id){

      //  return matriculaRepository.delete();
    }
}
