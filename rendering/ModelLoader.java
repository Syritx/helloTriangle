package rendering;

import java.nio.FloatBuffer;
import java.util.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

public class ModelLoader {
	
	List<Integer> vertexArrayObjects, vertexBufferObjects;
	
	public ModelDetails loadToVertexArrayObject(float[] v) {
		
		vertexArrayObjects = new ArrayList<Integer>();
		vertexBufferObjects = new ArrayList<Integer>();
		
		int vertexArrayObject = createVertexArrayObject();
		setDataInAttr(vertexArrayObject,v);
		unbindVertexArrayObject();
		
		return new ModelDetails(vertexArrayObject,v.length/3);
	}
	
	int createVertexArrayObject() {
		
		int vertexArrayObject = GL30.glGenVertexArrays();
		vertexArrayObjects.add(vertexArrayObject);
		
		GL30.glBindVertexArray(vertexArrayObject);
		return vertexArrayObject;
	}
	
	void setDataInAttr(int attr, float[] dat) {
		int vertexBufferObjectID = GL15.glGenBuffers();
		vertexBufferObjects.add(vertexBufferObjectID);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferObjectID);
		
		FloatBuffer buffer = setDataInFloatBuffer(dat);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attr, 3, GL11.GL_FLOAT, false, 0, 0);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	void unbindVertexArrayObject() {
		GL30.glBindVertexArray(0);
	}
	
	FloatBuffer setDataInFloatBuffer(float[] dat) {
		FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(dat.length);
		floatBuffer.put(dat);
		floatBuffer.flip();
		return floatBuffer;
	}
	
	public void onEnd() {
		for (int v : vertexArrayObjects) {
			GL30.glDeleteVertexArrays(v);
		}
		
		for (int v : vertexBufferObjects) {
			GL15.glDeleteBuffers(v);
		}
	}
}
