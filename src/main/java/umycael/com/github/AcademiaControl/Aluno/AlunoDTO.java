package umycael.com.github.AcademiaControl.Aluno;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;

    @NotBlank(message = "O nome completo é obrigatório.")
    private String nomeCompleto;

    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "Informe um email válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    @NotNull(message = "A data de nascimento é obrigatória.")
    private LocalDate dataNascimento;

    @NotNull(message = "O sexo é obrigatório.")
    private Sexo sexo;

    private boolean ativo;

    @NotNull(message = "A data de cadastro é obrigatória.")
    private LocalDate dataCadastro;

}