class Solution {

    static class Node {
        long count;
        long waviness;

        Node(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String num;
    private Node[][][][] memo;
    private boolean[][][][] visited;

    private Node dfs(int pos, int prev1, int prev2, int started, boolean tight) {

        if (pos == num.length()) {
            return new Node(1, 0);
        }

        if (!tight && visited[pos][prev1][prev2][started]) {
            return memo[pos][prev1][prev2][started];
        }

        int limit = tight ? num.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= limit; digit++) {

            boolean nextTight = tight && (digit == limit);

            if (started == 0 && digit == 0) {

                Node next = dfs(
                        pos + 1,
                        10,
                        10,
                        0,
                        nextTight
                );

                totalCount += next.count;
                totalWaviness += next.waviness;

            } else {

                if (started == 0) {

                    Node next = dfs(
                            pos + 1,
                            digit,
                            10,
                            1,
                            nextTight
                    );

                    totalCount += next.count;
                    totalWaviness += next.waviness;

                } else {

                    int add = 0;

                    if (prev2 != 10) {
                        if ((prev1 > prev2 && prev1 > digit)
                                || (prev1 < prev2 && prev1 < digit)) {
                            add = 1;
                        }
                    }

                    Node next = dfs(
                            pos + 1,
                            digit,
                            prev1,
                            1,
                            nextTight
                    );

                    totalCount += next.count;
                    totalWaviness += next.waviness + (long) add * next.count;
                }
            }
        }

        Node result = new Node(totalCount, totalWaviness);

        if (!tight) {
            visited[pos][prev1][prev2][started] = true;
            memo[pos][prev1][prev2][started] = result;
        }

        return result;
    }

    private long solve(long x) {
        if (x < 0) return 0;

        num = Long.toString(x);

        memo = new Node[20][11][11][2];
        visited = new boolean[20][11][11][2];

        return dfs(0, 10, 10, 0, true).waviness;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}
