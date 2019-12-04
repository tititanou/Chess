package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IChess.*;

import java.util.ArrayList;
import java.util.List;

public class KnightMoves implements IMove {


    @Override
    public List<ChessPosition> getMoves(ChessPosition p, Board brd) {
        List<ChessPosition> possibleMoves = new ArrayList<>();
        int dx;
        int dy;
        int x1;
        int y1;
        int x0 = p.x;
        int y0 = p.y;
        for (dx = -2; dx <= 2; dx = dx + 1) {
            for (dy = -2; dy <= 2; dy = dy + 1) {
                if (Math.abs(dx) + Math.abs(dy) == 3) {
                    // Moves.straightMoves(possibleMoves, brd, dx, dy, 1, p);
                    x1 = x0 + dx;
                    y1 = y0 + dy;
                    IChess.ChessPosition pp = new IChess.ChessPosition(x1, y1);
                    if (Moves.isValidPosition(pp)) {
                        if (Moves.isEmptyCell(pp, brd)) {
                            possibleMoves.add(pp);
                        } else {
                            IChess.ChessColor c = brd.chessPiece(pp).getPieceColor();
                            if (Moves.isSameColor(p, c, brd) == false) {
                                possibleMoves.add(pp)
                                ;
                            }
                        }
                    }
                }
            }
        }
        return possibleMoves;
    }

}
