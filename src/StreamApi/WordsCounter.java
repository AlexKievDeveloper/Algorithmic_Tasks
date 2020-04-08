package StreamApi;
/*Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
        и в конце выводящую 10 наиболее часто встречающихся слов.
        Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
        Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

        Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
        Выводите слова в нижнем регистре.

        Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
        Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
        то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
        Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsCounter {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Stream<String> stringStream = bf.lines().map(String::toLowerCase).map(line -> line.
                split("[^\\p{L}\\p{Digit}_]+")).flatMap(Arrays::stream);

        Map<String, Long> result = stringStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> finalMap = new LinkedHashMap<>();

        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));


        List<String> linkedList = new LinkedList<>(finalMap.keySet());

        for (int i = 0; i < linkedList.size() && i < 10; i++) {
            System.out.println(linkedList.get(i));
        }

        stringStream.close();
    }
}




/*
Example:
        Sample Input 2:
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus.
        Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur.
        Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem.
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.

        Sample Output 2:
        consectetur
        faucibus
        ipsum
        lorem
        adipiscing
        amet
        dolor
        eget
        elit
        mi*/
