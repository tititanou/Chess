package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Piece {

    private IChess.ChessColor pieceColor;
    private IChess.ChessType pieceType;

    public Piece (IChess.ChessColor color, IChess.ChessType type){
        this.pieceColor = color;
        this.pieceType = type;
    }

    public IChess.ChessColor getPieceColor() {
        return this.pieceColor;
    }

    public IChess.ChessType getPieceType() {
        return this.pieceType;

    }


}