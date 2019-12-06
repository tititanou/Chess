package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {

    static private ChessModel instance;
    private Board board1;
    public List<ChessType> removedWhitePiece = new ArrayList();
    public List<ChessType> removedBlackPieces = new ArrayList();

    private ChessModel(){
        reinit();
    }

    public static ChessModel getInstance(){
        if (instance == null){
            instance = new ChessModel();
        }
        return instance;
    }

    @Override
    public void reinit() {
        this.board1 = new Board();
       /* int raw;
        int col;
        for(raw = 0 ; raw < 8 ; raw = raw + 1){
            for(col = 0 ; col < 8 ; col = col + 1){
                ChessPosition p = new ChessPosition(col , raw);
                Piece pc = board1.chessPiece(p);
                if(pc != null){
                    List<ChessPosition> l = board1.listPiecePositions(p , pc);
                    pc.setHistory(l);
                }
            }
        }*/
    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            Piece piece1 = board1.chessPiece(p);
            if (piece1 != null) {
                ChessType type1 = piece1.getPieceType();
                return type1;
            }
            else {
                throw new EmptyCellException();
            }
        }
        else{
            throw new OutOfBoardException();
        }
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7) {
            Piece piece1 = board1.chessPiece(p);
            if (piece1 != null) {
                ChessColor color1 = piece1.getPieceColor();
                return color1;
            } else {
                throw new EmptyCellException();
            }
        }
        else{
            throw new OutOfBoardException();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return board1.pieceCounter(color);
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        List<ChessPosition> possibleMoves = new ArrayList();
        int i;
        Piece piece1 = board1.chessPiece(p);
        if (piece1 != null){
            possibleMoves = piece1.getMove(p,board1);
            //List <ChessPosition> realMoves = new ArrayList<>();
            //TODO story 8 ici à finir
           // for (i=0; i<=possibleMoves.size(); i=i+1) {
            //}
            //liste des coups réellement possibles realMoves
            //boucle sur posibleMoves
                //pour chaque p1 on va déplacer la piece(avec movePiece) puis on teste si roi allié est safe
                // si roi safe alors p1 est réellement possible donc add ds realMoves
            //possibleMoves = realMoves
        }
        return possibleMoves;
    }
// movePiece prend la position de la piece située en P0 (recupérée grâce à la fonction setboardpos de la classe board)
// en ligne 84, il met l apiéce PO en position p1
// en ligne 85, en position P0, il annule la présence d'une piéce.
//TODO traduire le commentaire en anglais

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        Piece piece0 = board1.chessPiece(p0);
        Piece piece1 = board1.chessPiece(p1);
        ChessPosition pSCastling = new ChessPosition(p0.x+2 , p0.y);
        if (piece0.getPieceType() == ChessType.TYP_KING && p1.equals(pSCastling)){
            ChessPosition pRook = new ChessPosition(p0.x+3 , p0.y);
            ChessPosition pRook1 = new ChessPosition(p0.x+1 , p0.y);
            this.board1.setBoardPos(pRook1 , board1.chessPiece(pRook));
            this.board1.setBoardPos(pRook , null);
            board1.chessPiece(pRook1).increaseCounter();
        }
        ChessPosition pLCastling = new ChessPosition(p0.x-2 , p0.y);
        if (piece0.getPieceType() == ChessType.TYP_KING && p1.equals(pLCastling)){
            ChessPosition pRook = new ChessPosition(p0.x-4 , p0.y);
            ChessPosition pRook1 = new ChessPosition(p0.x-1 , p0.y);
            this.board1.setBoardPos(pRook1 , board1.chessPiece(pRook));
            this.board1.setBoardPos(pRook , null);
            board1.chessPiece(pRook1).increaseCounter();
            }
        this.board1.setBoardPos(p1 , piece0);
        this.board1.setBoardPos(p0 , null);

        if (board1.chessPiece(p1).getPieceType() == ChessType.TYP_PAWN
         && board1.chessPiece(p1).getPieceColor() == ChessColor.CLR_WHITE
         && p1.y == BOARD_POS_Y_BLACK_PIECES){
            piece0.setPieceType(ChessType.TYP_QUEEN);
            piece0.setMove(new QueenMoves());
        }

        if (board1.chessPiece(p1).getPieceType() == ChessType.TYP_PAWN
                && board1.chessPiece(p1).getPieceColor() == ChessColor.CLR_BLACK
                && p1.y == BOARD_POS_Y_WHITE_PIECES){
            piece0.setPieceType(ChessType.TYP_QUEEN);
            piece0.setMove(new QueenMoves());
        }
        piece0.increaseCounter();
        if (piece1 != null) {
            if (piece1.getPieceColor() == ChessColor.CLR_WHITE) {
                removedWhitePiece.add(piece1.getPieceType());
            } else {
                removedBlackPieces.add(piece1.getPieceType());
            }
        }
    }

    @Override
    public ChessKingState getKingState(ChessColor color) {
        ChessKingState kingState = ChessKingState.KING_SAFE;
        ChessPosition pKing = board1.whereIsKing(color);
        List<ChessPosition> enemiesPos = board1.getEnemiesList(color);
        if(pKing != null) {
            int i;
            for (i = 0; i < enemiesPos.size(); i = i + 1) {
                ChessPosition p = enemiesPos.get(i);
                List<ChessPosition> possibleMoves = instance.getPieceMoves(p);
                int j;
                for (j = 0; j < possibleMoves.size(); j = j + 1) {
                    ChessPosition possiblePos = possibleMoves.get(j);
                    if (possiblePos.equals(pKing)) {
                        kingState = ChessKingState.KING_THREATEN;
                    }
                }
            }
        }
        else{
            kingState =ChessKingState.KING_THREATEN;
        }
        return kingState;
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        List<ChessType> removedPiece = new ArrayList();

        if (color== ChessColor.CLR_WHITE) {
            removedPiece = removedWhitePiece;
        }
        if (color==ChessColor.CLR_BLACK) {
            removedPiece = removedBlackPieces;
        }
        return removedPiece;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }


//TODO note pour plus tard : tester de nouveau la transformation d'un pion noir en reine, qui a provoqué un bug sur le pc de boris, pas sur celui de bryan






}
