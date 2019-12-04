package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class QueenMoves implements IMove {
    @Override
    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd) {


        List<IChess.ChessPosition> possibleMoves = new ArrayList<>();
        Moves.straightMoves(possibleMoves , brd ,  -1 ,  0 , 7 , p);
        Moves.straightMoves(possibleMoves , brd , 0 , -1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd , 1 ,  0 , 7 , p);
        Moves.straightMoves(possibleMoves , brd ,  0 , 1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd ,  1 ,  1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd , -1 , -1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd , -1 ,  1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd ,  1 , -1 , 7 , p);
        return possibleMoves;






    }
}
