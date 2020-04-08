package SymbolStreams;

/*Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
        Пример
        InputStream последовательно возвращает четыре байта: 48 49 50 51.
        Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".*/

import java.io.*;
import java.nio.charset.Charset;

public class StreamToSring {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringWriter writer = new StringWriter();
        int a;
        String s;
        while ((a = reader.read()) != -1) {
            writer.write(a);
        }
        s = writer.toString();
        return s;
    }
}
