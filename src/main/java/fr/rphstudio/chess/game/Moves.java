package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Moves {

    public static boolean isValidPosition(IChess.ChessPosition p){
        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isEmptyCell(IChess.ChessPosition p , Board b){
        if (b.chessPiece(p) == null){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isSameColor(IChess.ChessPosition p , IChess.ChessColor clr , Board b){
        if (b.chessPiece(p) != null){
            if (b.chessPiece(p).getPieceColor() == clr){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

}
