package testOpenGl;

import rendering.*;
import org.lwjgl.opengl.Display;

public class MainLoop {
	
	static GameUI game;
	public static void main(String[] args) {
		
		game = new GameUI(1000,720);
		
		ModelLoader modelLoader = new ModelLoader();
		Renderer renderer = new Renderer();
		
		float[] vertices = {
			// triangle
		     0.0f,  0.5f, 0f, // summit
		     0.5f,  0.0f, 0f, // bottom right
		    -0.5f,  0.0f, 0f, // bottom left
	    };
		
		ModelDetails model = modelLoader.loadToVertexArrayObject(vertices);
		
		while (!Display.isCloseRequested()) {
			game.update();
			renderer.render(model);
		}
		modelLoader.onEnd();
		game.close();
	}
}
