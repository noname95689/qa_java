package com.example;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;

public class AnimalParametrizedTest {

    /*@Rule
    public MockitoRule rule = MockitoJUnit.rule();*/

    private final String animalType;
    private final List<String> exceptedFood;

    public AnimalParametrizedTest(String animalType, List<String> exceptedFood) {
        this.animalType = animalType;
        this.exceptedFood = exceptedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Травоядное", "Трава"},
                {"Хищник", "Животные"},
        };
    }

    @Test
    public void getFoodThrowsCorrectException() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(animalType);
        Assert.assertEquals("getFood возвращает некорерктный результат",
                exceptedFood, actualFood);
    }
}
