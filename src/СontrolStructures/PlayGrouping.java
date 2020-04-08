package СontrolStructures;
/*Вам дан список ролей и сценарий пьесы в виде массива строчек.
        Каждая строчка сценария пьесы дана в следующем виде:
        Роль: текст
        Текст может содержать любые символы.
        Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать
        результат в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:
        Роль:
        i) текст
        j) текст2
        ...
        ==перевод строки==

        i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует
        в соответствии с порядком ролей. Переводы строк между группами обязательны, переводы строк в конце
        текста не учитываются.

        Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно,
        неправильная сборка результирующей строчки может выйти за ограничение по времени.

        Обратите внимание еще на несколько нюансов:

        имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
        название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
        роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
        в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
        будьте внимательны, не добавляйте лишних пробелов в конце строк.*/

public class PlayGrouping {
    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < roles.length; ++j) {
            sb.append(roles[j]);
            sb.append(":\n");
            for (int i = 0; i < textLines.length; ++i) {
                if (textLines[i].startsWith(roles[j] + ":")) {
                    sb.append(i + 1);
                    sb.append(")");
                    sb.append(textLines[i].substring(roles[j].length() + 1));
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

/*   EXAMPLE:

 Sample Input:
        roles:
        Городничий
        Аммос Федорович
        Артемий Филиппович
        Лука Лукич
        textLines:
        Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        Аммос Федорович: Как ревизор?
        Артемий Филиппович: Как ревизор?
        Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
        Аммос Федорович: Вот те на!
        Артемий Филиппович: Вот не было заботы, так подай!
        Лука Лукич: Господи боже! еще и с секретным предписаньем!
        Sample Output:

        Городничий:
        1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.

        Аммос Федорович:
        2) Как ревизор?
        5) Вот те на!

        Артемий Филиппович:
        3) Как ревизор?
        6) Вот не было заботы, так подай!

        Лука Лукич:
        7) Господи боже! еще и с секретным предписаньем!*/
