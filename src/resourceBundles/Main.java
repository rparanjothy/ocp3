package resourceBundles;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Resources ");
        Locale r = new Locale("ru","RU");
        System.out.println(r);
        System.out.println(Locale.getDefault());
        Locale.setDefault(new Locale("en","US"));
        System.out.println(Locale.getDefault());

        System.out.println(r.getDisplayCountry());
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL,r).format(Calendar.getInstance().getTime()));
        Locale.setDefault(new Locale("ru","RU"));

        ResourceBundle rr = ResourceBundle.getBundle("resourceBundles.Data",new Locale("en","US"));
        System.out.println(rr);
        System.out.println(rr.getString("name"));
    }
}
