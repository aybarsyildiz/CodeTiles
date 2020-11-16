package com.tile.engine.players;
import com.tile.engine.board.Board;
import com.tile.engine.board.Move;
import java.util.List;


public class Player {

    
    public int[] playerPosition = new int[2];
    public int altinSayisi;

    public Player( int[] playerPosition,int altinSayisi){

            this.playerPosition = playerPosition;
            this.altinSayisi = altinSayisi;
            

    }
    public int[] suAnkiKoordinat(){

        return this.playerPosition;
    }

    public int[] koordinatlariGuncelle (int[] yeniKoordinat){
        this.playerPosition = yeniKoordinat;
        return playerPosition;
    }

    
    //public abstract List<Move> calculateLegalMoves(final Board board);//pyuncunun yapabileceği hamlelerin listesi
}
