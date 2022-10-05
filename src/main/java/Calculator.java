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
                price = price + getPrice();
            }

        }
        System.out.println("Добавленные товары:\n" + food);
        double result = price / people;
        String temp = "Каждый человек должен заплатить %.2f" + getDeclination((int) Math.floor(result));
        System.out.println(String.format(temp, result));
    }


    static double getPrice() {
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

    private static String getDeclination(int rouble) {

        if ((rouble % 100 / 10) == 1){
            return " рублей.";
        }
        switch (rouble % 10){
            case 1:
                return " рубль.";
            case 2:
            case 3:
            case 4:
                return " рубля.";
            default:
                return " рублей.";
        }
    }
}