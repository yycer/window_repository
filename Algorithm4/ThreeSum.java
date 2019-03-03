import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static int[] getNums(String filePath){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> nums = new ArrayList<>();
        while(scanner.hasNextInt()){
            nums.add(scanner.nextInt());
        }
        int[] numsArr = nums.stream().mapToInt(i -> i).toArray();
        return numsArr;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String filePath = "D:\\Test\\algs4-data\\1Kints.txt";
        int[] numsArr = getNums(filePath);
        int result = count(numsArr);
        long end = System.currentTimeMillis();
        System.out.println("Count:" + result + " time: " + (end - start) / 1000.0);
    }
}
