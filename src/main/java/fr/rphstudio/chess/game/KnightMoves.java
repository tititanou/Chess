package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.*;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves implements IMove {




    @Override
    public List<ChessPosition> getMoves(ChessPosition p, Board brd) {


        List <ChessPosition> possibleMoves = new ArrayList<>();

        ChessPosition p1 = new ChessPosition(p.x+1,p.y+2);
        //if (p1){
            possibleMoves.add(p1);
        //}

/*
        ChessPosition p2;
        p2.x = p.x +2;
        p2.y = p.y +1;


        ChessPosition p3;
        p3.x = p.x +2;
        p3.y = p.y -1;

        ChessPosition p4;
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


        ChessPosition p8;
        p8.x = p.x -1;
        p8.y = p.y +2;

 */



        return possibleMoves;
    }
}
