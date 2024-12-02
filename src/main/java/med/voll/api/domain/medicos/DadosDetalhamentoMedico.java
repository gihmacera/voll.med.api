package med.voll.api.domain.medicos;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String telefone, String crm, EspecialidadeMedica especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medicos medicos) {
        this(medicos.getId(), medicos.getNome(), medicos.getEmail(), medicos.getTelefone(), medicos.getCrm(), medicos.getEspecialidade(), medicos.getEndereco());
    }
}
