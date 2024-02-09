import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The ExchangeManager class provides methods for handling currency exchange operations.
 */
public class ExchangeManager {

  private static final Scanner scanner = new Scanner(System.in);
  /**
   * Executes the currency exchange option, allowing the user to convert between different currencies.
   */
  public static void exchangeOption() {

    try {
      System.out.println("We change: " + Arrays.toString(Currencies.values()));
      System.out.println("Choose a currency you want to convert:");
      String fromCurrency = scanner.nextLine().toUpperCase();
      Currencies from = Currencies.valueOf(fromCurrency);
      System.out.println("Choose a currency you want to have:");
      String toCurrency = scanner.nextLine().toUpperCase();
      Currencies to = Currencies.valueOf(toCurrency);
      System.out.println("Enter the amount:");
      double amount = scanner.nextDouble();
      scanner.nextLine();

      double result = exchange(from, to, amount);
      History history = new History();
      history.saveExchange(result, amount, fromCurrency, toCurrency);

      // Output the result
      if (result != -1) {
        System.out.printf("%.2f %s equals to %.2f %s%n", amount, fromCurrency, result,
            toCurrency);
      }
    } catch (IllegalArgumentException | InputMismatchException inputMismatchException) {
      System.out.println("Invalid currency input.");
    }
  }
  /**
   * Performs the currency exchange calculation.
   *
   * @param from   The source currency.
   * @param to     The target currency.
   * @param amount The amount to be exchanged.
   * @return The result of the currency exchange.
   */
  private static double exchange(Currencies from, Currencies to, double amount) {
    double fromRate = from.getRates();
    double toRate = to.getRates();
    return amount * (toRate / fromRate);

  }
}