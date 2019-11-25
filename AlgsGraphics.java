/* *****************************************************************************
 *  Name: Eli JI
 *  Date: 10-28-19
 *  Description: Graphics class for animating sorting algorithms. Onl works for
 *  Insertion and Selection
 **************************************************************************** */

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgsGraphics{

    private static int appWidth = 600;
    private static int appHeight = 600;

    public static void main(String[] args) {
        int[] list = {15,2,8,5,9,23,54,1,4,4,22,60,1,43,3,2};
        JFrame f = new JFrame("Algorithm Graphics");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel(appWidth, appHeight,list));
        f.setSize(appWidth,appHeight);
        f.setVisible(true);
    }
}

    class MyPanel extends JPanel implements ActionListener {

        //CHANGE SORT ALGORITHM HERE (1-insertion, 2-selection)
        private int sort = 1;

        private static int appWidth;
        private static int appHeight;
        private int[] list;
        private Timer animator;
        //current i index of algorithm/animator
        private int currI = 0;

        public MyPanel(int appWidth, int appHeight, int [] list) {
            setBorder(BorderFactory.createLineBorder(Color.black));
            setBackground(Color.WHITE);
            this.appWidth = appWidth;
            this.appHeight = appHeight;
            this.list = list;
            animator = new Timer(1000, this);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawList(g);
            animator.start();
        }

        public void actionPerformed(ActionEvent e) {
            if(sort == 1) doOneInsertion(currI);
            else if(sort == 2)doOneSelection(currI);
            repaint();
        }

        //draws the instance of the list used in runSort
        private void drawList(Graphics g) {
            g.setColor(Color.BLACK);
            int XOffset = (int)(0.1 * appWidth);
            int YOffset = (int)(0.2 * appHeight);
            int rectWidth = (int)((0.8 * appWidth)/list.length);
            for(int i=0; i<list.length;i++) {
                int h =list[i] * appHeight/100; //Change 100 to set scale/max value
                //draws the bar
                g.drawRect(XOffset + i*rectWidth, appHeight - YOffset - h, rectWidth, h);

                //draws the number below in a box
                if(i == currI) {
                    g.setColor(Color.pink);
                    g.fillRect(XOffset + i * rectWidth, appHeight - YOffset, rectWidth, rectWidth);
                    g.setColor(Color.BLACK);
                }
                g.drawRect(XOffset + i * rectWidth, appHeight - YOffset, rectWidth, rectWidth);
                drawCenteredString(g, Integer.toString(list[i]),
                                   new Rectangle(XOffset + i*rectWidth,appHeight - YOffset, rectWidth, rectWidth)
                                    ,new Font("Courier", Font.PLAIN, rectWidth/2));


            }

        }

        private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
            FontMetrics metrics = g.getFontMetrics(font);
            int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
            int y = rect.y + (rect.height - metrics.getHeight()) / 2 + metrics.getAscent();
            g.setFont(font);
            g.drawString(text, x, y);
        }

        private void doOneInsertion(int i) {
            if(i == list.length) return;
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
            currI++;
        }

        private void doOneSelection(int j){
            if(j == list.length-1) return;
            int min = list[j];
            for(int i=j;i<list.length;i++){
                if(list[i]<min){
                    min=list[i];
                    //swaps min with first number
                    int temp = list[j];
                    list[j] = min;
                    list[i] = temp;
                }
            }
            currI++;
        }
    }
