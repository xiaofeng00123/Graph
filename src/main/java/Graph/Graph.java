package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表实现无向图
 */
public class Graph {


    private int v;   //顶点个数
    private LinkedList<Integer> adj[]; //邻接表
    private boolean found = false;  //用于表示dfs还没有找到终点
    private int k = 0; //记录正在访问的是几度好友

    public Graph(int v){
        this.v=v;
        adj = new LinkedList[v];
        for(int i = 0; i<v; i++){
            adj[i]=new LinkedList<Integer>();
        }
    }

    /**
     * 从这里可以看出是无向图
     * @param s
     * @param t
     */
    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索, 搜索s到t的最短路径
     * 此处用的邻接表来存储的图
     * @param s 搜索的起点
     * @param t 搜索的终点
     */
    public void bfs(int s, int t){
        if(s==t) return;
        boolean[] visited = new boolean[v];  //记录已经访问过的节点
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<Integer>();  //一个队列，用于存储已经被访问但相邻节点还没被访问的节点
        queue.add(s);
        int[] pre = new int[v];  //记录当前搜索路径
        for(int i = 0; i<pre.length; i++){
            pre[i] = -1;
        }
        while(queue.size()!=0){
            int w = queue.poll();
            for(int i = 0; i<adj[w].size(); i++){
                int q = adj[w].get(i);
                if(!visited[q]){
                    pre[q]=w;
                    if(q==t){
                        print(pre, s, t);
                        return;
                    }
                    visited[q]=true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] pre, int s, int t){  //递归打印s->t的路径
        if(pre[t]!=-1 && s!=t){
            print(pre, s, pre[t]);
        }
        System.out.print(t+" ");
    }

    /**
     * 找出社交网络中用户s的n度好友
     * @param s
     * @param n
     */
    public void find(int s, int n){
        ArrayList<Integer> friends = new ArrayList<Integer>();
        boolean[] visited = new boolean[v];  //记录已经访问过的节点
        visited[s]=true;
        
    }

    /**
     * 深度优先搜索
     * @param s
     * @param t
     */
    public void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for(int i = 0; i<pre.length; i++){
            pre[i]=-1;
        }
        recurDfs(s, t, visited, pre);
        print(pre, s, t);
    }

    public void recurDfs(int w, int t, boolean[] visited, int[] pre){
        if(found==true)
            return;
        visited[w]=true;
        if(w==t){
            found=true;
            return;
        }
        for(int i = 0; i<adj[w].size(); i++){
            int q = adj[w].get(i);
            if(!visited[q]){
                pre[q]=w;
                recurDfs(q,t,visited,pre);
            }
        }
    }

}
