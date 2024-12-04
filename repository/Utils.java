package repository;

import java.text.NumberFormat;
import java.util.Locale;

public interface Utils {
  public static String currencyFormat(String price) {
      Double amount = Double.parseDouble(price);
  
      Locale localeID = new Locale("id", "ID");
      NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);
  
      return currencyFormatter.format(amount);
    }
}
