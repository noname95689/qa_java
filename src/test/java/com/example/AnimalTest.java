package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    Animal animal;

    @Before
    public void prepare() {
        animal = new Animal();
    }

    @Test
    public void getFood() {
        Exception getFoodException = assertThrows("Проверка",
                Exception.class, ()-> animal.getFood("Всеядное"));
        Assert.assertEquals(getFoodException.getMessage(),
                "Неизвестный вид животного, используйте значение Травоядное или Хищник");
    }

    @Test
    public void getFamily() {
        String exceptedFamily =
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        Assert.assertEquals("getFamily возвращает нужную строку",
                exceptedFamily, actualFamily);
    }
}