internal class Solution {
  fun minCost(costs: Array<IntArray>): Int {
    var r = 0
    var g = 0
    var b = 0
    for (cost in costs) {
      val _r = r
      val _g = g
      val _b = b
      r = min(_g, _b) + cost[0]
      g = min(_r, _b) + cost[1]
      b = min(_r, _g) + cost[2]
    }
    return min(r, min(g, b))
  }
}
