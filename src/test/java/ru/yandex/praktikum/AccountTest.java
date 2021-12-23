package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String introducedName;
    private final boolean expectedResult;

    public AccountTest(String externalName, boolean expectedResult){
        this.introducedName = externalName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] checkIntroducedNameIsCorrectToEmboss() {
        return new Object[][] {
                //валидные проверки
                {"Сергей Васильев", true},
                {"С В", true},
                //для проверки граничных значений
                {"СВ", false},
                {"Многоразовая Раскраска", false},
                //проверки на пробелы
                {" ПробелПеред", false},
                {"ПробелПосле ", false},
                {"БезПробелов", false},
                {"Много   Пробелов", false},
                //невалидные проверки (по заданию их нет)
                {"!@#$% ^&*()", false},
                {"1234567 8900", false},
                {"Иванов-Петров-Сидоров", false},
                {"Имя Три Слова", false},
        };
    }

    @Test
    public void checkIntroducedNameParameterizedTest(){
        Account account = new Account(introducedName);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals(actualResult, expectedResult);
    }
}