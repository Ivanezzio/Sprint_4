package ru.yandex.praktikum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

        public class Account {

            private final String nameForEmboss;

            private static final String NAME_PATTERN = "(?=.{3,19}$)[а-яА-Яa-zA-Z]+\\s{1}[а-яА-Яa-zA-Z]+";
            private static final Pattern pattern = Pattern.compile(NAME_PATTERN);

            public Account(String name) {
                nameForEmboss = name;
            }

            public boolean checkNameToEmboss() {
                Matcher matcher = pattern.matcher(nameForEmboss);
                return matcher.matches();
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
    }
}
