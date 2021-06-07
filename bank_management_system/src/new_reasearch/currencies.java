package new_reasearch;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;

public class currencies {
 
    private double getRate(String from, String to) {
        try {
            URL url = new URL("http://quote.yahoo.com/d/quotes.csv?f=l1&s=" + from + to + "=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line);
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No Internet Connection...!");
        }
 
        return 0;
    }
    

 
    public double getcurrencies(String C1, String C2) {
        return getRate(C1, C2);
    }
 
    
 /*
    
    public static void main(String args[]) {
        currencies exchange = new currencies();
 
        double rateUsd = exchange.getUsdIQDRate("USD","IQD");
        System.out.println("USD/IQD: " + rateUsd);
      
        double m = rateUsd*100;
        System.out.println("test: "+m);
        double m1 = 100000/rateUsd ;
        System.out.println("test: "+m1);
        
        
    }
    
    */
}