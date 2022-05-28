package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int exceptedKittens;

    public FelineParametrizedTest(int exceptedKittens) {
        this.exceptedKittens = exceptedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {0},
                {11},
                {17},
                {31},
                {157},
        };
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens(exceptedKittens);
        Assert.assertEquals("Метод getKittens возвращает некорректное значение",
                exceptedKittens, actualKittens);
    }
}
