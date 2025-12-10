import java.util.PriorityQueue;
import java.util.Scanner;

public class day83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int[] hash = new int[300];
            char[] s = scanner.nextLine().toCharArray();
            for(char ch : s) {
                hash[ch]++;
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for(int i = 0;i < 300;i++) {
                if(hash[i] != 0) {
                    heap.add(hash[i]);
                }
            }
            int ret = 0;
            while(heap.size() > 1) {
                int t1 = heap.poll();
                int t2 = heap.poll();
                ret += t1 + t2;
                heap.add(t1 + t2);
            }
            System.out.println(ret);
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countMax = 0;
        char ret = 0;
        int[] hash = new int[26];
        while(scanner.hasNext()) {
            char[] s = scanner.next().toCharArray();
            for(char ch : s) {
                if(++hash[ch - 'a'] > countMax) {
                    countMax = hash[ch - 'a'];
                    ret = ch;
                }
            }
        }
        System.out.println(ret);
    }
}
