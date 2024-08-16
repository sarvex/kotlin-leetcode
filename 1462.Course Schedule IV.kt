internal class Solution {
  fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
    val f = Array(n) { BooleanArray(n) }
    for (p in prerequisites) {
      f[p[0]][p[1]] = true
    }
    for (k in 0 until n) {
      for (i in 0 until n) {
        for (j in 0 until n) {
          f[i][j] = f[i][j] or (f[i][k] && f[k][j])
        }
      }
    }
    val ans: List<Boolean> = ArrayList()
    for (q in queries) {
      ans.add(f[q[0]][q[1]])
    }
    return ans
  }
}
