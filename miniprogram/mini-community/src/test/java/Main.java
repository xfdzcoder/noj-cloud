import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author xfdzcoder
 */
public class Main {

    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec(new String[]{"ls", "-al"});
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                line += line;
            }
            byte[] bys = line.getBytes();
            int[] arr = new int[bys.length];
            for (int i = 0;i < bys.length; ++i) {
                arr[i] = (int) bys[i];
            }
            System.out.println(Arrays.toString(arr));
        } catch (Exception e) {
            String message = e.getMessage();
            byte[] bys = message.getBytes();
            int[] arr = new int[bys.length];
            for (int i = 0;i < bys.length; ++i) {
                arr[i] = (int) bys[i];
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
