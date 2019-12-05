package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;
import java.util.List;
public class KingMoves implements IMove {
    @Override
    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd) {
        List <IChess.ChessPosition> possibleMoves = new ArrayList<>();


        Moves.straightMoves(possibleMoves, brd, 1, 0, 1, p);
        Moves.straightMoves(possibleMoves, brd, 1, 1, 1, p);
        Moves.straightMoves(possibleMoves, brd, 0, 1, 1, p);
        Moves.straightMoves(possibleMoves, brd, -1, 1, 1, p);
        Moves.straightMoves(possibleMoves, brd, -1, 0, 1, p);
        Moves.straightMoves(possibleMoves, brd, -1, -1, 1, p);
        Moves.straightMoves(possibleMoves, brd, 0, -1, 1, p);
        Moves.straightMoves(possibleMoves, brd, 1, -1, 1, p);

        Piece piece = brd.chessPiece(p);
        IChess.ChessPosition pRookKS = new IChess.ChessPosition(p.x+3 , p.y);
        IChess.ChessPosition pA = new IChess.ChessPosition(p.x+1 , p.y);
        IChess.ChessPosition pB = new IChess.ChessPosition(p.x+2 , p.y);
        if (!piece.hasMoved() && !brd.chessPiece(pRookKS).hasMoved()
         && brd.chessPiece(pA) == null && brd.chessPiece(pB) == null){
            IChess.ChessPosition p1 = new IChess.ChessPosition(p.x+2 , p.y);
            possibleMoves.add(p1);
        }

        IChess.ChessPosition pRookQS = new IChess.ChessPosition(p.x-4 , p.y);
        IChess.ChessPosition pC = new IChess.ChessPosition(p.x-1 , p.y);
        IChess.ChessPosition pD = new IChess.ChessPosition(p.x-2 , p.y);
        IChess.ChessPosition pE = new IChess.ChessPosition(p.x-3 , p.y);
        if (!piece.hasMoved() && !brd.chessPiece(pRookQS).hasMoved()
         && brd.chessPiece(pC) == null && brd.chessPiece(pD) == null && brd.chessPiece(pE) == null){
            IChess.ChessPosition p1 = new IChess.ChessPosition(p.x-2 , p.y);
            possibleMoves.add(p1);
        }

        }















        /*int x1;
        int y1;
        int x0= p.x;
        int y0= p.y;
        for(x1=x0 -1;x1<=x0+1;x1= x1+1){
            for(y1=y0-1;y1<=y0+1;y1=y1+1){
                IChess.ChessPosition pp = new IChess.ChessPosition(x1,y1);

                if(Moves.isValidPosition(pp)) {
                    if ( Moves.isEmptyCell(pp, brd)) {
                        possibleMoves.add(pp);
                    } else {
                        IChess.ChessColor c = brd.chessPiece(pp).getPieceColor();
                        if (Moves.isSameColor(p, c, brd) == false) {
                            possibleMoves.add(pp);
                        }
                    }
                }
            }
        }*/
        return possibleMoves;
    }

}










