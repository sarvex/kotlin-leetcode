internal class Solution {
  fun minimumHealth(damage: IntArray, armor: Int): Long {
    var s: Long = 0
    var mx = damage[0]
    for (v in damage) {
      s += v.toLong()
      mx = max(mx, v)
    }
    return s - min(mx, armor) + 1
  }
}
