package med.voll.api.domain.medicos;

public record DadosListagemMedico(Long id,String nome, String email, String crm, EspecialidadeMedica especialidade) {

    public DadosListagemMedico(Medicos medicos){
        this(medicos.getId(), medicos.getNome(), medicos.getEmail(), medicos.getCrm(), medicos.getEspecialidade());
    }
}
