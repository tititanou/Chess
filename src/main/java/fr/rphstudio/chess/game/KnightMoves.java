package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves implements IMove {




    @Override
    public List<ChessPosition> getMoves(ChessPosition p, Board brd) {


        List<ChessPosition> possibleMoves = new ArrayList<>();

        ChessPosition p1 = new ChessPosition(p.x + 1, p.y + 2);
        if (Moves.isValidPosition(p1)) {
            if (Moves.isEmptyCell(p1 , brd)) {
                possibleMoves.add(p1);
            } else {
                ChessColor c = brd.chessPiece(p1).getPieceColor();
                if (!Moves.isSameColor(p1, c , brd)) {
                    possibleMoves.add(p1);
                }
            }
        }


        ChessPosition p2 = new ChessPosition(p.x + 2, p.y + 1);
        if (Moves.isValidPosition(p2) == true) {
            if (Moves.isEmptyCell(p2 , brd)) {
                possibleMoves.add(p2);
            } else {
                ChessColor c = brd.chessPiece(p2).getPieceColor();
                if (Moves.isSameColor(p2, c , brd) == false) {
                    possibleMoves.add(p2);
                }
            }
        }


        ChessPosition p3 = new ChessPosition(p.x + 2, p.y - 1);
        if (Moves.isValidPosition(p3)) {
            if (Moves.isEmptyCell(p3,brd)) {
                possibleMoves.add(p3);
            } else {
                ChessColor c = brd.chessPiece(p3).getPieceColor();
                if (Moves.isSameColor(p3, c , brd) == false) {
                    possibleMoves.add(p3);
                }
            }
        }


        ChessPosition p4 = new ChessPosition(p.x + 1, p.y - 2);
        if (Moves.isValidPosition(p4)) {
            if (Moves.isEmptyCell(p4 , brd)) {
                possibleMoves.add(p4);
            } else {
                ChessColor c = brd.chessPiece(p4).getPieceColor();
                if (Moves.isSameColor(p4, c , brd) == false) {
                    possibleMoves.add(p4);
                }
            }
        }

        ChessPosition p5 = new ChessPosition(p.x - 1, p.y - 2);
        if (Moves.isValidPosition(p5)) {
            if (Moves.isEmptyCell(p5 , brd)) {
                possibleMoves.add(p5);
            } else {
                ChessColor c = brd.chessPiece(p5).getPieceColor();
                if (Moves.isSameColor(p5 , c , brd) == false) {
                    possibleMoves.add(p5);
                }
            }
        }

        ChessPosition p6 = new ChessPosition(p.x - 2, p.y - 1);
        if (Moves.isValidPosition(p6)) {
            if (Moves.isEmptyCell(p6 , brd)) {
                possibleMoves.add(p6);
            } else {
                ChessColor c = brd.chessPiece(p6).getPieceColor();
                if (Moves.isSameColor(p6 , c , brd) == false) {
                    possibleMoves.add(p6);
                }
            }
        }



        ChessPosition p7 = new ChessPosition(p.x-2 , p.y+1);
        if (Moves.isValidPosition(p7)){
            if (Moves.isEmptyCell(p7 , brd)){
                possibleMoves.add(p7);
            }
            else {
                ChessColor c = brd.chessPiece(p7).getPieceColor();
                if (Moves.isSameColor(p7 , c , brd) == false) {
                    possibleMoves.add(p7);
                }
            }
        }


        ChessPosition p8= new ChessPosition(p.x-1 , p.y+2);
        p8.x = p.x -1;
        p8.y = p.y +2;
        if (Moves.isValidPosition(p8)){
            if (Moves.isEmptyCell(p8 , brd)){
                possibleMoves.add(p8);
            }
            else {
                ChessColor c = brd.chessPiece(p8).getPieceColor();
                if (Moves.isSameColor(p8, c , brd) == false) {
                    possibleMoves.add(p8);
                }
            }
        }




        return possibleMoves;
    }
}
