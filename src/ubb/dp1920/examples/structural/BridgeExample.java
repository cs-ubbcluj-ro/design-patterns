package ubb.dp1920.examples.structural;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * 
 * Abstraction class for the Window
 *
 */
class Window {
	private WindowImp impl;

	public Window() {
		this.impl = WindowSystemFactory.getInstance();
	}

	public void drawContents() {
	}

	public void open() {
	}

	public void iconify() {
	}

	public void deiconify() {
	}

	public void setOrigin(Point p) {
		WindowImp wimp = getWindowImp();
		wimp.impSetOrigin(p.x, p.y);
	}

	public void setExtent(Point p) {
		WindowImp wimp = getWindowImp();
		wimp.impSetExtent(p.x, p.y);
	}

	public void raise() {
	}

	public void lower() {
	}

	public void drawLine(Point from, Point to) {
	}

	public void drawRect(Point from, Point to) {
	}

	public void drawText(String text, Point origin) {
	}

	protected WindowImp getWindowImp() {
		return this.impl;
	}

	public void setVisible(boolean visible) {
		this.impl.setVisible(visible);
	}
}

/**
 * 
 * Platform agnostic window implementation
 *
 */
abstract class WindowImp {
	public abstract void impTop();

	public abstract void impBottom();

	public abstract void impSetExtent(int width, int height);

	public abstract void impSetOrigin(int x, int y);

	public abstract void deviceRect(int x, int y, int width, int height);

	public abstract void deviceText(int x, int y, String text);

	public abstract void deviceBitmap(int x, int y, Image image);

	public abstract void setVisible(boolean visible);
}

class SwingWindow extends WindowImp {

	private JFrame frame = new JFrame("Bridge Example");

	@Override
	public void impTop() {
	}

	@Override
	public void impBottom() {
	}

	@Override
	public void impSetExtent(int width, int height) {
		frame.setSize(width, height);
	}

	@Override
	public void impSetOrigin(int x, int y) {
		frame.setLocation(x, y);
	}

	@Override
	public void deviceRect(int x, int y, int width, int height) {
	}

	@Override
	public void deviceText(int x, int y, String text) {
	}

	@Override
	public void deviceBitmap(int x, int y, Image image) {
	}

	@Override
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}

class AWTWindow extends WindowImp {
	private Frame frame;

	public AWTWindow() {
		frame = new Frame("Bridge example");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				frame.dispose();
			}
		});
	}

	@Override
	public void impTop() {
	}

	@Override
	public void impBottom() {
	}

	@Override
	public void impSetExtent(int width, int height) {
		frame.setSize(width, height);
	}

	@Override
	public void impSetOrigin(int x, int y) {
		frame.setLocation(x, y);
	}

	@Override
	public void deviceRect(int x, int y, int width, int height) {
	}

	@Override
	public void deviceText(int x, int y, String text) {
	}

	@Override
	public void deviceBitmap(int x, int y, Image image) {
	}

	@Override
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}

/**
 * 
 * Factory class implemented as Singleton to return current Window instance
 *
 */
class WindowSystemFactory {
	private static WindowImp wimp = null;

	// Non thread-safe Singleton implementation
	public static WindowImp getInstance() {
		if (wimp == null) {

			// Vary here what is actually created
			// wimp = new AWTWindow();
			wimp = new SwingWindow();
		}
		return wimp;
	}
}

public class BridgeExample {

	public BridgeExample() {
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {

			// No mention here of any GUI framework
			@Override
			public void run() {
				Window window = new Window();
				window.setOrigin(new Point(400, 300));
				window.setExtent(new Point(700, 300));
				window.setVisible(true);
			}
		});
	}
}
