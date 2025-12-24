import java.util.Arrays;
import java.util.Scanner;

public class day95 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), x = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        long ret = 0;
        int index = n - 1 - x;

        if(index < 0)
        {
            for(int i = 0; i < n; i++) ret += arr[i];
        }
        else
        {
            ret += arr[index] * x;
            for(int i = index + 1; i < n; i++)
            {
                ret += arr[i] - arr[index];
            }
        }

        System.out.println(ret);
    }
}