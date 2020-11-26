package com.tile.engine.board;

public class Move 
{ 
 private static int sonHamleSayısı=0;

 public static int[] yeniKordinat(int[] oyuncu ,int[] altın,int move)
 { 
   int oX=oyuncu[0],oY=oyuncu[1],aX=altın[0],aY=altın[1];
  
   int[] oyuncuKordinatı = {oX,oY};
    if((Math.abs(aX-oX)+Math.abs(aY-oY))<=move)
    {   
        oyuncuKordinatı[0]=aX;
        oyuncuKordinatı[1]=aY;    
        sonHamleSayısı=(Math.abs(aX-oX)+Math.abs(aY-oY));
    }    
    else if((Math.abs(aX-oX)+Math.abs(aY-oY))>move)
    {
        if((Math.abs(aX-oX))>=move)
        {
            if((aX-oX)>0)
            {
                oX=oX+move;
            }
            else if((aX-oX)<0)
            {
                oX=oX-move;
            } 
            oyuncuKordinatı[0]=oX;
            oyuncuKordinatı[1]=oY;
            sonHamleSayısı=move;
        }
       
        else if(0<Math.abs(aX-oX) && Math.abs(aX-oX)<move)
        {    
            if((aY-oY)>0)
            {
                oY=oY+(move-Math.abs(aX-oX));
            }
            else if((aY-oY)<0)
            {
                oY=oY-(move-Math.abs(aX-oX));
            } 
            oX=aX;
            oyuncuKordinatı[0]=oX;
            oyuncuKordinatı[1]=oY;
            sonHamleSayısı=move;
        }
       
        else if((Math.abs(aY-oY))>move)
        {
            if((aY-oY)>0)
            {
                oY=oY+move;
            }
            else if((aY-oY)<0)
            {
                oY=oY-move;
            } 
            oyuncuKordinatı[0]=oX;
            oyuncuKordinatı[1]=oY;
            sonHamleSayısı=move;
        }
    }
   
   
    return oyuncuKordinatı; 
 }

  public static int sonHamle(){
      return sonHamleSayısı;
  }










}
