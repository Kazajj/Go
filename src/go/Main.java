package go;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main {

    public static JPanel p = new JPanel();
    public static Casella[][] c = new Casella[19][19];
    public static int turno=1;
    static ImageIcon board = new ImageIcon("src\\go\\img\\GoBoard2.png");
    static ImageIcon upleft = new ImageIcon("src\\go\\img\\GoBoardUpLeft.png");
    static ImageIcon upright = new ImageIcon("src\\go\\img\\GoBoardUpRight.png");
    static ImageIcon downleft = new ImageIcon("src\\go\\img\\GoBoardDownLeft.png");
    static ImageIcon downright = new ImageIcon("src\\go\\img\\GoBoardDownRight.png");
    static ImageIcon up = new ImageIcon("src\\go\\img\\GoBoardUp.png");
    static ImageIcon right = new ImageIcon("src\\go\\img\\GoBoardRight.png");
    static ImageIcon down = new ImageIcon("src\\go\\img\\GoBoardDown.png");
    static ImageIcon left = new ImageIcon("src\\go\\img\\GoBoardLeft.png");

    public static void main(String[] args) {
        Border empty = BorderFactory.createEmptyBorder();

        JFrame f = new JFrame();
        f.setSize(1020,1040);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        p = new JPanel();
        p.setSize(950,950);
        p.setLocation(25,25);
        p.setLayout(null);
        p.setBackground(Color.CYAN);
        f.add(p);

        CListener clis = new CListener();

        for(int i=0; i<19; i++)
        {
            for(int ii=0; ii<19; ii++)
            {
                c[i][ii] = new Casella();
                c[i][ii].setSize(50,50);
                c[i][ii].setLocation(ii*50, i*50);
                c[i][ii].setVisible(true);
                c[i][ii].addMouseListener(clis);

                if(i==0 && ii==0)
                    c[i][ii].setIcon(upleft);
                else
                if(i==0 && ii==18)
                    c[i][ii].setIcon(upright);
                else
                if(i==18 && ii==0)
                    c[i][ii].setIcon(downleft);
                else
                if(i==18 && ii==18)
                    c[i][ii].setIcon(downright);
                else
                if(i==0 && ii!=0)
                    c[i][ii].setIcon(up);
                else
                if(i!=18 && ii==18)
                    c[i][ii].setIcon(right);
                else
                if(i!=0 && ii==0)
                    c[i][ii].setIcon(left);
                else
                if(i==18 && ii!=18)
                    c[i][ii].setIcon(down);
                else
                    c[i][ii].setIcon(board);

                c[i][ii].img=(ImageIcon) c[i][ii].getIcon();
                c[i][ii].setBorder(empty);
                c[i][ii].x=i;
                c[i][ii].y=ii;
                p.add(c[i][ii]);

                p.repaint();
            }
        }

        for(int i=0; i<19; i++)
        {
            for(int ii=0; ii<19; ii++)
            {
                if (i != 0)
                    c[i][ii].up=c[(i - 1)][ii];

                if (ii != 0)
                    c[i][ii].left=c[i][(ii - 1)];

                if (ii != 18)
                    c[i][ii].right=c[i][(ii + 1)];

                if (i != 18)
                    c[i][ii].down=c[(i + 1)][ii];
            }
        }

    }
}
