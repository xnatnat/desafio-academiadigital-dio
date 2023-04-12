package desafio.spring.dio.AcademiaDigital.services;

import desafio.spring.dio.AcademiaDigital.dtos.MatriculaDto;
import desafio.spring.dio.AcademiaDigital.repositories.MatriculaRepository;
import jakarta.transaction.Transactional;
import desafio.spring.dio.AcademiaDigital.models.Matricula;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoService alunoService;
    private final ModelMapper modelMapper;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoService alunoService, ModelMapper modelMapper) {
        this.matriculaRepository = matriculaRepository;
        this.alunoService = alunoService;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public MatriculaDto salvar(MatriculaDto matricula){
        return mapToDto(
                matriculaRepository.save(
                    new Matricula(
                            LocalDateTime.now(),
                            alunoService.findById(matricula.getIdAluno()))
        ));

    }

    public MatriculaDto buscarPorId(Long id){
        return mapToDto(findById(id).orElseThrow());
    }

    public List<MatriculaDto> buscarTodos(){
        return matriculaRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public void deletar(Long id){
        matriculaRepository.delete(findById(id).orElseThrow());
    }

    private Optional<Matricula> findById(Long id){
        return matriculaRepository.findById(id);
    }

    private MatriculaDto mapToDto(Matricula matricula) {
        return modelMapper.map(matricula, MatriculaDto.class);
    }

}
