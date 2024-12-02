package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDataConsultaMedico implements RegrasDeAgendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var consultasDoMedico = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (consultasDoMedico){
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horaio!");
        }
    }
}
