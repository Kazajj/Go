package go;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CListener implements MouseListener{

    private int turno=Main.turno;
    private int val,sval;
    //private boolean cancellato=false;
    //private Casella radice=null;

    @Override
    public void mouseClicked(MouseEvent e) {
        Casella c = (Casella)e.getSource();
        if(c.value!=0)
            return;

        if(turno==1)
        {
            c.setIcon(c.nero);
            c.value=1;
            sval=1;
            val=2;
            Main.p.repaint();
        }

        else
        {
            c.setIcon(c.bianco);
            c.value=2;
            sval=2;
            val=1;
            Main.p.repaint();
        }

        controllo();
		/*
		if(cancellato==true)
		{
			cancellato=false;
			return;
		}
		*/

        //System.out.println("Value of right: " + c.right.value);

        if(turno==1)
            turno=2;
        else
            turno=1;

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }


    public void controllo(){
        for (int ii = 0; ii < 19; ii++) {
            for (int i = 0; i < 19; i++) {
                eliminazione();
                if(Main.c[i][ii].value==val)
                {
                    Casella radice=Main.c[i][ii];
                    ricerca(radice);
                }
                resetctr();
            }
        }
    }

    public void ricerca(Casella radice){
        if(radice==null  || radice.value==sval || radice.visitato==true)
        {
            return;
        }

        if(radice.value==0)
        {
            setctr();
            return;
        }

        radice.visitato=true;

        //System.out.println(radice.x + ", " + radice.y);

        ricerca(radice.up);
        if(radice.up!=null && radice.up.ctr==true)
        {
            radice.ctr=true;
            return;
        }

        ricerca(radice.right);
        if(radice.right!=null && radice.right.ctr==true)
        {
            radice.ctr=true;
            return;
        }

        ricerca(radice.down);
        if(radice.down!=null && radice.down.ctr==true)
        {
            radice.ctr=true;
            return;
        }

        ricerca(radice.left);
        if(radice.left!=null && radice.left.ctr==true)
        {
            radice.ctr=true;
            return;
        }


        radice.contorno=true;

    }

    public void resetctr(){
        for (int ii = 0; ii < 19; ii++) {
            for (int i = 0; i < 19; i++) {
                Main.c[i][ii].ctr=false;
                Main.c[i][ii].visitato=false;
            }
        }
    }

    public void setctr(){
        for (int ii = 0; ii < 19; ii++) {
            for (int i = 0; i < 19; i++) {
                Main.c[i][ii].ctr=true;
                Main.c[i][ii].contorno=false;
            }
        }
    }

    public void eliminazione(){
        for (int ii = 0; ii < 19; ii++) {
            for (int i = 0; i < 19; i++) {
                if(Main.c[i][ii].contorno==true)
                {
                    Main.c[i][ii].value=0;
                    Main.c[i][ii].setIcon(Main.c[i][ii].img);
                    Main.c[i][ii].contorno=false;
                    Main.p.repaint();
                    //cancellato=true;
                }
            }
        }
    }

}
