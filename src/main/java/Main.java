import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    static int persons = 0;
    static int nextPrice = 0;
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {

        System.out.println("На скольких человек необходимо разделить счёт.");
            while (true) {
                if (in.hasNext() && in.hasNextInt())
                {
                    persons = in.nextInt();
                    if (persons <= 1){
                        System.out.println("Некорректный ввод.\n" +
                                "Введите количество человек больше 1.");
                    }
                    else {
                        break;
                    }
                }
                else{
                    System.out.println("Некорректиный ввод.\n" +
                            "Введите количество человек целым положительным числом.");
                    in.next();
                }
            }


        List<Calculator> items = new ArrayList<>();
         out.println("Введите название товара");
         String nextPosition = in.next();

        out.println("Введите стоимость в формате: 'рубли.копейки' [10,45, 11,40]");
        double nextPrice = in.nextDouble();
        int i = 0;


            while (!nextPosition.equalsIgnoreCase("Завершить")) {
                out.println("Хотите еще добавить товар?, если да то Введите название товара" +
                        "\nДля завершения введите 'Завершить'");
                items.add(new Calculator(nextPosition, nextPrice));
                nextPosition = in.next();
                if (!nextPosition.equalsIgnoreCase("Завершить")) {
                    out.println("Введите стоимость в формате: 'рубли.копейки' [10,45, 11,40]");
                    nextPrice = in.nextDouble();
                }
                i += 1;
            }

        double sum = 0;
        for (int j = 0; j < i; j++)
        sum += items.get(j).price;
        double amout = sum / persons;
        int ruble = (int) Math.floor(amout);
        String endingRuble;

        switch ((int) ruble % 10) {
            case 1:
                endingRuble = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                endingRuble = "рубля";
                break;
            default:
                endingRuble = "рублей";
        }

        out.println("Добавленные товары:");
        for (int j = 0; j < i; j++)
        out.println(items.get(j).name + " " + items.get(j).price + " " + endingRuble);

        out.println("Каждый из гостей должен заплатить:" + " " + String.format("%.2f", amout) + " " + endingRuble);

        }
    }


