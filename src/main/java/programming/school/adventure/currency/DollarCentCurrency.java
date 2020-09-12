package programming.school.adventure.currency;

/**
 * Dollar cent currency. Default.
 * 
 * @author timotej
 *
 */
public class DollarCentCurrency implements ICurrency {

  public static final ICurrency INSTANCE = new DollarCentCurrency();
  
  @Override
  public String describeCurrency(int value) {
    StringBuilder ret = new StringBuilder();
    if ( value == 0 ) 
      return "no money";
    int dollars =  value/100;
    int cents = value%100;
    if ( dollars > 0 )
      ret.append(dollars).append(" dollar");
    if ( dollars > 1 ) 
      ret.append("s");
    if ( dollars > 0 && cents > 0 ) 
      ret.append(" and ");
    if ( cents > 0 ) 
      ret.append(cents).append(" cent");
    if ( cents > 1 ) 
      ret.append("s");
    return ret.toString();
  }

}
