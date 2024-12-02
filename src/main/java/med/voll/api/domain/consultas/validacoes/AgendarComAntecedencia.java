package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class AgendarComAntecedencia implements RegrasDeAgendamento {
    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();
        if (diferenaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser marcado com 30 minutos de antecedencia!");
        }
    }
}
