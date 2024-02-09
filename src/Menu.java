import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The Menu class provides a text-based menu interface for interacting with the currency exchange program.
 */
public class Menu {
  /**
   * Runs the main menu loop, allowing the user to choose different options.
   */
  public static void run() {
    Scanner scanner = new Scanner(System.in);
    try {
      while (true) {
        mainMenu();
        int choice = getUserChoice(scanner);
        userChoice(choice);
      }
    } catch (InputMismatchException e) {
      System.out.println("Input error. Please enter a valid value.");
    }
    scanner.nextLine();
  }
  /**
   * Displays the main menu options.
   */
  private static void mainMenu() {
    System.out.println("\nMAIN MENU\n");
    System.out.println("1. View available currencies for exchange ");
    System.out.println("2. Exchange ");
    System.out.println("3. View currency exchange history ");
    System.out.println("4. Exit the program");
  }
  /**
   * Gets the user's choice from the menu.
   *
   * @param scanner The Scanner object for user input.
   * @return The user's choice.
   */
  private static int getUserChoice(Scanner scanner) {
    while (true) {
      System.out.print("Choose an option: ");
      try {
        return scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Input error. Please enter a valid value.");
        scanner.nextLine();
      }
    }
  }
  /**
   * Performs actions based on the user's menu choice.
   *
   * @param choice The user's menu choice.
   */
  private static void userChoice(int choice) {
    History history = new History();
    try {
      switch (choice) {
        case 1:
          System.out.println(
              "Currencies available for exchange: " + Arrays.toString(Currencies.values()));
          break;
        case 2:
          ExchangeManager.exchangeOption();
          break;
        case 3:
          //System.out.println("Currency exchange history: ");
          history.viewHistory();
          break;
        case 4:
          System.out.println("Exiting the program");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid input. Please try again. ");
      }
    } catch (InputMismatchException e) {
      System.out.println("Input error. Please enter a valid value.");
    }
  }
}



