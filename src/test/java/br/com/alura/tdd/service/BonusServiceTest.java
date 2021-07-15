package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    public void BonusDeveSerZeroParaFuncionarioComSalarioAlto(){
        BonusService service = new BonusService();
//                assertThrows(IllegalAccessException.class,
//                        ()-> service.calcularBonus(new Funcionario("Simone", LocalDate.now(),new BigDecimal("30000" ))));

        try{
            service.calcularBonus(new Funcionario("Simone", LocalDate.now(),new BigDecimal("30000" )));
            fail("Não retornou a exception esperada");
        } catch (Exception e){
            assertEquals("Funcionário não tem direito ao bônus", e.getMessage());
        }
    }

    @Test
    public void BonusDeveSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus =
                service.calcularBonus(new Funcionario("Natalia", LocalDate.now(),new BigDecimal("2500" )));

        assertEquals(new BigDecimal("250.00"), bonus);
    }
    @Test
    public void BonusDeveSer10PorCento(){
        BonusService service = new BonusService();
        BigDecimal bonus =
                service.calcularBonus(new Funcionario("Luiza", LocalDate.now(),new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}