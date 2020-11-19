package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}
	// retorna uma matriz bidimensional booleana
	public abstract boolean[][] possibleMoves();
	// Retorna se � um movimento possivel essa determinada posi��o
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	// Verifica se � um movimento poss�vel
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) return true;
			}
		}
		return false;
	}

}
