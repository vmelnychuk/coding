package io.learn.javacore.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");

        a.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        b.addNeighbor(d);
        c.addNeighbor(b);
        c.addNeighbor(e);
        d.addNeighbor(b);
        e.addNeighbor(c);

        List<Vertex> vertices =  new ArrayList<>();
        vertices.add(a);

        DepthFirstSearch dfs = new DepthFirstSearch();
        List<Vertex> path = dfs.dfs(vertices);
        System.out.println("\tpath:\n" + path);

    }
}
