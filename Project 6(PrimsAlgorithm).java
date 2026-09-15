public class PrimsAlgorithm {

    public static void main(String[] args) {

        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int vertices = graph.length;

        boolean[] selected = new boolean[vertices];

        selected[0] = true;

        int totalCost = 0;

        System.out.println("Prim's Algorithm");
        System.out.println("----------------");

        for (int edge = 0; edge < vertices - 1; edge++) {

            int min = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;

            for (int i = 0; i < vertices; i++) {

                if (selected[i]) {

                    for (int j = 0; j < vertices; j++) {

                        if (!selected[j] && graph[i][j] != 0) {

                            if (graph[i][j] < min) {

                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println("Edge: " + x + " - " + y
                    + "  Weight: " + graph[x][y]);

            totalCost = totalCost + graph[x][y];

            selected[y] = true;
        }

        System.out.println("\nMinimum Spanning Tree Cost: " + totalCost);
    }
}
