import java.util.*;

/**
 *
 * @author gaoyuan.gy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            float val = cin.nextFloat(), sum = 0;
            if (Math.abs(val) < 0.0000001) {
                break;
            }
            int cnt = 0;
            while (sum - val < 0.0000001) {
                cnt++;
                sum += 1.0 / (cnt + 1);
            }
            System.out.println(cnt + " card(s)");
        }
    }
}
