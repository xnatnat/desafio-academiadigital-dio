package desafio.spring.dio.AcademiaDigital.controllers;

import desafio.spring.dio.AcademiaDigital.dtos.AlunoDto;
import desafio.spring.dio.AcademiaDigital.dtos.AtualizarAlunoDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import desafio.spring.dio.AcademiaDigital.services.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoDto> salvar(@Valid @RequestBody AlunoDto alunoDto,
                                           UriComponentsBuilder uriComponentsBuilder){
        var alunoData = alunoService.salvar(alunoDto);
        var uri = uriComponentsBuilder.path("/api/v1/alunos/{id}").buildAndExpand(alunoData.getId()).toUri();
        return ResponseEntity.created(uri).body(alunoData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizar(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody AtualizarAlunoDto alunoDto) {
        return ResponseEntity.ok(alunoService.atualizar(id, alunoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarPorId(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> listarTodos(){
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(value = "id") Long id){
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
