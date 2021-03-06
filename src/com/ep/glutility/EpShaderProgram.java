package com.ep.glutility;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Chris on 2/15/2016.
 *
 */
public class EpShaderProgram {

    private int shaderProgramID;
    private enum shader {VERTEX, FRAGMENT}

    public int compileShader(String shaderString, shader type) {

        int shaderID = -1;

        if(type == EpShaderProgram.shader.VERTEX) {
            shaderID = glCreateShader(GL_VERTEX_SHADER);
        } else if(type == EpShaderProgram.shader.FRAGMENT) {
            shaderID = glCreateShader(GL_FRAGMENT_SHADER);
        }

        glShaderSource(shaderID, shaderString);

        glCompileShader(shaderID);

        //Note - Tried using glGetShaderiv(shaderID, GL_COMPILE_STATUS, IntBuffer); and java se was crashing
        int success = glGetShaderi(shaderID, GL_COMPILE_STATUS);
        if(success == GL_FALSE) {
            System.out.println("Shader failed to compile");
        } else {
            System.out.println("Shader compiled successfully");
        }

        return shaderID;
    }

    public void createShaderProgram() {
        shaderProgramID = glCreateProgram();

        int vertexShader   = compileShader(EpShaders.SIMPLE_VERTEX_SHADER, shader.VERTEX);
        int fragmentShader = compileShader(EpShaders.SIMPLE_FRAGMENT_SHADER, shader.FRAGMENT);
    }
}
