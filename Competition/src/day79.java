public class day79 {
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int n = gas.length;
        for(int i = 0; i < n; i++)
        {
            int rest = 0;
            int step = 0;
            for( ; step < n; step++)
            {
                int index = (i + step) % n;
                rest = rest + gas[index] - cost[index];
                if(rest < 0)
                {
                    break;
                }
            }
            if(rest >= 0)
            {
                return i;
            }
            i = i + step;
        }
        return -1;
    }
}
