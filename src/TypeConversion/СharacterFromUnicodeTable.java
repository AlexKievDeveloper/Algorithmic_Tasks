package TypeConversion;

/*Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE
после символа "\" (обратный слэш) на расстоянии a.*/

public class СharacterFromUnicodeTable {
    public static char charExpression(int a) {
        int test = (int) '\\' + a;
        return (char) test;
    }
}
