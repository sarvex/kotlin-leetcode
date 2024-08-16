internal class Solution {
  fun minSideJumps(obstacles: IntArray): Int {
    val inf = 1 shl 30
    val f = intArrayOf(1, 0, 1)
    for (i in 1 until obstacles.size) {
      for (j in 0..2) {
        if (obstacles[i] == j + 1) {
          f[j] = inf
          break
        }
      }
      val x: Int = min(f[0], min(f[1], f[2])) + 1
      for (j in 0..2) {
        if (obstacles[i] != j + 1) {
          f[j] = min(f[j], x)
        }
      }
    }
    return min(f[0], min(f[1], f[2]))
  }
}
