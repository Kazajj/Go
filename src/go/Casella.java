package go;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casella extends JButton{
    ImageIcon img;
    ImageIcon nero = new ImageIcon("C:\\Users\\Enzo\\Desktop\\dESK\\BoardSprites\\GoNero.png");
    ImageIcon bianco = new ImageIcon("C:\\Users\\Enzo\\Desktop\\dESK\\BoardSprites\\GoBianco.png");
    //int gioc;
    int value=0;
    boolean contorno=false;
    boolean ctr=false;
    Casella up=null;
    Casella down=null;
    Casella right=null;
    Casella left=null;
    Casella prec=null;
    Casella succ=null;
    boolean visitato=false;

    int x,y;
}
