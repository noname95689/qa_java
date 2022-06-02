package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.junit.Test;
import org.mockito.junit.MockitoRule;
import java.util.List;
import static org.mockito.Mockito.when;

public class CatTest {

    Cat cat;

    @Mock
    private Feline feline;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void prepare() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsCorrectString() {
        String exceptedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals("Метод getSound возвращает неправильное значение",
                exceptedSound, actualSound);
    }

    @Test
    public void getFoodCallsCorrectMethod() throws Exception {
        List<String> exceptedFood = List.of("Мясо");
        when(feline.eatMeat()).thenReturn(exceptedFood);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Метод getFood вызывает не eatMeat",
                exceptedFood, actualFood);
    }
}