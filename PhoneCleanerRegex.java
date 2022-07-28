 package practice.regex;


import java.util.Scanner;


 public class PhoneCleanerRegex {
  public static void main(String[] args) {
    System.out.println("Введите номер телефона: ");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        scanner.close();
        break;
      }

      String prefixEight = "^[8]?";
      String prefixSeven = "^([+]7|7)";
      String staples = "([-]|[\\s]|[(]|[\\s][(])?";
      String parenthesis = "([)]|[\\s]|[)][\\s]|[-])?";
      String numThree = "[0-9]{3}";
      String numTwo = "[0-9]{2}";
      String separate = "([-]|[\\s])?";

      String firstSeven =  prefixSeven + staples + numThree  + parenthesis +
              numThree + separate + numTwo + separate + numTwo;

      String firstNine = staples + numThree  + parenthesis
              + numThree + separate + numTwo + separate + numTwo;

      String firstEight = prefixEight + staples + numThree  + parenthesis
              + numThree + separate + numTwo + separate + numTwo;

      if (input.matches(firstSeven)) {
        input = input.replaceAll("[^0-9]+", "");
        System.out.println(input);
      } else if (input.matches(firstNine)){
        input = input.replaceAll("[^0-9]+", "");
        System.out.println("7" + input);
      } else if (input.matches(firstEight)){
        input = input.replaceFirst("8","7");
        input = input.replaceAll("[^0-9]+", "");
        System.out.println(input);
      } else {
        System.out.println("Неверный формат номера");
      }
    }
  }
}