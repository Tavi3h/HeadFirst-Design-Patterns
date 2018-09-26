package ch_08_TemplateMethodPattern.swing;

import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	// hook method
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "I rule!!";
		graphics.drawString(msg, 100, 100);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyFrame mf = new MyFrame("Head First Design Patterns");
	}

}
