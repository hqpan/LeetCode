class Solution {
    char[][] board;
    boolean[][] visited;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        int rows = board.length;
        int columns = board[0].length;
        int length = 0;
        visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++)
                if (find(row, column, length))
                    return true;
        }
        return false;
    }

    public boolean find(int row, int column, int length) {
        if (length == word.length())
            return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column] || board[row][column] != word.charAt(length))
            return false;
        visited[row][column] = true;
        boolean ans = find(row - 1, column, length + 1) || 
            find(row + 1, column, length + 1) ||
            find(row, column - 1, length + 1) || 
            find(row, column + 1, length + 1);
        visited[row][column] = false;
        return ans;
    }
}