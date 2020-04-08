package ByteStreams;

import java.io.IOException;
import java.io.InputStream;


/*Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
        Контрольная сумма данных вычисляется по следующему алгоритму:

Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
        Cn+1=rotateLeft(C_n) xor bn+1

        где C_n — контрольная сумма первых n байт данных,
        rotateLeft — циклический сдвиг бит числа        на один бит влево
        (чтобы не изобретать велосипед, используйте Integer.rotateLeft),
        bn — n-ный байт данных.
        Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
        Выброшенное из методов InputStream исключение должно выбрасываться из метода.

        Пример
        На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01.
        В качестве контрольной суммы должно быть возвращено число 71.*/

public class ByteInputStream {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int cursum = 0;

        for (int i = inputStream.read(); i != -1; i = inputStream.read()) {
            cursum = (int)Integer.rotateLeft(cursum, 1) ^ (int) i;
        }

        return cursum;
    }
}
