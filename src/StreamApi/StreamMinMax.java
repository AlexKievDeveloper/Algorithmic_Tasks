package StreamApi;

/*Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
        minMaxConsumer.accept(min, max);

        Если стрим не содержит элементов, то вызовите
        minMaxConsumer.accept(null, null);*/

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());//тернальная операция

        if (list.size() == 0){
            minMaxConsumer.accept(null, null);
        }
        else {
            minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        }
    }
}
