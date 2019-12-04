package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {

    static private ChessModel instance;
    private Board board1;

    private ChessModel(){
      this.board1 = new Board();

    }

    public static ChessModel getInstance(){
        if (instance == null){
            instance = new ChessModel();
        }
        return instance;
    }

    @Override
    public void reinit() {

    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            Piece piece1 = board1.chessPiece(p);
            if (piece1 != null) {
                ChessType type1 = piece1.getPieceType();
                return type1;
            }
            else {
                throw new EmptyCellException();
            }
        }
        else{
            throw new OutOfBoardException();
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            Piece piece1 = board1.chessPiece(p);
            if (piece1 != null) {
                ChessColor color1 = piece1.getPieceColor();
                return color1;
            } else {
                throw new EmptyCellException();
            }
        }
        else{
            throw new OutOfBoardException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return board1.counter(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        List<ChessPosition> possibleMoves = new ArrayList();
        Piece piece1 = board1.chessPiece(p);
        if (piece1 != null){
            possibleMoves = piece1.getMove(p,board1);
        }
        return possibleMoves;
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        Piece piece0 = board1.chessPiece(p0);
        this.board1.setBoardPos(p1 , piece0);
        this.board1.setBoardPos(p0 , null);

    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        return ChessKingState.KING_SAFE;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        ArrayList possibleMoves = new ArrayList();
        return possibleMoves;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }
}
