package AbstractClassesAndInterfaces;

/*Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
        (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char,
        AsciiCharSequence будет занимать в два раза меньше памяти.

        Класс AsciiCharSequence должен:
        реализовывать интерфейс java.lang.CharSequence;
        иметь конструктор, принимающий массив байт;
        определять методы length(), charAt(), subSequence() и toString()
        Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

        В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

        P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254*/


    public class AsciiCharSequence implements CharSequence {
        private byte[] array;

        private AsciiCharSequence(byte[] array) {
            this.array = array;
        }

        @Override
        public int length() {
            return array.length;
        }

        @Override
        public char charAt(int index) {
            char result = '0';
            for (int i = 0; i <= index; i++) {
                result = (char) array[i];
            }
            return result;
        }

        @Override
        public String toString(){
            char result = '0';
            StringBuilder s = new StringBuilder();
            for (byte b : array) {
                result = (char) b;
                s.append(result);
            }
            return s.toString();
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            byte[] temp = new byte[end-start];
            char result = '0';
            if (end - start >= 0) System.arraycopy(array, start, temp, 0, end - start);
            return new AsciiCharSequence(temp);
        }
    }

