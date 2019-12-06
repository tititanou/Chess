package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class PawnMoves implements IMove {
    @Override
    /***
     * pawn moves depending on if it has already moved or not and if it just walks or if it eats
     */
    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd) {
        List<IChess.ChessPosition> possibleMoves = new ArrayList<>();
        if (brd.chessPiece(p).getPieceColor() == IChess.ChessColor.CLR_WHITE) {
            Moves.pawnEats(possibleMoves , brd ,1 ,-1 ,1 , p);
            Moves.pawnEats(possibleMoves , brd ,-1 ,-1 ,1 , p);
            if (!brd.chessPiece(p).hasMoved()) {
                Moves.pawnWalk(possibleMoves , brd ,0 ,-1 ,2 , p);
            }
            else {
                Moves.pawnWalk(possibleMoves , brd ,0 ,-1 ,1 , p);
            }
        }
        else{
            Moves.pawnEats(possibleMoves , brd ,1 ,1 ,1 , p);
            Moves.pawnEats(possibleMoves , brd ,-1 ,1 ,1 , p);
            if (!brd.chessPiece(p).hasMoved()) {
                Moves.pawnWalk(possibleMoves , brd ,0 ,1 ,2 , p);
            }
            else {
                Moves.pawnWalk(possibleMoves , brd ,0 ,1 ,1 , p);
            }
        }
    return possibleMoves;
    }
}
