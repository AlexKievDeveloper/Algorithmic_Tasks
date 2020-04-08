package СontrolStructures;
/*    Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один
    отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
    Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти
    по двум исходным массивам и сразу формировать отсортированный результирующий массив. Так, чтобы
    сортировка полученного массива при помощи Arrays.sort() уже не требовалась. К сожалению, автоматически
    это не проверить, так что это остается на вашей совести :)

    Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
    Пример
    Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}*/

import java.util.Arrays;

public class ArraysMergesAndSort {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];

        for (int i = 0; i < a1.length; i++) {
            result[i] = a1[i];
        }

        for (int i = a1.length; i < a1.length + a2.length; i++) {
            result[i] = a2[a1.length + a2.length - i - 1];
        }

        Arrays.sort(result);
        return result;
    }


}
