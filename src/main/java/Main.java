import java.io.PrintStream;
import java.util.Scanner;
public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        System.out.println("Привет Мир");
        out.println("На скольких человек необходимо разделить счёт.");
        int persons = in.nextInt();
        while (persons <= 1) {
            out.println("Количество человек меньше 1. Это некорректное значение для подсчёта.");
            persons = in.nextInt();
        }
        Calculator[] pos = new Calculator[100];
        out.println("Введите название товара");
        String nextPosition = in.next();
        out.println("Введите стоимость в формате: 'рубли.копейки' [10,45, 11,40]");
        double nextPrice = in.nextDouble();
        int i = 0;
        while (!nextPosition.equalsIgnoreCase("Завершить")) {
            out.println("Хотите еще добавить товар?, если да то Введите название товара" +
                    "\nДля завершения введите 'Завершить'");
            pos[i] = new Calculator(nextPosition, nextPrice);
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

         double amout = sum / persons;
            int ruble = (int) Math.floor(amout);
            String endingRuble;

            if (ruble % 10 == 1) {
                endingRuble = "рубль";
            } else if (ruble % 10 == 2 || ruble % 10 == 3 || ruble % 10 == 4) {
                endingRuble = "рубля";
            } else endingRuble = "рублей";

            out.println("Каждый из гостей должен заплатить:" + " " + String.format("%.2f", amout) + " " + endingRuble);

        }

    }


