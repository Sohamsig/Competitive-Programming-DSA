class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Initialize arrays of length 2
        for (int a = 1; a <= m; a++) {
            for (int b = 1; b <= m; b++) {
                if (a == b) continue;

                if (a < b) {
                    up[b]++;
                } else {
                    down[b]++;
                }
            }
        }

        // Extend to length n
        for (int len = 3; len <= n; len++) {
            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 1; i <= m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long totalUp = prefUp[m];

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                // Previous move was DOWN and previous value < current value
                newUp[v] = prefDown[v - 1];

                // Previous move was UP and previous value > current value
                newDown[v] = (totalUp - prefUp[v] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}
