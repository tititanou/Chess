package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.List;

public class Moves {

    /**
     * This method verifies that movements of pieces are not outside the try
     * @param p
     * @return
     */
    public static boolean isValidPosition(IChess.ChessPosition p){
        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *  This method checks that there is nobody on the move box
     * @param p
     * @param b
     * @return
     */
    public static boolean isEmptyCell(IChess.ChessPosition p , Board b){
        if (b.chessPiece(p) == null){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method verifies that there are no pieces of the same color where we want move
     * @param p
     * @param clr
     * @param b
     * @return
     */
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

    /**
     * This method allows you to enter a moving point as a parameter Using it from the class we created
     * @param l
     * @param b
     * @param vX
     * @param vY
     * @param dist
     * @param p
     * @return
     */
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

    /***
     * the "walk" of pawn
     * @param l possible moves list
     * @param b game board
     * @param vX the way he can move on the x absis
     * @param vY the way he can move on the y absis
     * @param dist maximum nb of positions for a move in one direction
     * @param p initial position
     * @return completed possible moves list
     */
    public static List<IChess.ChessPosition> pawnWalk(List<IChess.ChessPosition> l ,Board b , int vX , int vY , int dist , IChess.ChessPosition p){
        int i;
        for (i = 1 ; i <= dist ; i ++) {
            IChess.ChessPosition p1 = new IChess.ChessPosition(p.x + vX * i, p.y + vY * i);
            if (Moves.isValidPosition(p1) && Moves.isEmptyCell(p1, b)) {
                l.add(p1);
            } else {
                break;
            }
        }
        return l;
    }

    /***
     * the way of pawn to eat
     * @param l possible moves list
     * @param b
     * @param vX
     * @param vY
     * @param dist
     * @param p
     * @return completed possible moves list
     */
    public static List<IChess.ChessPosition> pawnEats(List<IChess.ChessPosition> l ,Board b , int vX , int vY , int dist , IChess.ChessPosition p){
        int i;
        for (i = 1 ; i <= dist ; i ++){
            IChess.ChessPosition p1 = new IChess.ChessPosition(p.x + vX * i , p.y + vY * i);
            if(Moves.isValidPosition(p1) && !Moves.isEmptyCell(p1 , b)) {
                Piece piece1 = b.chessPiece(p1);
                IChess.ChessColor c = piece1.getPieceColor();
                if (!Moves.isSameColor(p, c, b)) {
                    l.add(p1);
                    break;
                } else {
                    break;
                }
            }
            else{
                break;
            }
        }
        return l;
    }



}



