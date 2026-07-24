package umycael.com.github.AcademiaControl.Aluno;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    // Listar Alunos
    public List<AlunoDTO> listarAlunos() {
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(alunoMapper::map)
                .collect(Collectors.toList());
    }

    // Listar Aluno por ID
    public AlunoDTO listarAlunoPorId(Long id) {
        Optional<AlunoModel> alunoId = alunoRepository.findById(id);
        return alunoId.map(alunoMapper::map).orElse(null);
    }

    // Criar Aluno
    public AlunoDTO criarAluno(AlunoDTO alunoDTO) {

        AlunoModel aluno = alunoMapper.map(alunoDTO);

        aluno.setAtivo(true);
        aluno.setDataCadastro(LocalDate.now());

        aluno = alunoRepository.save(aluno);

        return alunoMapper.map(aluno);
    }

    // Deletar Aluno
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    // Atualizar Aluno
    public AlunoDTO atualizarAluno(Long id, AlunoDTO alunoDTO) {

        Optional<AlunoModel> alunoExistente = alunoRepository.findById(id);

        if (alunoExistente.isPresent()) {

            AlunoModel aluno = alunoExistente.get();

            aluno.setNomeCompleto(alunoDTO.getNomeCompleto());
            aluno.setCpf(alunoDTO.getCpf());
            aluno.setEmail(alunoDTO.getEmail());
            aluno.setTelefone(alunoDTO.getTelefone());
            aluno.setDataNascimento(alunoDTO.getDataNascimento());
            aluno.setSexo(alunoDTO.getSexo());

            AlunoModel alunoSalvo = alunoRepository.save(aluno);

            return alunoMapper.map(alunoSalvo);
        }

        return null;
    }

}
