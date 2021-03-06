package plia.core.debug;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class DebugLineSphere
{
	private float[] vertices = new float[576];

	private DebugLineSphere()
	{
		for(int i=0; i<64;i++)
		{
			float a = (i*5.625f)/57.2958f;
			float ca = (float) (Math.cos(a));
			float sa = (float) (Math.sin(a));
			
			// X Up
			vertices[(i * 3) + 1] = ca;
			vertices[(i * 3) + 2] = sa;
			
			// Y Up
			vertices[(i * 3) + 192] = ca;
			vertices[(i * 3) + 194] = sa;

			// Z Up
			vertices[(i * 3) + 384] = ca;
			vertices[(i * 3) + 385] = sa;
		}
		
		vb = ByteBuffer.allocateDirect(vertices.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
		vb.put(vertices).position(0);
	}
	
	public float[] getVertices()
	{
		return vertices;
	}
	
	public int getOffset()
	{
		return 64;
	}
	
	public int getIndicesCount()
	{
		return 64;
	}
	
	private static DebugLineSphere instance = new DebugLineSphere();
	static DebugLineSphere getInstance()
	{
		return instance;
	}
	
	private static FloatBuffer vb;
	static FloatBuffer getVB()
	{
		return vb;
	}
}
