import java.util.Scanner;

import java.util.*;

public class day38 {
    static int[] parent, cost, value, groupCost, groupValue;
    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 云朵数量
        int m = sc.nextInt(); // 搭配关系数量
        int W = sc.nextInt(); // 总钱数

        cost = new int[n + 1];
        value = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            cost[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            union(u, v);
        }

        // 合并同一个连通块的价格和价值
        Map<Integer, Integer> idMap = new HashMap<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (!idMap.containsKey(root)) {
                idMap.put(root, idx++);
            }
        }

        groupCost = new int[idx];
        groupValue = new int[idx];
        for (int i = 1; i <= n; i++) {
            int gid = idMap.get(find(i));
            groupCost[gid] += cost[i];
            groupValue[gid] += value[i];
        }

        // 0-1 背包
        int[] dp = new int[W + 1];
        for (int i = 0; i < idx; i++) {
            int c = groupCost[i];
            int v = groupValue[i];
            for (int j = W; j >= c; j--) {
                dp[j] = Math.max(dp[j], dp[j - c] + v);
            }
        }

        System.out.println(dp[W]);
    }
}

