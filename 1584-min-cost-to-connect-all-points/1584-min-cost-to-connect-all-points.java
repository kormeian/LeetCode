import java.util.*;
class Solution {
    public int minCostConnectPoints(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for (int i = 1; i < points.length; i++) {
            queue.add(new int[]{0, i, getDistance(points[0], points[i])});
        }
        boolean[] visited = new boolean[points.length];
        visited[0] = true;
        int answer = 0;
        while (!isAllVisited(visited)) {
            int[] curNode = queue.poll();
            if (visited[curNode[1]]) continue;
            visited[curNode[1]] = true;
            answer += curNode[2];
            for (int i = 0; i < points.length; i++) {
                int distance = getDistance(points[curNode[1]],points[i]);
                if(distance != 0){
                    queue.add(new int[]{curNode[1],i,distance});
                }
            }
        }
        return answer;
    }
    public boolean isAllVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    public int getDistance(int[] p1, int[] p2) {
        return Math.abs(p2[0] - p1[0]) + Math.abs(p2[1] - p1[1]);
    }
}