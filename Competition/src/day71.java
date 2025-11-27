import java.util.*;

public class day71 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] number = s.toCharArray();
        int n = number.length;
        int sign;
        if(number[n-1] == 'X') {
            sign = 10;
        } else {
            sign = number[n-1] - '0';
        }
        long sum = 0;
        int p = 1;
        for(int i = 0;i <= 10;i++) {
            if(number[i] == '-') {
                continue;
            }
            sum += ((number[i] - '0') * p++);
        }
        sum %= 11;
        sum = (int)sum;
        if(sum == sign) {
            System.out.println("Right");
        } else {
            char newSign;
            if(sum == 10) {
                newSign = 'x';
            } else {
                newSign = (char) (sum + '0');
            }
            System.out.println(s.substring(0,12) + newSign);
        }
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int x : nums) {
            if(hash.contains(x)) {
                return true;
            }
            hash.add(x);
        }
        return false;
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int[] hash = new int[26];
        for(int i = 0;i < s1.length();i++) {
            hash[s1.charAt(i) - 'a']++;
        }
        for(int i = 0;i < s2.length();i++) {
            hash[s2.charAt(i) - 'a']--;
            if(hash[s2.charAt(i)- 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
