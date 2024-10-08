import java.util.*

internal class Graph(private val n: Int, edges: Array<IntArray>) {
  private val g = Array(n) { IntArray(n) }
  private val inf = 1 shl 29

  init {
    for (f in g) {
      Arrays.fill(f, inf)
    }
    for (e in edges) {
      val f = e[0]
      val t = e[1]
      val c = e[2]
      g[f][t] = c
    }
  }

  fun addEdge(edge: IntArray) {
    val f = edge[0]
    val t = edge[1]
    val c = edge[2]
    g[f][t] = c
  }

  fun shortestPath(node1: Int, node2: Int): Int {
    val dist = IntArray(n)
    val vis = BooleanArray(n)
    Arrays.fill(dist, inf)
    dist[node1] = 0
    for (i in 0 until n) {
      var t = -1
      for (j in 0 until n) {
        if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
          t = j
        }
      }
      vis[t] = true
      for (j in 0 until n) {
        dist[j] = min(dist[j], dist[t] + g[t][j])
      }
    }
    return if (dist[node2] >= inf) -1 else dist[node2]
  }
}
/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
