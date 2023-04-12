package desafio.spring.dio.AcademiaDigital.services;

import desafio.spring.dio.AcademiaDigital.dtos.AlunoDto;
import desafio.spring.dio.AcademiaDigital.dtos.AtualizarAlunoDto;
import desafio.spring.dio.AcademiaDigital.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import desafio.spring.dio.AcademiaDigital.models.Aluno;
import desafio.spring.dio.AcademiaDigital.models.AvaliacaoFisica;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final ModelMapper modelMapper;

    public AlunoService(AlunoRepository alunoRepository, ModelMapper modelMapper) {
        this.alunoRepository = alunoRepository;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public AlunoDto salvar(AlunoDto alunoDto){
        return mapToDto(
                save(
                        new Aluno(  alunoDto.getNome(),
                                    alunoDto.getBairro(),
                                    alunoDto.getCpf(),
                                    alunoDto.getDataDeNascimento(),
                                    new HashSet<>()
        )));
    }

    public AlunoDto buscarPorId(Long id){
        return mapToDto(findById(id));
    }

    public List<AlunoDto> listarTodos(){
        return alunoRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }
    public AlunoDto atualizar(Long id, AtualizarAlunoDto atualizarAlunoDto){
        var alunoData = findById(id);
        alunoData.setNome(atualizarAlunoDto.getNome());
        alunoData.setBairro(atualizarAlunoDto.getBairro());
        alunoData.setDataDeNascimento(atualizarAlunoDto.getDataDeNascimento());
        return mapToDto(save(alunoData));
    }
    @Transactional
    public void deletar(Long id){
        alunoRepository.delete(findById(id));
    }

    protected Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow();
    }

    private AlunoDto mapToDto(Aluno aluno){
        return modelMapper.map(aluno, AlunoDto.class);
    }

}
