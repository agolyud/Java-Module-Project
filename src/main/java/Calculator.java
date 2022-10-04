import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {

    static void calculate(int people) {
        String food = "";
        double price = 0.0;

        while (true) {
            System.out.println("Хотите еще добавить товар?, если да то Введите название товара" +
                    "\nДля завершения введите 'Завершить'");
            Scanner scanner = new Scanner(System.in);
            String inputFood = scanner.next();

            if (inputFood.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                food = food + inputFood + "\n";
                price = price + price();
            }

        }
        int rouble = (int) Math.round(price);
        System.out.println("Добавленные товары:\n" + food);
        String message = "Каждый человек должен заплатить %.2f" + " " + declination(rouble);
        System.out.println(String.format(message, (price / people)));
    }


    static double price() {
        while (true) {
            System.out.println("Введите стоимость в формате: 'рубли.копейки' [10,45, 11,40]");
            double inputPrice = 0;
            try {
                Scanner scanner = new Scanner(System.in);
                inputPrice = scanner.nextDouble();
                if (inputPrice <= 0){
                    System.out.println("Неверное значение");
                } else {
                    return inputPrice;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверное значение");
            }
        }
    }

    private static String declination(int rouble) {
        switch (rouble % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}