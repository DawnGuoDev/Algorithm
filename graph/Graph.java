package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int v;  // 顶点的个数
    private LinkedList<Integer>[] adj;  // 邻接表
    private boolean FIND_DFS = false; 

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    /**
     * 图添加边
     * @param f
     * @param t
     */
    public void addEdge(int f, int t) {
        this.adj[f].add(t);
        this.adj[t].add(f);
    }

    /**
     * 广度优先搜索
     * @param from 起点
     * @param to  终点
     */
    public void bfsSearch(int from, int to) {
        if (this.v == 0 || from == to) {
            return;
        }
        
        boolean[] visited = new boolean[this.v];
        int[] paths = new int[this.v]; // 记录路径，记录该节点前面的节点是哪个   
        for (int i = 0; i < this.v; i++) {
            visited[i] = false;
            paths[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        visited[from] = true;

        while (!queue.isEmpty()) {
            int w = queue.poll();
            
            for (Integer i : this.adj[w]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    paths[i] = w;

                    if (i == to) {
                        printPath(paths, to);
                        break;
                    }
                }
            }
        }

        // int temp = to;
        // while (paths[temp] != -1) {
            // System.out.print(temp + "\t");
            // temp = paths[temp];
        // }
        // System.out.println(temp);
    }

    /**
     * 深度优先搜索，递归方式
     * @param from
     * @param to
     */
    public void dfsSearch(int from, int to) {
        if (this.v == 0 || from == to) {
            return;
        }

        boolean[] visited = new boolean[this.v];
        int[] paths = new int[this.v];
        for (int i = 0; i < this.v; i++) {
            visited[i] = false;
            paths[i] = -1;
        }
        
        visited[from] = true;
        reDFSS(from, to, visited, paths);

        if (this.FIND_DFS == true) {
            printPath(paths, to);
        }
    }

    /**
     * 深度优先搜索，递归主体
     * @param from
     * @param to
     * @param visited
     * @param paths
     */
    public void reDFSS(int from, int to, boolean[] visited, int[] paths) {
     
        if (from == to) {
            this.FIND_DFS = true; 
            return;
        }

        for (Integer i : this.adj[from]) {
            if (this.FIND_DFS) {
                return;
            }
            if (!visited[i]) {
                visited[i] = true;
                paths[i] = from;
                
                reDFSS(i, to, visited, paths);
            }
        }
    }
    
    /**
     * 打印搜索路径
     * @param paths
     * @param begin
     */
    public void printPath(int[] paths, int begin) {
        if (begin == -1) {
            return;
        }
        printPath(paths, paths[begin]);

        System.out.print(begin + "\t");
    }

    /**
     * 广度优先遍历
     */
    public void bfsTraversal() {
        if (this.v == 0) {
            return;
        }

        boolean[] visited = new boolean[this.v];
        for (int i = 0; i < this.v; i++) {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int w = queue.poll();
            System.out.print(w + "\t");
            
            for (Integer i : this.adj[w]) {
                if (visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * 深度优先遍历，递归方式
     */
    public void dfsTraversal() {
        if (this.v == 0) {
            return;
        }

        boolean[] visited = new boolean[this.v];
        for (int i = 0; i < this.v; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < this.v; i++) {
            if (!visited[i]) {
                reDFST(i, visited);
            }
        }
    }

    public void reDFST(int f, boolean[] visited) {

        visited[f] = true;
        System.out.print(f + "\t");
        for (Integer i : this.adj[f]) {
            if(!visited[i]) {
                reDFST(i, visited);
            }
        }
    }

    /**
     * 深度优先遍历，使用栈的方式
     */
    public void dfsTraversalStack() {
        if (this.v == 0) {
            return;
        }

        boolean[] visited = new boolean[this.v];
        for (int i = 0; i < this.v; i++) {
            visited[i] = false;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        System.out.print(0 + "\t");

        while (!stack.isEmpty()) {
            int w = stack.peek();
            int flag = 0;
            for (Integer i : this.adj[w]) {
                if (!visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + "\t");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Graph g =  new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(3, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        // g.bfsTraversal();
        // g.dfsTraversal();
        g.bfsSearch(0, 7);
        System.out.println();
        g.dfsSearch(0, 7);
    }
}