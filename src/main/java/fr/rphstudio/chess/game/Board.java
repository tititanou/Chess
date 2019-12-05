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
        return this.chessBoard[p.y][p.x];
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
        /*public ChessPosition getKingPosition (){
            int row;
            int col;
            ChessPosition positionKing;
            for (row = 0; row < 8; row = row + 1) {
                for (col = 0; col < 8; col = col + 1) {
                    Piece pieces = chessBoard[row][col];
                    if (pieces != null) {
                        if (pieces.getPieceType() == ChessType.TYP_KING) {
                            positionKing = new ChessPosition(row, col);

                        }
                    }
                    else{
                        positionKing = null;
                    }
                }
            }
            return positionKing;
        }

         */

    public List<ChessPosition> getEnemiesList(ChessColor color) {


        int row;
        int col;
        List<ChessPosition> enemiesList = new ArrayList();

        for (row = 0; row < 8; row = row + 1) {
            for (col = 0; col < 8; col = col + 1) {
                Piece pieces = chessBoard[row][col];
                if (pieces != null) {
                    ChessPosition p1 = new ChessPosition(row, col);
                    if (pieces.getPieceColor() != color) {
                        enemiesList.add(p1);
                    }
                }
            }
        }
        return enemiesList;

    }

    public List<ChessPosition> listPiecePositions(Piece pieces, ChessPosition p, List<ChessPosition> l) {
        int row;
        int col;

        for (row = 0; row < 8; row = row + 1) {
            for (col = 0; col < 8; col = col + 1) {
                pieces = chessBoard[row][col];
                if (pieces != null) {
                    p = new ChessPosition(row, col);
                    l.add(p);
                }
            }
        }
        return l;
    }


}