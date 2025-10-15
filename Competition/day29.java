import java.util.Scanner;

public class day29 {
    public static int getLongestPalindrome (String A) {
        char[] aa = A.toCharArray();
        int n = aa.length;
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            if(aa[0] == aa[1]) {
                return 2;
            } else {
                return 1;
            }
        }
        int len = 1;
        int left,right;
        if(n % 2 == 1) {
            int mid = n / 2;
            left = mid - 1;
            right = mid + 1;
        } else {
            left = n / 2 - 1;
            right = n / 2;
        }
        while(left >= 0 && right < n && aa[left] == aa[right]) {
            len += 2;
            left--;
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for(int i = 0;i < n;i++) {
            prices[i] = scanner.nextInt();
        }
        int[] maxPrices = new int[n];
        for(int i = n-2;i >= 0;i--) {
            maxPrices[i] = Math.max(prices[i+1],maxPrices[i+1]);
        }
        int maxValues = 0;
        for(int i = 0;i < n-1;i++) {
            int values = maxPrices[i] - prices[i];
            if(values > maxValues) {
                maxValues = values;
            }
        }
        System.out.println(maxValues);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        int len = getLongestPalindrome(A);
        System.out.println(len);
    }
}
