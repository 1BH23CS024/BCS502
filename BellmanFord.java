import java.util.*;

public class BellmanFord {
    private static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of vertices: ");
        // Enter number of vertices: 4
        int n = sc.nextInt();
        
        int[][] graph = new int[n + 1][n + 1];
        System.out.println("Enter Weighted Matrix (use 0 for no edge):");
        // Enter Weighted Matrix (use 0 for no edge):
        // 0 5 0 0
        // 5 0 3 4
        // 0 3 0 2
        // 0 4 2 0
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int weight = sc.nextInt();
                if (i != j && weight == 0) weight = INF;
                graph[i][j] = weight;
            }
        }

        System.out.print("Enter Source Vertex: ");
        // Enter Source Vertex: 2
        solve(n, graph, sc.nextInt());
        sc.close();
    }

    static void solve(int n, int[][] graph, int src) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int k = 1; k < n; k++) {
            for (int u = 1; u <= n; u++) {
                for (int v = 1; v <= n; v++) {
                    if (graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        for (int u = 1; u <= n; u++) {
            for (int v = 1; v <= n; v++) {
                if (graph[u][v] != INF && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains a negative edge cycle");
                    return;
                }
            }
        }
        
        System.out.println("\nVertex\tDistance from Source");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\t" + (dist[i] == INF ? "INF" : dist[i]));
        }
    }
}