package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;


/**
 *  This class controls introduce in our game the basics rules of chess. For instance, it deals with the way pieces can be moved. It implements
 * the IChess interface. This class is built on a singleton pattern.
 */
public class ChessModel implements IChess {

    static private ChessModel instance;
    private Board board1;

    /**
     * These lists store removed pieces.
     */
    public List<ChessType> removedWhitePiece = new ArrayList();
    public List<ChessType> removedBlackPieces = new ArrayList();


    /**
     * constructor method of our chessmodel.
     */
    private ChessModel(){
        reinit();
    }

    public static ChessModel getInstance(){
        if (instance == null){
            instance = new ChessModel();
        }
        return instance;
    }

    /**
     * we create the board
     * @retun void
     */

    @Override
    public void reinit() {
        this.board1 = new Board();
    }


    /**
     * Get public method to know the type of a piece
     * @param p x/y position on the board where we want to get the piece type.
     * @return ChessType
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */
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

    /**
     * Get public method to know the color of a piece
     * @param p x/y position on the board where we want to get the piece color.
     * @return ChessColor
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */
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

    /**
     * Get public method to know the number of remaining pieces on the board
     * @param color the requested color of the pieces to count.
     * @return int
     */
    @Override
    public int getNbRemainingPieces(ChessColor color) {
        return board1.pieceCounter(color);
    }

    /**
     * Get public method to know the move of a piece
     * @param p requested piece position.
     * @return list of chess position
     */
    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        List<ChessPosition> possibleMoves = new ArrayList();
        int i;
        Piece piece1 = board1.chessPiece(p);
        if (piece1 != null){
            possibleMoves = piece1.getMove(p,board1);
            //this method is not finished, due to a lack of time
            // List <ChessPosition> realMoves = new ArrayList<>();
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

    /**
     * This method takes the position of the piece located in P0 (recovered thanks to the setboardpos function of the board class)
     * and put it on P1. It cancels the presence of the initial piece on P1. No return. It also deals with the two types of castling and the history of piece position.
     * @param p0 source position on the board.
     * @param p1 destination position on the board.
     */
    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {


        Piece piece0 = board1.chessPiece(p0);
        Piece piece1 = board1.chessPiece(p1);
        List<ChessPosition> history = new ArrayList();
        board1.listPiecePositions(piece0 , p0 , history);

        // castling move
        ChessPosition pSCastling = new ChessPosition(p0.x+2 , p0.y);
        if (piece0.getPieceType() == ChessType.TYP_KING && p1.equals(pSCastling)){
            ChessPosition pRook = new ChessPosition(p0.x+3 , p0.y);
            ChessPosition pRook1 = new ChessPosition(p0.x+1 , p0.y);
            this.board1.setBoardPos(pRook1 , board1.chessPiece(pRook));
            this.board1.setBoardPos(pRook , null);
            board1.chessPiece(pRook1).increaseCounter();
            System.out.println("rook counter = " + board1.chessPiece(pRook1).getCounter());
        }
        ChessPosition pLCastling = new ChessPosition(p0.x-2 , p0.y);
        if (piece0.getPieceType() == ChessType.TYP_KING && p1.equals(pLCastling)){
            ChessPosition pRook = new ChessPosition(p0.x-4 , p0.y);
            ChessPosition pRook1 = new ChessPosition(p0.x-1 , p0.y);
            this.board1.setBoardPos(pRook1 , board1.chessPiece(pRook));
            this.board1.setBoardPos(pRook , null);
            board1.chessPiece(pRook1).increaseCounter();
            System.out.println("rook counter = " + board1.chessPiece(pRook1).getCounter());
        }

        // normal move
        this.board1.setBoardPos(p1 , piece0);
        this.board1.setBoardPos(p0 , null);


        /// transform a pawn in a queen
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
        board1.listPiecePositions(piece0 , p1 , history);

        // store removed pieces
        if (piece1 != null) {
            if (piece1.getPieceColor() == ChessColor.CLR_WHITE) {
                removedWhitePiece.add(piece1.getPieceType());
            } else {
                removedBlackPieces.add(piece1.getPieceType());
            }
        }
        System.out.println(piece0.getCounter());


    }

    /**
     * Get method that give the status (safe or threatened) of the king
     * @param color the requested king color.
     * @return ChessKingState kingState
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        ChessKingState kingState= ChessKingState.KING_SAFE;


       /* if(color == ChessColor.CLR_WHITE) {
            List<ChessPosition> tempList = board1.getEnemiesList(ChessColor.CLR_BLACK);
            System.out.println("tempList = " + tempList);
            int i;
            for (i=0 ; i < tempList.size() ; i++){
                ChessPosition p = tempList.get(i);
                getPieceMoves(p);
                List<ChessPosition> forbiddenPos = this.getPieceMoves(p);
                System.out.println("forbiddenPos = " + forbiddenPos);
                int j;
                for (j=0 ; j < forbiddenPos.size() ; j++){
                    ChessPosition checkPos = forbiddenPos.get(j);
                    System.out.println("pos " + checkPos);
                    Piece checkPiece = board1.chessPiece(checkPos);
                    List<Piece> checkList = new ArrayList();
                    checkList.add(checkPiece);
                    System.out.println("checking " + checkList);

                    System.out.println("piece " + checkPiece);
                    int k;
                    for (k=0 ; k < checkList.size() ; k++) {
                        if (checkPiece != null) {
                            ChessType checkType = checkPiece.getPieceType();
                            if (checkType == ChessType.TYP_KING) {
                                kingState = ChessKingState.KING_THREATEN;
                                System.out.println(kingState + " 1");
                            }
                        } else {
                            kingState = ChessKingState.KING_SAFE;
                            System.out.println(kingState + " 2");
                        }
                    }
                }
            }
        }
        else{
            List<ChessPosition> tempList = board1.getEnemiesList(ChessColor.CLR_WHITE);
            int i;
            for (i=0 ; i < tempList.size() ; i++){
                ChessPosition p = tempList.get(i);
                List<ChessPosition> forbiddenPos = this.getPieceMoves(p);
                int j;
                for (j=0 ; j < forbiddenPos.size() ; j++){
                    ChessPosition checkPos = forbiddenPos.get(j);
                    Piece checkPiece = board1.chessPiece(checkPos);
                    if (checkPiece != null && checkPiece.getPieceType() == ChessType.TYP_KING) {
                        kingState = ChessKingState.KING_THREATEN;
                    }
                    else {
                        kingState = ChessKingState.KING_SAFE;
                    }
                }
            }
        }
*/
        return kingState;
        //tory 7 :Il faut vérifier s’ile st dans la portée d’une des pièces.
        //1°Double boucle  pour trouver la position du roi=> king position.
        //2)Une fois trouvé la position du roi, nouvelle double boucle our trouver les positions des ennemis.
        //Si c’ets une couleur ennemis, on récupère la liste des positions possibles de la pièce (liste des positions d el’ennenemi)
        //3. Parcourir la liste de positions ennemis et dire si ça correspond à la position du roi
        //4. Tu renvoies safe ou menacé

    }

    /**
     * Get method that returns the a list of white or black removed pieces
     * @param color color of the removed pieces
     * @return list of removed pieces
     */
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




}
