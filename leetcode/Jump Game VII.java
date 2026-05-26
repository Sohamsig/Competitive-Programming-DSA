class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int farthest = 0;

        while (!q.isEmpty()) {

            int i = q.poll();

            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {

                if (s.charAt(j) == '0' && !visited[j]) {

                    if (j == n - 1)
                        return true;

                    visited[j] = true;
                    q.offer(j);
                }
            }

            farthest = end;
        }

        return n == 1;
    }
}
