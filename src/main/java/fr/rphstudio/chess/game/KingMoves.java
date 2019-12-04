package fr.rphstudio.chess.game;
import fr.rphstudio.chess.interf.IChess;
import java.util.ArrayList;
import java.util.List;
public class KingMoves implements IMove {
    @Override
    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd) {
        List <IChess.ChessPosition> possibleMoves = new ArrayList<>();
        int x1;
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
        }
        return possibleMoves;
    }
}










