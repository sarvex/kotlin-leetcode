internal class Solution {
  fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
    val tx = target[0]
    val ty = target[1]
    for (g in ghosts) {
      val x = g[0]
      val y = g[1]
      if (abs(tx - x) + abs(ty - y) <= abs(tx) + abs(ty)) {
        return false
      }
    }
    return true
  }
}
