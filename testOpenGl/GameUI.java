package testOpenGl;
import org.lwjgl.LWJGLException;

import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class GameUI {
	
	final int WIDTH, HEIGHT, FPS = 120;
	
	public GameUI(int WIDTH, int HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		
		ContextAttribs context = new ContextAttribs(3,2);
		context.withForwardCompatible(true);
		context.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(),context);
			Display.setTitle("Test");
		}
		catch (LWJGLException e) {}
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0,0,0,0);
	}
	
	public void update() {
		Display.sync(FPS);
		Display.update();
	}
	
	public void close() {
		Display.destroy();
	}
}
