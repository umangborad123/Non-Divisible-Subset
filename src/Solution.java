import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int check = in.nextInt();
        int count = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() % check;
        }
        Map<Integer, Integer> countMap = new HashMap();
        for (int i = 0; i < check; i++) {
            countMap.put(i, 0);
        }
        for (int i = 0; i < n; i++) {
            if (countMap.get(a[i]) == 0) {
                countMap.put(a[i], 1);
            } else
                countMap.put(a[i], countMap.computeIfPresent(a[i], (k, v) -> v + 1));
        }
        for (int i = 1; i <= check / 2; i++) {
            if (i != (check - i)) {

                if (countMap.get(i) > countMap.get(check - i))
                    count += countMap.get(i);
                else
                    count += countMap.get(check - i);

            } else {
                if (countMap.get(i) != 0)
                    count++;
            }

        }
        if (countMap.get(0) >= 1)
            count += countMap.get(0);
        System.out.println(count);

    }
}