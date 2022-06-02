package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class LionTest {

    @Mock
    Lion lion;

    @Mock
    Feline feline;

    @Before
    public void prepare() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getFoodCallsCorrectMethod() throws Exception {
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

    @Test
    public void doesHaveManeReturnsHasMane() {
        lion.hasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertTrue("doesHaveMane возвращает hasMane", actualHasMane);
    }

    @Test
    public void doesHaveManeExceptionTest() {
        Exception lionException = assertThrows(
                "Exception в Lion некорректно срабатывает",
                Exception.class, ()-> lion = new Lion("Другое", feline));
        Assert.assertEquals(lionException.getMessage(),
                "Используйте допустимые значения пола животного - самец или самка");
    }
}