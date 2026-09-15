public class DijkstrasAlgorithm {

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, 1, 0, 0},
            {4, 0, 2, 5, 0},
            {1, 2, 0, 8, 10},
            {0, 5, 8, 0, 2},
            {0, 0, 10, 2, 0}
        };

        int vertices = graph.length;

        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Set all distances to infinity
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Starting vertex is 0
        distance[0] = 0;

        // Find shortest paths
        for (int count = 0; count < vertices - 1; count++) {

            int min = Integer.MAX_VALUE;
            int current = -1;

            // Find unvisited vertex with smallest distance
            for (int i = 0; i < vertices; i++) {

                if (!visited[i] && distance[i] < min) {

                    min = distance[i];
                    current = i;
                }
            }

            visited[current] = true;

            // Update distances of connected vertices
            for (int i = 0; i < vertices; i++) {

                if (graph[current][i] != 0 && !visited[i]) {

                    int newDistance = distance[current] + graph[current][i];

                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                    }
                }
            }
        }

        System.out.println("Dijkstra's Algorithm");
        System.out.println("--------------------");
        System.out.println("Starting vertex: 0");

        System.out.println("\nShortest distances:");

        for (int i = 0; i < vertices; i++) {

            System.out.println("Vertex 0 to Vertex " + i
                    + " = " + distance[i]);
        }
    }
}
