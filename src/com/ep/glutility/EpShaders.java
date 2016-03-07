package com.ep.glutility;

/**
 * Created by Chris on 2/15/2016.
 * Shaders being stored as strings
 */
public class EpShaders {

    /**
     * Basic vertex shader used for testing
     */
    public final static String SIMPLE_VERTEX_SHADER = "" +
            "attribute vec3 ep_vertex;" +
            "void main()" +
            "{" +
            "   gl_Position = vec4(ep_vertex, 1.0);" +
            "}";

    /**
     * Basic vertex shader used for testing
     */
    public final static String PMV_VERTEX_SHADER = "" +
            "uniform mat4 ep_modelViewMatrix;" +
            "uniform mat4 ep_projectionMatrix;" +
            "attribute vec3 ep_vertex;" +
            "void main()" +
            "{" +
            "   gl_Position = ep_projectionMatrix * ep_modelViewMatrix * vec4(ep_vertex, 1.0);" +
            "}";

    /**
     * Basic fragment shader used for testing
     */
    public final static String SIMPLE_FRAGMENT_SHADER = "" +
            "void main()" +
            "{" +
            "   gl_FragColor = vec4(0.3, 0.2, 0.5, 1.0);" +
            "}";
}
