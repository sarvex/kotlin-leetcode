internal class Solution {
  fun average(salary: IntArray): Double {
    var s = 0
    var mi = 10000000
    var mx = 0
    for (v in salary) {
      mi = min(mi, v)
      mx = max(mx, v)
      s += v
    }
    s -= (mi + mx)
    return s * 1.0 / (salary.size - 2)
  }
}
