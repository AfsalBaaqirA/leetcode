class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        double[] prob = new double[n];
        prob[start] = 1.0;  

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double edgeProb = succProb[j];

                if (prob[u] * edgeProb > prob[v]) {
                    prob[v] = prob[u] * edgeProb;
                    updated = true;
                }
                if (prob[v] * edgeProb > prob[u]) {
                    prob[u] = prob[v] * edgeProb;
                    updated = true;
                }
            }
            if (!updated) {
                break;
            }
        }
        return prob[end];
    }
}