package umycael.com.github.AcademiaControl.Aluno;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // POST
    @PostMapping
    public ResponseEntity<String> criarAluno(@Valid @RequestBody AlunoDTO aluno) {
        AlunoDTO novoAluno = alunoService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Aluno criado com sucesso: " + novoAluno.getNomeCompleto());
    }

    // GET
    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        List<AlunoDTO> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    // GET (ID)
    @GetMapping("/{id}")
    public ResponseEntity<?> listarAlunoPorId(@PathVariable Long id) {

        AlunoDTO aluno = alunoService.listarAlunoPorId(id);

        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aluno " + id + " não existe nos registros.");
        }
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoAtualizado) {

        AlunoDTO aluno = alunoService.atualizarAluno(id, alunoAtualizado);

        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aluno " + id + " não existe nos registros.");
        }

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id) {

        if (alunoService.listarAlunoPorId(id) != null) {
            alunoService.deletarAluno(id);
            return ResponseEntity.ok("Aluno " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aluno " + id + " não existe nos registros.");
        }

    }

}
