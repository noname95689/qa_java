package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final boolean exceptedHasMane;

    public LionParametrizedTest(String sex, boolean exceptedHasMane) {
        this.sex = sex;
        this.exceptedHasMane = exceptedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void hasManeHasCorrectValue() throws Exception {
        Lion lion = new Lion(sex);
        boolean actualHasMane = lion.hasMane;
        Assert.assertEquals("hasMane имеет некорректное значение",
                exceptedHasMane, actualHasMane);
    }





}
