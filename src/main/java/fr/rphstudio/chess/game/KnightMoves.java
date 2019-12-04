package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves implements IMove {




    @Override
    public List<ChessPosition> getMoves(ChessPosition p, Board brd) {


        List <ChessPosition> possibleMoves = new ArrayList<>();

        ChessPosition p1 = new ChessPosition(p.x+1,p.y+2);
        if(Utilities.isValidPosition(p1)) {
            if ( Utilities.isEmpty(p1, brd)) {
                possibleMoves.add(p1);
            } else {
                ChessColor c = brd.chessPiece(p1).getPieceColor();
                if (Utilities.isSameColor(p, c, brd) == false) {
                    possibleMoves.add(p1);

                }

            }
        }
        ChessPosition p2 = new ChessPosition(p.x+2,p.y+1);
        if(Utilities.isValidPosition(p2)) {
            if ( Utilities.isEmpty(p2, brd)) {
                possibleMoves.add(p2);
            } else {
                ChessColor c = brd.chessPiece(p2).getPieceColor();
                if (Utilities.isSameColor(p, c, brd) == false) {
                    possibleMoves.add(p2);

                }

            }
        }



        ChessPosition p3 = new ChessPosition(p.x+2,p.y-1);
        if(Utilities.isValidPosition(p3)) {
            if ( Utilities.isEmpty(p3, brd)) {
                possibleMoves.add(p3);
            } else {
                ChessColor c = brd.chessPiece(p3).getPieceColor();
                if (Utilities.isSameColor(p, c, brd) == false) {
                    possibleMoves.add(p3);

                }

            }
        }

        ChessPosition p4 = new ChessPosition(p.x+1,p.y-2);
        if(Utilities.isValidPosition(p4)) {
            if ( Utilities.isEmpty(p4, brd)) {
                possibleMoves.add(p4);
            } else {
                ChessColor c = brd.chessPiece(p4).getPieceColor();
                if (Utilities.isSameColor(p, c, brd) == false) {
                    possibleMoves.add(p4);

                }

            }
        }
    /*  ChessPosition p4;
        p4.x = p.x +1;
        p4.y = p.y -2;

        ChessPosition p5;
        p5.x = p.x -1;
        p5.y = p.y -2;

        ChessPosition p6;
        p6.x = p.x -2;
        p6.y = p.y -1;


        ChessPosition p7;
        p7.x = p.x -2;
        p7.y = p.y +1;

     */

        ChessPosition p8 = new ChessPosition(p.x-1,p.y+2);
        if(Utilities.isValidPosition(p8)) {
            if ( Utilities.isEmpty(p8, brd)) {
                possibleMoves.add(p8);
            } else {
                ChessColor c = brd.chessPiece(p8).getPieceColor();
                if (Utilities.isSameColor(p, c, brd) == false) {
                    possibleMoves.add(p8);

                }

            }
        }




        return possibleMoves;
    }
}
