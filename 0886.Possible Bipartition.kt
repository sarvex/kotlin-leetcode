internal class Solution {
  private var g: Array<List<Int>>
  private var color: IntArray

  fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
    g = arrayOfNulls(n)
    color = IntArray(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in dislikes) {
      val a = e[0] - 1
      val b = e[1] - 1
      g[a].add(b)
      g[b].add(a)
    }
    for (i in 0 until n) {
      if (color[i] == 0) {
        if (!dfs(i, 1)) {
          return false
        }
      }
    }
    return true
  }

  private fun dfs(i: Int, c: Int): Boolean {
    color[i] = c
    for (j in g[i]) {
      if (color[j] == c) {
        return false
      }
      if (color[j] == 0 && !dfs(j, 3 - c)) {
        return false
      }
    }
    return true
  }
}
