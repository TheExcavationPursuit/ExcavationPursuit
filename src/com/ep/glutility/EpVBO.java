package com.ep.glutility;

import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import static org.lwjgl.opengl.GL15.*;

/**
 * Created by Chris on 3/6/2016.
 */
public class EpVBO {

    private int vboID;
    private boolean binded;

    private int vertSize;
    private double vertices[];

    private static final int BYTES_PER_DOUBLE = 8;

    public EpVBO() {
        binded = false;
    }

    /**
     * Generate buffer for VBO
     * @return id of buffer generated
     */
    private int genVBO() {
        IntBuffer buffer = BufferUtils.createIntBuffer(1);
        glGenBuffers(buffer);
        vboID = buffer.get(0);
        return vboID;
    }

    public void bindVBO() {
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        binded = true;
    }

    public void loadDataCPU(ArrayList<Double> vertices) {
        vertSize = vertices.size();
        for(int i = 0; i < vertSize; i++) {
            this.vertices[i] = vertices.get(i);
        }
    }

    public void loadDataGPU() {
        ByteBuffer buffer = BufferUtils.createByteBuffer(BYTES_PER_DOUBLE * vertSize);
        for(int i = 0; i < vertSize; i++) {
            buffer.putDouble(vertices[i]);
        }

        if(binded) {
            if(vertSize > 0) {
                glBufferData(vboID, buffer, GL_STATIC_DRAW);
            }
        }

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        binded = false;
    }
}
