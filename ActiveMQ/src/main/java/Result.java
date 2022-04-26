import java.io.Serializable;
import java.text.DecimalFormat;

public class Result implements Serializable {
    double mean;
    double var;
    double min;
    double max;

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Sign:"+"mean=" + df.format(mean) +
                ", var=" + df.format(var) +
                ", min=" + df.format(min) +
                ", max=" + df.format(max) ;
    }
}
