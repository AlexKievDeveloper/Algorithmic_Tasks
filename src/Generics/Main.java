package Generics;

/*Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий
        элементам принимать значение null.

        Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
        Конструктор должен быть закрытым (private).
        С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!*/

import java.util.NoSuchElementException;
import java.util.Objects;

public class Main {
    static class Pair <T, K> {
        final T first;
        final K second;

        private Pair (T first, K second ) {
            this.first = first;
            this.second = second;
        }

        public static <T, K> Pair <T, K>  of (T first, K second){
            return new Pair<>(first, second);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<T, K> pair = (Pair<T, K>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public T getFirst() {
            if (first == null) {
                throw new NoSuchElementException("No value present");
            }
            return first;
        }

        public K getSecond() {
            if (second == null) {
                throw new NoSuchElementException("No value present");
            }
            return second;
        }
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }
}
