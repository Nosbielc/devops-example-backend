package nosbielc.com.devops.example.backend.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 23/05/2020
 * @project devops-example-backend
 */
public class DateUtilsTests {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        LocalDate data = LocalDate.of(LocalDate.now().plusYears(1).getYear(), 01, 01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void deveRetornarFalseParaDatasFuturas() {
        LocalDate data = LocalDate.of(LocalDate.now().minusYears(1).getYear(), 12, 12);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void deveRetornarTrueParaDataAtual() {
        LocalDate data = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(data));
    }
}