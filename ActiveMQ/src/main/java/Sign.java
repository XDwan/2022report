import java.io.Serializable;
import java.util.Random;

public class Sign implements Serializable {
    double sign;
    public Sign(){
        Random random = new Random();
        sign = random.nextGaussian();
    }

    @Override
    public String toString() {
        return "Sign{" +
                "sign=" + sign +
                '}';
    }
}
