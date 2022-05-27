package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private  Feline feline;
    @Before
    public void before() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        Assert.assertEquals("Ожидается результат: Животные, Птицы, Рыба",
                List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
    //Добавить запись в переменные для наглядности
    @Test
    public void getFamilyReturnsCorrectString() {
        String exceptedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("feline.getFamily() возвращает неправильную строку",
                exceptedFamily, actualFamily);
    }

    @Test
    public void getKittensWithoutArgumentReturnsCorrectValue() {
        Assert.assertEquals("Количество котят не совпадает с ожидаемым",
                1, feline.getKittens());
    }

    //Добавить параметризацию для количества котят
    @Test
    public void getKittensWithArgumentReturnsCorrectValue() {
        Assert.assertEquals("Количество котят не совпадает с ожидаемым",
                1, feline.getKittens(1));
    }
}