package desafio.spring.dio.AcademiaDigital.services;

import desafio.spring.dio.AcademiaDigital.dtos.AvaliacaoFisicaDto;
import jakarta.transaction.Transactional;
import desafio.spring.dio.AcademiaDigital.models.AvaliacaoFisica;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import desafio.spring.dio.AcademiaDigital.repositories.AvaliacaoFisicaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoService alunoService;
    private final ModelMapper modelMapper;

    public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository, AlunoService alunoService, ModelMapper modelMapper) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoService = alunoService;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public AvaliacaoFisica save(AvaliacaoFisica avaliacaoFisica){
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public AvaliacaoFisicaDto salvar(Long id, AvaliacaoFisicaDto avaliacaoFisicaDto){
        var aluno = alunoService.findById(id);
        var avaliacao = save(
                new AvaliacaoFisica(
                        LocalDateTime.now(),
                        avaliacaoFisicaDto.getPeso(),
                        avaliacaoFisicaDto.getAltura(),
                        aluno));
        return mapToDto(avaliacao);
    }

    public AvaliacaoFisicaDto buscarPorId(Long id){
        return mapToDto(findById(id));
    }

    public AvaliacaoFisica findById(Long id){
        return avaliacaoFisicaRepository.findById(id).orElseThrow();
    }

    public List<AvaliacaoFisicaDto> buscarAvaliacoesPorIdAluno(Long id){
        return avaliacaoFisicaRepository.findAllByAlunoId(id)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public AvaliacaoFisicaDto atualizar(AvaliacaoFisicaDto avaliacaoDto){
        var avaliacaoData = findById(avaliacaoDto.getIdAvaliacao());
        avaliacaoData.setAltura(avaliacaoDto.getAltura());
        avaliacaoData.setPeso(avaliacaoDto.getPeso());
        avaliacaoData = save(avaliacaoData);
        return mapToDto(avaliacaoData);
    }
    @Transactional
    public void deletar(Long id){

    }

    private AvaliacaoFisicaDto mapToDto(AvaliacaoFisica avaliacao) {
        return modelMapper.map(avaliacao, AvaliacaoFisicaDto.class);
    }


}
