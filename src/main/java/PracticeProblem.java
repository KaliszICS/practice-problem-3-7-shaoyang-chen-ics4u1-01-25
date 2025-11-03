public class PracticeProblem {
	public static void main(String args[]) {
	}
	public static int searchMazeMoves(String[][] maze) {
		if (maze == null || maze.length == 0) return -1;
		int startRow = maze.length - 1;
		int startCol = 0;
		if (!"S".equals(maze[startRow][startCol])) {
			return -1;
		}
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		return dfsHelperMoves(maze, startRow, startCol, visited, 0);
	}
	public static int dfsHelperMoves(String[][] maze, int curRow, int curCol, boolean[][] visited, int moves) {
		// OOBE
		if (curRow < 0 || curRow >= maze.length || curCol < 0 || curCol >= maze[0].length) {
			return -1;
		}
		// WALL
		if ("*".equals(maze[curRow][curCol])) {
			return -1;
		}
		// VISITED
		if (visited[curRow][curCol]) {
			return -1;
		}
		// REACH
		if ("F".equals(maze[curRow][curCol])) {
			return moves;
		}
		// mark true
		visited[curRow][curCol] = true;
		// re 4dir
		int up = dfsHelperMoves(maze, curRow - 1, curCol, visited, moves + 1);
		int down = dfsHelperMoves(maze, curRow + 1, curCol, visited, moves + 1);
		int left = dfsHelperMoves(maze, curRow, curCol - 1, visited, moves + 1);
		int right = dfsHelperMoves(maze, curRow, curCol + 1, visited, moves + 1);
		// undo mark
		visited[curRow][curCol] = false;
		// minMoves
		int minMoves = -1;
		if (up != -1) minMoves = (minMoves == -1) ? up : Math.min(minMoves, up);
		if (down != -1) minMoves = (minMoves == -1) ? down : Math.min(minMoves, down);
		if (left != -1) minMoves = (minMoves == -1) ? left : Math.min(minMoves, left);
		if (right != -1) minMoves = (minMoves == -1) ? right : Math.min(minMoves, right);
		return minMoves;
	}
}
