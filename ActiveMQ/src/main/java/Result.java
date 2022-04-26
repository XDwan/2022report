import java.io.Serializable;

public class Result implements Serializable {
    double mean;
    double var;
    double min;
    double max;

    @Override
    public String toString() {
        return "Result{" +
                "mean=" + mean +
                ", var=" + var +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
