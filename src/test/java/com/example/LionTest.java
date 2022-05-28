package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.junit.Assert.assertThrows;

import java.util.List;
import static org.mockito.Mockito.when;

//@RunWith(Parameterized.class)
public class LionTest {

    @Mock
    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void prepare() throws Exception {
        lion = new Lion(feline);
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getFoodСallsCorrectMethod() throws Exception {
        List<String> exceptedFood = List.of("Мясо");
        when(feline.getFood("Хищник")).thenReturn(exceptedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals("lion.getFood(Хищник) вызывает не feline.getFood()",
                exceptedFood, actualFood);
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        int exceptedKittens = 5;
        when(feline.getKittens()).thenReturn(exceptedKittens);
        int actualKittens = lion.getKittens();
        Assert.assertEquals("lion.getKittens() вызывает не feline.getKittens()",
                exceptedKittens, actualKittens);
    }

    //добавить тест метода doesHaveMane с моком
    @Test
    public void doesHaveManeReturnsHasMane() {
        //Lion lion = new Lion("Самец");
        lion.hasMane = true;
        //boolean exceptedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertTrue("doesHaveMane возвращает hasMane", actualHasMane);
    }

    //добавить тест оставшегося exception (другое) в lion

}