package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.DadosAgendamentoConsulta;

public interface RegrasDeAgendamento {
    void validar(DadosAgendamentoConsulta dados);
}
