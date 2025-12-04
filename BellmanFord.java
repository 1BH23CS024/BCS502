import java.util.*;

public class BellmanFord {
    static final int INF = 99999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        // Enter number of vertices: 4
        int n = sc.nextInt();
        int[][] g = new int[n + 1][n + 1];

        System.out.println("Enter Weighted Matrix:");
        // Enter Weighted Matrix:
        // 0 5 0 0
        // 5 0 3 4
        // 0 3 0 2
        // 0 4 2 0
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                g[i][j] = sc.nextInt();
                if (i != j && g[i][j] == 0) g[i][j] = INF;
            }

        System.out.print("Enter Source Vertex: ");
        // Enter Source Vertex: 2
        solve(n, g, sc.nextInt());
        sc.close();
    }

    static void solve(int n, int[][] g, int src) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[src] = 0;

        for (int k = 1; k <= n; k++) {
            for (int u = 1; u <= n; u++) {
                for (int v = 1; v <= n; v++) {
                    if (g[u][v] != INF && d[u] != INF && d[u] + g[u][v] < d[v]) {
                        if (k == n) {
                            System.out.println("Graph contains a negative edge cycle");
                            return;
                        }
                        d[v] = d[u] + g[u][v];
                    }
                }
            }
        }

        System.out.println("\nVertex\tDistance from Source");
        for (int i = 1; i <= n; i++) 
            System.out.println(i + "\t" + (d[i] == INF ? "INF" : d[i]));
    }
}