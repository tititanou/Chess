package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.List;

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

    public static List<IChess.ChessPosition> straightMoves(List<IChess.ChessPosition> l ,Board b , int vX , int vY , int dist , IChess.ChessPosition p){
        int i;
        for (i = 1 ; i <= dist ; i ++){
            IChess.ChessPosition p1 = new IChess.ChessPosition(p.x + vX * i , p.y + vY * i);
            if(Moves.isValidPosition(p1)){
                if(Moves.isEmptyCell(p1 , b)){
                    l.add(p1);
                }
                else {
                    Piece piece1 = b.chessPiece(p1);
                    IChess.ChessColor c = piece1.getPieceColor();
                    if(!Moves.isSameColor(p , c , b)){
                        l.add(p1);
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        return l;
    }

}
