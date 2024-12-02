package med.voll.api.domain.pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.CadastroEndereco;

public record DadosAtualizaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        CadastroEndereco endereco) {


}
