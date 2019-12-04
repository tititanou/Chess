package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class utilities {


    public static boolean isEmpty (IChess.ChessPosition p){

        Board brd = new Board();
        Piece pieceTemporaire = brd.chessPiece(p);
        if (pieceTemporaire == null)
        {
            return true;
        }
        else {
             return false;
        }
    }

    public static boolean isValidPosition (IChess.ChessPosition p) {

        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            return true;

        } else {
            return false;
        }
    }


    public static boolean isSameColor (IChess.ChessPosition p, IChess.ChessColor color) {
            Board brd = new Board();
            Piece piecette = brd.chessPiece(p);
            if (piecette != null) {

                IChess.ChessColor colorPiecette = piecette.getPieceColor();

                if (colorPiecette == color ){

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