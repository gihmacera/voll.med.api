package med.voll.api.domain.medicos;

import med.voll.api.domain.medicos.EspecialidadeMedica;
import med.voll.api.domain.medicos.Medicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medicos, Long> {
    Page<Medicos> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
            select m from Medico m
            where
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consultas c
                where
                c.data = :data
              )
            order by rand()
            limit 1
        """)
    Medicos escolherMedicoAleatorioLivreNaData(EspecialidadeMedica especialidade, LocalDateTime data);

    @Query("""
            select m.ativo
            from Medico m
            where
            m.id = :id
            """)
    boolean findAtivoById(Long id);
}
