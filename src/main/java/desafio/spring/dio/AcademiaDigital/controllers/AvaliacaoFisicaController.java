package desafio.spring.dio.AcademiaDigital.controllers;

import desafio.spring.dio.AcademiaDigital.dtos.AvaliacaoFisicaDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import desafio.spring.dio.AcademiaDigital.services.AvaliacaoFisicaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
        this.avaliacaoFisicaService = avaliacaoFisicaService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<AvaliacaoFisicaDto> salvar(@PathVariable(value = "id") Long id,
                                                     @Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto,
                                                     UriComponentsBuilder uriComponentsBuilder){
        var avaliacaoData = avaliacaoFisicaService.salvar(id, avaliacaoFisicaDto);
        var uri = uriComponentsBuilder.path("/api/v1/avaliacoes/{id}").buildAndExpand(avaliacaoData.getIdAvaliacao()).toUri();
        return ResponseEntity.created(uri).body(avaliacaoData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AvaliacaoFisicaDto>> listarAvaliacoes(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(avaliacaoFisicaService.buscarAvaliacoesPorIdAluno(id));
    }
}
