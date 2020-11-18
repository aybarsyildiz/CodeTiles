import javax.swing.JButton;

public class Btn extends JButton {
   
    private int altın=0;
    private static int i,j;
    Btn(int i, int j) {
        super();
        this.i=i;
        this.j=j;
        
    }
    public void altınEkle(int altın){
        this.altın=altın;
    }
    public int kordinatAltını(){
        return this.altın;
    }
}
