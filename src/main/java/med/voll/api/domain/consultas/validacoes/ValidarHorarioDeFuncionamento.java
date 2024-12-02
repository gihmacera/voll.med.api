package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidarHorarioDeFuncionamento implements RegrasDeAgendamento {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var aberturaClinica = dataConsulta.getHour() < 7;
        var fechamentoClinica = dataConsulta.getHour() > 18;

        if (domingo || aberturaClinica || fechamentoClinica){
            throw new ValidacaoException("Consulta fora da data ou horario de funcionamento");
        }
    }

}
