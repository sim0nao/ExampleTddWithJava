package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    reajusteService service = new reajusteService();
    Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));

    @Test
    public void reajusteDeveSerDe3PorCentoQuandoDesempenhoForBaixo(){
        service.Reajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveSerDe15PorCentoQuandoDesempenhoForBom(){
        service.Reajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveSerDe20PorCentoQuandoDesempenhoForOtimo(){
        service.Reajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
