import java.util.Scanner;

public class day37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1;i <= n;i++) {
            arr[i] = scanner.nextInt();
        }
        int ans = merge(arr,1,n,n);
        System.out.println(ans);
    }

    private static int merge(int[] arr, int l, int r, int n) {
        if(l >= r) {
            return 0;
        }
        int ret = 0;
        int mid = (l + r) / 2;
        ret += merge(arr,l,mid,n);
        ret += merge(arr,mid+1,r,n);
        int[] tmp = new int[n+1];
        int cur1 = l,cur2 = mid + 1,i = l;
        while(cur1 <= mid && cur2 <= r) {
            if(arr[cur1] <= arr[cur2]) {
                tmp[i++] = arr[cur1++];
            } else {
                ret += (mid - cur1 + 1);
                tmp[i++] = arr[cur2++];
            }
        }
        while(cur1 <= mid) tmp[i++] = arr[cur1++];
        while(cur2 <= r) tmp[i++] = arr[cur2++];
        for(int j = l;j <= r;j++) {
            arr[j] = tmp[j];
        }
        return ret;
    }
}