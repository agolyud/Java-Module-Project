import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int people = 0;
        while (people < 2) {
            System.out.println("На сколько человек нужно разделить счет?");
            Scanner scanner = new Scanner(System.in);
            try {
                people = scanner.nextInt();
                if (people < 2) {
                    System.out.println("Неверное значение");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Неверное значение");
            }
        }
        Calculator.calculate(people);
    }
}