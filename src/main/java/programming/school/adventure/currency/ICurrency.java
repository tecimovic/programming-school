package programming.school.adventure.currency;

/**
 * Classes of this type describe the currency.
 * 
 * @author timotej
 *
 */
public interface ICurrency {
    /**
     * Given the value of a currency, return the human-readable description.
     * 
     * @param value
     * @return
     */
    public String describeCurrency(int value);
}
