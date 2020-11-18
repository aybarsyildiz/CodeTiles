package com.tile.engine.board;

public class Move 
{
   private static int hamle=3;
   private static int sonHamleSayısı=0;

 /*   Move(){
    this.altınX=altınX;
    this.altınY=altınY;
    this.playerX=playerX;
    this.playerY=playerY;
    }
  */  
 public static int[] yeniKordinat(int[] oyuncu ,int[] altın)
 { 
   int oX=oyuncu[0],oY=oyuncu[1],aX=altın[0],aY=altın[1];//bura array alıcak şimdilik böyle
  
   int[] oyuncuKordinatı = {oX,oY};
    if((Math.abs(aX-oX)+Math.abs(aY-oY))<=hamle)
    {   
        oyuncuKordinatı[0]=aX;
        oyuncuKordinatı[1]=aY;    
        sonHamleSayısı=(Math.abs(aX-oX)+Math.abs(aY-oY));
    }    
    else if((Math.abs(aX-oX)+Math.abs(aY-oY))>hamle)
    {
        if((Math.abs(aX-oX))>=hamle)
        {
            if((aX-oX)>0)
            {
                oX=oX+3;
            }
            else if((aX-oX)<0)
            {
                oX=oX-3;
            } 
            oyuncuKordinatı[0]=oX;
            oyuncuKordinatı[1]=oY;
            sonHamleSayısı=hamle;
        }
       
        else if(0<Math.abs(aX-oX) && Math.abs(aX-oX)<hamle)
        {    
            if((aY-oY)>0)
            {
                oY=oY+(3-Math.abs(aX-oX));
            }
            else if((aY-oY)<0)
            {
                oY=oY-(3-Math.abs(aX-oX));
            } 
            oX=aX;
            oyuncuKordinatı[0]=oX;
            oyuncuKordinatı[1]=oY;
            sonHamleSayısı=hamle;
        }
       
        else if((Math.abs(aY-oY))>hamle)
        {
            if((aY-oY)>0)
            {
                oY=oY+3;
            }
            else if((aY-oY)<0)
            {
                oY=oY-3;
            } 
            oyuncuKordinatı[0]=oX;
            oyuncuKordinatı[1]=oY;
            sonHamleSayısı=hamle;
        }
    }
   
   
    return oyuncuKordinatı; 
 }

  public static int sonHamle(){
      return sonHamleSayısı;
  }










}
