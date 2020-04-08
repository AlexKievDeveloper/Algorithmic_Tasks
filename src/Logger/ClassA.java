package Logger;

/*В этой задаче вам нужно реализовать метод, настраивающий параметры логирования. Конфигурирование в коде позволяет
выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

        Требуется выставить такие настройки, чтобы:

        Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
        Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
        Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности с
        ообщения печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на
        уровнях "org.stepic", "org" и "".
        Не упомянутые здесь настройки изменяться не должны.

        (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл. Но проверяющая система не
        разрешает создавать файлы на диске, поэтому придется так.

        Подсказки:
        Level есть не только у Logger, но и у Handler.
        Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.*/

import java.util.logging.*;

public class ClassA {

    private static final Logger ClassA = Logger.getLogger(ClassA.class.getName());
    private static final Logger ClassB = Logger.getLogger(ClassB.class.getName());

    private static void configureLogging() {
        Logger ClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        ClassA.setLevel(Level.ALL);
        Logger ClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        ClassB.setLevel(Level.WARNING);

        Logger java = Logger.getLogger("org.stepic.java");
        java.setUseParentHandlers(false);

        Handler a = new ConsoleHandler();
        a.setLevel(Level.ALL);
        java.addHandler(a);
        Formatter f = new XMLFormatter();
        a.setFormatter(f);
    }
}

class ClassB {
}