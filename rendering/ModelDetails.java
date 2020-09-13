package rendering;

public class ModelDetails {
	int vertexArrayObjectID;
	int vertices;
	
	public ModelDetails(int vertexArrayObjectID, int vertices) {
		this.vertexArrayObjectID = vertexArrayObjectID;
		this.vertices = vertices;
	}
	
	public int getVertices() {
		return vertices;
	}

	public int getVertexArrayObjectID() {
		return vertexArrayObjectID;
	}
}
