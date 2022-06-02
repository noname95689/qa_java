package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {

    private final String animalType;
    private final List<String> exceptedFood;

    public AnimalParametrizedTest(String animalType, List<String> exceptedFood) {
        this.animalType = animalType;
        this.exceptedFood = exceptedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood(animalType);
        Assert.assertEquals("getFood возвращает некорректный результат",
                exceptedFood, actualFood);
    }
}
