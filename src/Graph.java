/**
 * Created by inspi on 15.11.2017.
 */
public class Graph {
    private final int VERTEX_MAX = 100;
    private Vertex[] vertexList;
    private int vertexCount;
    private int[][] matrix;
    Stack stack = new Stack();

    public Graph(int n){
        matrix = new int[VERTEX_MAX][VERTEX_MAX];
        for(int i=0; i<VERTEX_MAX; i++){
            for(int j=0; j<VERTEX_MAX;j++){
                matrix[i][j] = 0;
                vertexCount = 0;
                vertexList = new Vertex[VERTEX_MAX];
            }
        }
    }

    public void addVertex(String label){
        vertexList[vertexCount++] = new Vertex(label);
    }

    public void addEdge(int begin, int end){
        matrix[begin][end] = 1;
        matrix[end][begin] = 0;
    }

    void dfs(int v){
        vertexList[v].setVisited(true);
        stack.push(0);
        int i = 0;
        System.out.println(vertexList[v].getLabel());

        while (!stack.isEmpty()){
            int current = stack.peek();
            int vertex = getSuccessor(current);
            if(vertex == -1){
                stack.pop();
            }else{
                vertexList[vertex].setVisited(true);
                System.out.println(vertex);
                stack.push(vertex);
            }
        }
        for(int j = 0; j<vertexCount; j++){
            vertexList[j].setVisited(false);
        }

    }

    int getSuccessor(int v){
        for(int j=0; j< vertexCount; j++) {
            if (matrix[v][j]==1 && !vertexList[j].isVisited()){
                return j;

            }
        }
        return -1;
    }
}
