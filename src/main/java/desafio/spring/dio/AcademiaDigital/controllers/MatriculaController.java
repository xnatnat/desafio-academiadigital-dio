package desafio.spring.dio.AcademiaDigital.controllers;

import desafio.spring.dio.AcademiaDigital.dtos.MatriculaDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import desafio.spring.dio.AcademiaDigital.services.MatriculaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<MatriculaDto> salvar(@Valid @RequestBody MatriculaDto matriculaDto,
                                               UriComponentsBuilder uriComponentsBuilder){
        var matriculaData = matriculaService.salvar(matriculaDto);
        var uri = uriComponentsBuilder.path("/api/v1/matricula/{id}").buildAndExpand(matriculaData.getId()).toUri();
        return ResponseEntity.created(uri).body(matriculaData);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDto>> buscarTodas(){
        return ResponseEntity.ok(matriculaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDto> buscarPorId(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(matriculaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable(value = "id") Long id){
        matriculaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
