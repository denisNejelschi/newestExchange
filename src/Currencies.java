/**
 * The Currencies enum represents different currency types along with their exchange rates.
 */
public enum Currencies {
  USD(1.0),
  EUR(0.93),
  CAD(1.34),
  UAH(37.6),
  GBP(0.74),
  MDL(17.84);

  private final double rates;
  /**
   * Constructor for Currencies enum.
   *
   * @param rates The exchange rate associated with the currency.
   */

  Currencies(double rates) {
    this.rates = rates;
  }
  /**
   * Get the exchange rate for the currency.
   *
   * @return The exchange rate for the currency.
   */
  public double getRates() {
    return rates;
  }
}
