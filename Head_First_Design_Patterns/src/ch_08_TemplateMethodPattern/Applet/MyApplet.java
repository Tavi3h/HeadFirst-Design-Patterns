package ch_08_TemplateMethodPattern.Applet;
// P307
import java.applet.Applet;
import java.awt.Graphics;
// 具体的Applet大量使用钩子来提供行为。因为这些行为是作为钩子实现的，所以Applet类就不用去实现它们。
public class MyApplet extends Applet {

	private static final long serialVersionUID = -2450217038180585505L;

	private String msg;

	/*
	 * 一些钩子方法
	 */
	public void init() {
		msg = "Hello Word, I'm alive!";
		repaint();
	}

	public void start() {
		msg = "Now, I'm starting up ...";
		repaint();
	}

	public void stop() {
		msg = "Oh, now I'm being stopped";
		repaint();
	}

	public void destroy() {

	}

	public void paint(Graphics g) {
		g.drawString(msg, 5, 15);
	}

}
