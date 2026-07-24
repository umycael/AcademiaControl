package umycael.com.github.AcademiaControl.Aluno;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

        public AlunoModel map(AlunoDTO alunoDTO) {

            AlunoModel alunoModel = new AlunoModel();
            alunoModel.setId(alunoDTO.getId());
            alunoModel.setNomeCompleto(alunoDTO.getNomeCompleto());
            alunoModel.setCpf(alunoDTO.getCpf());
            alunoModel.setEmail(alunoDTO.getEmail());
            alunoModel.setTelefone(alunoDTO.getTelefone());
            alunoModel.setDataNascimento(alunoDTO.getDataNascimento());
            alunoModel.setSexo(alunoDTO.getSexo());

            return alunoModel;
        }

        public AlunoDTO map(AlunoModel alunoModel) {
            AlunoDTO alunoDTO = new AlunoDTO();
            alunoDTO.setId(alunoModel.getId());
            alunoDTO.setNomeCompleto(alunoModel.getNomeCompleto());
            alunoDTO.setCpf(alunoModel.getCpf());
            alunoDTO.setEmail(alunoModel.getEmail());
            alunoDTO.setTelefone(alunoModel.getTelefone());
            alunoDTO.setDataNascimento(alunoModel.getDataNascimento());
            alunoDTO.setSexo(alunoModel.getSexo());

            return alunoDTO;
        }

}
