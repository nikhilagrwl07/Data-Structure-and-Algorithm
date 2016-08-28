package ap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num > 0) {
            String[] numbers = br.readLine().split(" ");
            Vector<Integer> ap = new Vector<Integer>();
            for (String str : numbers) {
                ap.add(Integer.parseInt(str));
            }
            int first = ap.get(0);
            int last = ap.get(ap.size() - 1);
            int incr = (last - first) / num;
            if (incr > 0) {
                for (int i = first; i <= last; i += incr) {
                    if (!ap.contains(i)) {
                        System.out.println(i);
                        break;
                    }
                }
            } else if (incr < 0) {
                for (int i = first; i >= last; i += incr) {
                    if (!ap.contains(i)) {
                        System.out.println(i);
                        break;
                    }
                }

            }


        }



    }
}
