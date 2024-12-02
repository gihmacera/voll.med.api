package med.voll.api.domain.pacientes;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPacientes(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPacientes(Pacientes pacientes) {
        this(pacientes.getId(), pacientes.getNome(), pacientes.getEmail(), pacientes.getTelefone(), pacientes.getCpf(), pacientes.getEndereco());
    }
}
