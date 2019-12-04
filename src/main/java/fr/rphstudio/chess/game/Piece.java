package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.List;

public class Piece {

    private IChess.ChessColor pieceColor;
    private IChess.ChessType pieceType;
    private IMove move;
    private  int counter;

    public Piece (IChess.ChessColor color, IChess.ChessType type, IMove mv){
        this.pieceColor = color;
        this.pieceType = type;
        this.move=mv;
        this.counter = 0;

    }


    public IChess.ChessColor getPieceColor() {
        return this.pieceColor;
    }

    public IChess.ChessType getPieceType() {
        return this.pieceType;

    }
    public List<IChess.ChessPosition> getMove(IChess.ChessPosition p,Board bord){
        List<IChess.ChessPosition> myList = this.move.getMoves(p,bord);
        return myList;
    }

    public  int getCounter(){
        return this.counter;
    }

    public void increaseCounter() {
        this.counter = counter + 1;
    }

    public boolean hasMoved(){
        return (counter > 0);
    }
}