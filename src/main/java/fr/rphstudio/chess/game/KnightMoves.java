package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.*;

import java.util.ArrayList;
import java.util.List;


public class KnightMoves implements IMove {

    /**
     * this method is used to record the possibles Knight’s displacements and return a list, we used a different method but both works
     * @param p
     * @param brd
     * @return
     */
    @Override
    public List<ChessPosition> getMoves(ChessPosition p, Board brd) {
        List<ChessPosition> possibleMoves = new ArrayList<>();

        /*Moves.straightMoves(possibleMoves, brd,2, 1, 1, p);
        Moves.straightMoves(possibleMoves, brd, 2, -1, 1, p);
        Moves.straightMoves(possibleMoves, brd, -2, -1, 1, p);
        Moves.straightMoves(possibleMoves, brd, -2, 1, 1, p);
        Moves.straightMoves(possibleMoves, brd, 1, 2, 1, p);
        Moves.straightMoves(possibleMoves, brd, 1, -2, 1, p);
        Moves.straightMoves(possibleMoves, brd, -1, -2, 1, p);
        Moves.straightMoves(possibleMoves, brd, -1, 2, 1, p);

         */


        int dx;
        int dy;
        int x1;
        int y1;
        int x0 = p.x;
        int y0 = p.y;
        for (dx = -2; dx <= 2; dx = dx + 1) {
            for (dy = -2; dy <= 2; dy = dy + 1) {
                if (Math.abs(dx) + Math.abs(dy) == 3) {
                    Moves.straightMoves(possibleMoves, brd, dx, dy, 1, p);

                }
            }
        }
        return possibleMoves;
    }

}
