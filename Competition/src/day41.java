import java.util.Arrays;
import java.util.Scanner;

public class day41 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[6];

        while(t-- != 0)
        {
            for(int i = 0; i < 6; i++) arr[i] = in.nextInt();
            Arrays.sort(arr);

            if(arr[0] + arr[1] > arr[2] && arr[3] + arr[4] > arr[5] ||
                    arr[0] + arr[2] > arr[3] && arr[1] + arr[4] > arr[5] ||
                    arr[0] + arr[3] > arr[4] && arr[1] + arr[2] > arr[5] ||
                    arr[0] + arr[4] > arr[5] && arr[1] + arr[2] > arr[3])
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
        }
    }
}
