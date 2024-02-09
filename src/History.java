import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The History class represents the transaction history for currency exchanges.
 */
public class History {

  private static final List<String> exchangeHistory = new ArrayList<>();
  private final File file = new File("file.exchangeHistory");

  /**
   * Saves an exchange transaction to the history.
   *
   * @param toAmount     The amount after the exchange.
   * @param fromAmount   The amount before the exchange.
   * @param fromCurrency The currency before the exchange.
   * @param toCurrency   The currency after the exchange.
   */
  public void saveExchange(double toAmount, double fromAmount, String fromCurrency,
      String toCurrency) {
    // Formatting the current date and time
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = sdf.format(new Date());
    System.out.println(formattedDate);

    // Creating the exchange message
    String exchangeMessage = String.format("%.2f %s equals to %.2f %s%n",
        fromAmount, fromCurrency, toAmount, toCurrency);

    // Building the transaction details message
    StringBuilder sb = new StringBuilder();
    sb.append(sdf.format(new Date()));

    sb.append(" Transaction from: ").append(exchangeMessage);

    exchangeHistory.add(sb.toString());
    // Creating exchange information for logging
    System.out.println("Exchange saved in history.");
    String exchangeInfo = String.format("Amount: %.2f %s exchanged to %.2f %s",
        fromAmount, fromCurrency, toAmount, toCurrency);
    writeToFile(exchangeInfo);
  }

  /**
   * Displays the exchange history.
   */
  public void viewHistory() {
    if (exchangeHistory.isEmpty()) {
      System.out.println("Exchange history is empty.");
    } else {
      System.out.println("Exchange history: ");
      for (String savedExchange : exchangeHistory) {
        System.out.println(savedExchange);
      }
    }
  }

  /**
   * Writes a line to the file.
   *
   * @param line The line to be written to the file.
   */

  private void writeToFile(String line) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String formattedDate = sdf.format(new Date());
      // Writing the formatted date and line to the file
      bw.write(formattedDate + " " + line);
      bw.newLine();
    } catch (IOException e) {
      System.out.println("Error writing to file.");
    }
  }
}

