package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

import static fr.rphstudio.chess.interf.IChess.*;

public class Board {

    private Piece[][] chessBoard = new Piece[8][8];

    public Board() {

        int row;
        int col;

        for (row = 0; row < 8; row = row + 1) {
            for (col = 0; col < 8; col = col + 1) {

                chessBoard[row][col] = null;

                if (row == BOARD_POS_Y_WHITE_PAWNS) {
                    chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_PAWN, new PawnMoves());
                }

                if (row == BOARD_POS_Y_BLACK_PAWNS) {
                    chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_PAWN, new PawnMoves());
                }

                if (row == BOARD_POS_Y_WHITE_PIECES) {

                    if (col == BOARD_POS_X_QUEENSIDE_ROOK) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_ROOK, new RookMoves());
                    } else if (col == BOARD_POS_X_QUEENSIDE_KNIGHT) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_KNIGHT, new KnightMoves());
                    }
                    if (col == BOARD_POS_X_QUEENSIDE_BISHOP) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_BISHOP, new BishopMoves());
                    }
                    if (col == BOARD_POS_X_QUEEN) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_QUEEN, new QueenMoves());
                    }
                    if (col == BOARD_POS_X_KING) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_KING, new KingMoves());
                    }
                    if (col == BOARD_POS_X_KINGSIDE_BISHOP) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_BISHOP, new BishopMoves());
                    }
                    if (col == BOARD_POS_X_KINGSIDE_KNIGHT) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_KNIGHT, new KnightMoves());
                    }
                    if (col == BOARD_POS_X_KINGSIDE_ROOK) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_WHITE, ChessType.TYP_ROOK, new RookMoves());
                    }
                }

                if (row == BOARD_POS_Y_BLACK_PIECES) {
                    if (col == BOARD_POS_X_QUEENSIDE_ROOK) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_ROOK, new RookMoves());
                    } else if (col == BOARD_POS_X_QUEENSIDE_KNIGHT) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_KNIGHT, new KnightMoves());
                    }
                    if (col == BOARD_POS_X_QUEENSIDE_BISHOP) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_BISHOP, new BishopMoves());
                    }
                    if (col == BOARD_POS_X_QUEEN) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_QUEEN, new QueenMoves());
                    }
                    if (col == BOARD_POS_X_KING) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_KING, new KingMoves());
                    }
                    if (col == BOARD_POS_X_KINGSIDE_BISHOP) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_BISHOP, new BishopMoves());
                    }
                    if (col == BOARD_POS_X_KINGSIDE_KNIGHT) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_KNIGHT, new KnightMoves());
                    }
                    if (col == BOARD_POS_X_KINGSIDE_ROOK) {
                        chessBoard[row][col] = new Piece(ChessColor.CLR_BLACK, ChessType.TYP_ROOK, new RookMoves());
                    }
                }
            }
        }

    }

    public Piece chessPiece(ChessPosition p) {
        if(Moves.isValidPosition(p)) {
            return this.chessBoard[p.y][p.x];
        }
        else {
            return null;
        }
    }

    public Piece setBoardPos(ChessPosition p, Piece pc) {
        return this.chessBoard[p.y][p.x] = pc;
    }


    public int pieceCounter(ChessColor color) {


        int row;
        int col;
        int count = 0;

        for (row = 0; row < 8; row = row + 1) {
            for (col = 0; col < 8; col = col + 1) {
                Piece pieces = chessBoard[row][col];
                if (pieces != null) {
                    if (pieces.getPieceColor() == color) {
                        count = count + 1;
                    }
                }

            }
        }
        return count;

    }

    // cette méthode renvoie la position du roi. elle est utilisée notamment pour identifier si le roi est en échec ou safe.


   /* public List<ChessPosition> listPiecePositions(ChessPosition p , Piece pc) {
        List<ChessPosition> list = null;
        if(pc.equals(this.chessPiece(p))){
            list.add(p);
        }
        return list;
    }*/

    public ChessPosition whereIsKing(ChessColor color) {
        int row;
        int col;
        ChessPosition pKing = null;
        for (row = 0; row < 8; row = row + 1) {
            for (col = 0; col < 8; col = col + 1) {
                Piece pieces = chessBoard[row][col];
                if (pieces != null) {
                    if (pieces.getPieceColor() == color && pieces.getPieceType() == ChessType.TYP_KING) {
                        pKing = new ChessPosition(col , row);
                    }
                }
            }
        }
        return pKing;
    }

    public List<ChessPosition> getEnemiesList(ChessColor color) {
        int row;
        int col;
        List<ChessPosition> enemiesList = new ArrayList();

        for (row = 0; row < 8; row = row + 1) {
            for (col = 0; col < 8; col = col + 1) {
                Piece pieces = chessBoard[row][col];
                if (pieces != null && pieces.getPieceColor() != color) {
                        ChessPosition p1 = new ChessPosition(col , row);
                        enemiesList.add(p1);
                }
            }
        }
        return enemiesList;
    }

    /*public ChessPosition getPosition(List<ChessPosition> l){
        int i;
        ChessPosition p = null;
        for(i = 0 ; i < l.size() ; i = i + 1){
            p = l.get(i);
        }
        return p;
    }*/

}