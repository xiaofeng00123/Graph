package Graph;

import org.junit.Test;

public class GraphTest {

    @Test
    public void bfsTest(){
        Graph g = new Graph(7);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.bfs(1,6);
    }

    @Test
    public void dfsTest(){
        Graph g = new Graph(7);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.bfs(1,6);
    }


    /**
     * 找出社交网络中用户s的n度好友
     * 此处是找出用户1的1度好友
     */
    @Test
    public void findTest(){
        Graph g = new Graph(7);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.find(1,2);
    }

}
