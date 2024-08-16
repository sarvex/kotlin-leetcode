internal class Solution {
  fun numberOfWeeks(milestones: IntArray): Long {
    var mx = 0
    var s: Long = 0
    for (e in milestones) {
      s += e.toLong()
      mx = max(mx, e)
    }
    val rest = s - mx
    return if (mx > rest + 1) rest * 2 + 1 else s
  }
}
