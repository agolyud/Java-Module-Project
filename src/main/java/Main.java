import java.io.PrintStream;
import java.util.Scanner;
public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Привет Мир");
        out.println("На скольких человек необходимо разделить счёт.");
        int persons = in.nextInt();
        while (persons <= 1) {
            out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
            persons = in.nextInt();
        }
        cal[] pos = new cal[100];
        out.println("Введите название товара");
        String nextPosition = in.next();
        out.println("Введите стоимость в формате: 'рубли.копейки' [10,45, 11,40]");
        double nextPrice = in.nextDouble();
        int i = 0;
        while (!nextPosition.equalsIgnoreCase("Завершить")) {
            out.println("Хотите еще добавить товар?, если да то Введите название товара" +
                    "\nДля завершения введите 'Завершить'");
            pos[i] = new cal(nextPosition, nextPrice);
            nextPosition = in.next();
            if (!nextPosition.equalsIgnoreCase("Завершить")) {
                out.println("Введите стоимость в формате: 'рубли.копейки' [10,45, 11,40]");
                nextPrice = in.nextDouble();
            }
            i += 1;
        }
        out.println("Добавленные товары:");
        for (int j = 0; j < i; j++)
            out.println(pos[j].name + " " + pos[j].price + " рублей");
        double sum = 0;
        for (int j = 0; j < i; j++)
            sum += pos[j].price;

        out.println(("Итоговая сумма: ") + String.format("%.2f", sum / persons) + " рублей");
    }

}