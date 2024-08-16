internal class Solution {
  fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    var m = m
    var n = n
    for (op in ops) {
      m = min(m, op[0])
      n = min(n, op[1])
    }
    return m * n
  }
}
