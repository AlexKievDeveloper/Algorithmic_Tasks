package ArraysAndStrings;
/*Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка,
        которая читается одинаково слева направо и справа налево (в том числе пустая).
        При определении "палиндромности" строки должны учитываться только буквы и цифры.
        А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
        Гарантируется, что в метод попадают только строки, состоящие из символов ASCII
        (цифры, латинские буквы, знаки препинания). Т.е. русских, китайских и прочих экзотических
        символов в строке не будет.

        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит
        проверяющая система.

        Подсказки (не читайте, если хотите решить сами):
        для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным
        выражением "[^a-zA-Z0-9]"; найдите в классе String метод, выполняющий замену по регулярному выражению;
        для перестановки символов строки в обратном порядке можно воспользоваться методом reverse(), который находится
        в классе StringBuilder;
        в классе String есть методы для преобразования всей строки в верхний и нижний регистр.*/

import java.util.ArrayList;

public class Pallinder {
    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        int count = 0;
        StringBuilder s = new StringBuilder((text.toLowerCase()).replaceAll("[^A-Za-z1-9]+", ""));

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        StringBuilder s1 = s.reverse();
        ArrayList<Character> listReverse = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            listReverse.add(s1.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (list.get(i).equals(listReverse.get(i))) {
                count++;
            }
        }
        return count == list.size();
    }
}
