internal class Solution {
  fun numPoints(darts: Array<IntArray>, r: Int): Int {
    val n = darts.size
    var maxDarts = 1

    for (i in 0 until n) {
      for (j in i + 1 until n) {
        val centers = possibleCenters(darts[i][0], darts[i][1], darts[j][0], darts[j][1], r)
        for (center in centers) {
          maxDarts = max(maxDarts, countDarts(center[0], center[1], darts, r))
        }
      }
    }
    return maxDarts
  }

  private fun possibleCenters(x1: Int, y1: Int, x2: Int, y2: Int, r: Int): List<DoubleArray> {
    val centers: List<DoubleArray> = ArrayList()
    val dx = (x2 - x1).toDouble()
    val dy = (y2 - y1).toDouble()
    val d: Double = sqrt(dx * dx + dy * dy)
    if (d > 2 * r) {
      return centers
    }
    val midX = (x1 + x2) / 2.0
    val midY = (y1 + y2) / 2.0
    val distToCenter: Double = sqrt(r * r - (d / 2.0) * (d / 2.0))
    val offsetX = distToCenter * dy / d
    val offsetY = distToCenter * -dx / d

    centers.add(doubleArrayOf(midX + offsetX, midY + offsetY))
    centers.add(doubleArrayOf(midX - offsetX, midY - offsetY))
    return centers
  }

  private fun countDarts(x: Double, y: Double, darts: Array<IntArray>, r: Int): Int {
    var count = 0
    for (dart in darts) {
      if (sqrt((dart[0] - x).pow(2) + (dart[1] - y).pow(2)) <= r + 1e-7) {
        count++
      }
    }
    return count
  }
}
