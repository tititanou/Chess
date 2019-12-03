package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.List;

public interface IMove {

    public List<IChess.ChessPosition> getMoves (IChess.ChessPosition p,Board brd);



}
