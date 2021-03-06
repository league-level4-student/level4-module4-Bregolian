package _03_polymorphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolymorphWindow extends JPanel implements ActionListener, MouseMotionListener{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    
    private JFrame window;
    private Timer timer;
    int mouseX;
    int mouseY;
    
    ArrayList<Polymorph> polymorphs = new ArrayList<Polymorph>();
    
    
    public static void main(String[] args) {
   	 new PolymorphWindow().buildWindow();
    }
    
    public void buildWindow(){
   	 window = new JFrame("IT'S MORPHIN' TIME!");
   	 window.add(this);
   	 window.getContentPane().setPreferredSize(new Dimension(500, 500));
   	 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 window.pack();
   	 window.setVisible(true);
   	 window.addMouseMotionListener(this);
   	 
   	 polymorphs.add(new BluePolymorph(50, 50));
   	 polymorphs.add(new RedPolymorph(100,100));
   	 polymorphs.add(new MovingPolymorph(150,100));
   	 polymorphs.add(new MousePolymorph(200,100));
   	 
   	 timer = new Timer(1000 / 30, this);
   	 timer.start();
    }
    
    public void paintComponent(Graphics g){
    //draw background
   	 g.setColor(Color.LIGHT_GRAY);
   	 g.fillRect(0, 0, 500, 500);
   	
   	 //draw polymorph
   	 for (int i = 0; i < polymorphs.size(); i++) {
		polymorphs.get(i).draw(g);
	 }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   	 repaint();
   	for (int i = 0; i < polymorphs.size(); i++) {
   		if(polymorphs.get(i) instanceof MovingPolymorph) {
   			polymorphs.get(i).update();
   		}
   		else if(polymorphs.get(i) instanceof MousePolymorph) {
   			
   		}
		
	 }
    }

	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (int i = 0; i < polymorphs.size(); i++) {
			if(polymorphs.get(i) instanceof MousePolymorph) {
				polymorphs.get(i).setX(e.getX());
				polymorphs.get(i).setY(e.getY());
	   		}
			
		}
	}
	
}
