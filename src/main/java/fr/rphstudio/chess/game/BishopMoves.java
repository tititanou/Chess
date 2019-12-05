package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

public class BishopMoves implements IMove {


    /**
     *
     *  this method is used to record the possibles bishop’s displacements and return a list
     *
     * @param p
     * @param brd
     * @return list of possible moves
     */
    @Override
    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd) {

        List<IChess.ChessPosition> possibleMoves = new ArrayList<>();

        Moves.straightMoves(possibleMoves , brd ,  1 ,  1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd , -1 , -1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd , -1 ,  1 , 7 , p);
        Moves.straightMoves(possibleMoves , brd ,  1 , -1 , 7 , p);


        return possibleMoves;
    }
}
