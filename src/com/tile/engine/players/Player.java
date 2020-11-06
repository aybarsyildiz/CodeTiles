package com.tile.engine.players;
import com.tile.engine.board.Board;
import com.tile.engine.board.Move;
import java.util.List;


public abstract class Player {

    
    int playerPosition;
    

    Player( int playerPosition){

            this.playerPosition = playerPosition;
            

    }

    
    public abstract List<Move> calculateLegalMoves(final Board board);//pyuncunun yapabileceği hamlelerin listesi
}
