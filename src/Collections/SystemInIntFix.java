package Collections;

/*Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
        затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность
        в обратном порядке в System.out.

        Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
        В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.
        Sample Input: 1 2 3 4 5 6 7
        Sample Output: 6 4 2*/


import java.io.*;
import java.util.*;
import java.util.Scanner;

    public class SystemInIntFix {

        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);

            List<Integer> arrayList = new LinkedList<>();

            int counter = 0;
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    if (counter == 1) {
                        arrayList.add(scanner.nextInt());
                        counter--;
                    }
                    else {
                        scanner.next();
                        counter++;
                    }
                }
            }

            Collections.reverse(arrayList);
            for (Integer x : arrayList) {
                System.out.print(x + " ");
            }
        }
    }

