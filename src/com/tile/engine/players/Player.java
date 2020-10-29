package com.tile.engine.players;
import com.tile.engine.board.Board;
import com.tile.engine.board.Move;
import java.util.List;
import com.tile.engine.PlayerClass;

public abstract class Player {

    
    protected final int playerPosition;
    protected final PlayerClass playerClass;

    Player(final int playerPosition, final PlayerClass playerClass){

            this.playerPosition = playerPosition;
            this.playerClass = playerClass;

    }

    
    public abstract List<Move> calculateLegalMoves(final Board board);//pyuncunun yapabileceği hamlelerin listesi
}
