package boardgame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece pieces[][];
	
	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1) throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	//Retorna a peça de uma determinada posição
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) throw new BoardException("Position not on the board");
		return pieces[row][column];
	}
	//Retorna a peça de uma determinada posição
	public Piece piece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");
		return pieces[position.getRow()][position.getColumn()];
	}
	// Coloca uma peça em uma determinada posição
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) throw new BoardException("There is already a piece on position: "+ position);
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	// Remove a peça do tabuleiro
	public Piece removePiece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");
		if(piece(position) == null) return null;
		
		Piece aux = piece(position);
		aux.position = null;
		
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	//Verifica se a posição existe no tabuleiro
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	//Verifica se a posição existe no tabuleiro
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	// Verifica se existe uma peça no Lugar
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");
		return piece(position) != null;
	}
}
