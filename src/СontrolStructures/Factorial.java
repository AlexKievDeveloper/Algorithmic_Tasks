package СontrolStructures;

/*        Реализуйте метод, вычисляющий факториал заданного натурального числа.
        Факториал NN вычисляется как 1 \cdot 2 \cdot ... \cdot N1⋅2⋅...⋅N.
        Поскольку это очень быстро растущая функция, то даже для небольших NN вместимости типов int и long
        очень скоро не хватит. Поэтому будем использовать BigInteger.
        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода д
        обавит проверяющая система.*/

import java.math.BigInteger;

public class Factorial {
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result; // your implementation here
    }
}
