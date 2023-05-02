package org.example;

public class JvmComprehension {
/* В системе подгрузки классов происходит поиск класса JvmComprehension.
Класс обнаруживается в Application Classloader.
Затем происходит связывание класса и его инициализация.
В Metaspace создается запись о классе JvmComprehension
*/

    public static void main(String[] args) { // в стеке создается фрейм main()
        int i = 1;                      // 1 информация записывается во фрейм main в стеке
        Object o = new Object();
        /* 2 в куче создается объект Object,
        в стеке во фрейме main() создается ссылка o на Object в куче
        */
        Integer ii = 2;
        /* 3 в куче создается объект Integer со значением 2,
        в стеке во фрейме main() создается ссылка ii на Integer в куче
        */
        printAll(o, i, ii);             // 4 в стеке создается фрейм printAll()
        System.out.println("finished"); // 7 в стеке создается фрейм println() со ссылкой на String "finished" из кучи
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;
        /* 5 в куче создается объект Integer со значением 700,
        в стеке во фрейме printAll() создается ссылка uselessVar на Integer в куче
        этот объект будет удален из кучи сборщиком мусора, так как на него нет ссылок
        */
        System.out.println(o.toString() + i + ii);
        /* 6 в стеке создается фрейм toString(),
        в стеке создается фрейм println() со ссылками на o.toString(), o, i, ii
        */
    }
}
