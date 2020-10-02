package lab;

import java.util.Arrays;
import java.util.Scanner;

public class L1_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        sc.close();
        int n = (in.length() - 2 + 1) / 2;
        int[] price = new int[n];
        int i = 0;
        for (int j = 0; j < in.length() - 1; j++) {
            if (Character.isDigit(in.charAt(j))) {
                price[i] = Integer.parseInt(in.substring(j, j + 1));
                i++;
            }
        }

        System.out.println(Arrays.toString(merge(min(price), max(price))));
        
    }

    private static int[] min(int[] price) {
        StringBuilder output = new StringBuilder("");
        // Verify the first price
        if (price[0] < price[1]) {
            output.append(0);
        }

        // Verify the prices in the middle
        for (int i = 1; i < price.length - 1; i++) {
            if (price[i] < price[i - 1] && price[i] < price[i + 1]) {
                output.append(i);
            }
        }

        // Verify the prices in the last
        if (price[price.length - 1] < price[price.length - 2]) {
            output.append(price.length - 1);
        }

        int[] mins = new int[output.length()];
        for (int i = 0; i < mins.length; i++) {
            mins[i] = Integer.parseInt(output.substring(i, i + 1));
        }
        return mins;
    }

    private static int[] max(int[] price) {
        StringBuilder output = new StringBuilder("");
        // Verify the first price
        if (price[0] > price[1]) {
            output.append(0);
        }

        // Verify the prices in the middle
        for (int i = 1; i < price.length - 1; i++) {
            if (price[i] > price[i - 1] && price[i] > price[i + 1]) {
                output.append(i);
            }
        }

        // Verify the prices in the last
        if (price[price.length - 1] > price[price.length - 2]) {
            output.append(price.length - 1);
        }

        int[] maxs = new int[output.length()];
        for (int i = 0; i < maxs.length; i++) {
            maxs[i] = Integer.parseInt(output.substring(i, i + 1));
        }
        return maxs;
    }

    private static int[] merge(int[] min, int[] max) {
        StringBuilder output = new StringBuilder("");

        // int i = 1; // index for min
        int j = 0; // index for max
        if (max[0] < min[0]) {
            j++;
        }
        // Verify the first maximum

        try {
            for (int i = 0; i < min.length; i++) {
                output.append(min[i]);
                output.append(max[j]);
                j++;
            } // Append them
        } catch (Exception e) {
            //Ignore Index Out of Bound Exception and go on
            output.deleteCharAt(output.length() - 1);
            // If one min is at the end of the output, then remove it
        }
        

        int[] merged = new int[output.length()];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = Integer.parseInt(output.substring(i, i + 1));
        }

        //Final check if you should not buy at all!
        if (merged.length == 1) {
            merged = null;
        }
        return merged;
    }
}
