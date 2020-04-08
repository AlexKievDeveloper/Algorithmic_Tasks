package Collections;

/*      Реализуйте метод, вычисляющий симметрическую разность двух множеств.
        Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

        Пример
        Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.*/

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> test1 = new LinkedHashSet<T>();
        Set<T> test2 = new LinkedHashSet<T>();
        test1.addAll(set1);
        test2.addAll(set2);

        test1.removeAll(test2);
        test2.removeAll(set1);

        Set<T> result1 = new LinkedHashSet<>();
        result1.addAll(test1);
        result1.addAll(test2);

        return (Set<T>) result1;
    }
}
