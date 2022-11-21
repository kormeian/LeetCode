class Solution {
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(entrance);
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[entrance[0]][entrance[1]] = true;
		int steps = 0;
		while (!queue.isEmpty()) {
			steps++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '+' || visited[x][y]) {
						continue;
					}
					if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
						return steps;
					}
					visited[x][y] = true;
					queue.add(new int[]{x, y});
				}
			}
		}
		return -1;
    }
}