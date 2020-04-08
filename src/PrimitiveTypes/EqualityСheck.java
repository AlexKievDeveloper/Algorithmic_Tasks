package PrimitiveTypes;
/*
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)
Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
*/

public class EqualityСheck {
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(c - a - b) < 0.0001;
    }
}
