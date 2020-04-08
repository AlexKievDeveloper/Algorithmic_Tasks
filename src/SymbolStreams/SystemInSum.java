package SymbolStreams;

/*Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в
        тексте вещественных чисел с точностью до шестого знака после запятой. Числом считается
        последовательность символов, отделенная от окружающего текста пробелами или переводами
        строк и успешно разбираемая методом Double.parseDouble.

        На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main —
        таково ограничение проверяющей системы), метод main, прописать все import'ы.*/

import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class SystemInSum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        PrintWriter writer = new PrintWriter(System.out);
        double d = 0;

        while (scanner.hasNext()){
            if (scanner.hasNextDouble()){
                d+= scanner.nextDouble();
            }
            else {
                scanner.next();
            }
        }
        String formattedDouble = new DecimalFormat("#0.000000").format(d);
        writer.print(formattedDouble);
        System.out.println(formattedDouble);
    }
}
