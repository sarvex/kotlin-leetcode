internal class Solution {
  fun reachNumber(target: Int): Int {
    var target = target
    target = abs(target)
    var s = 0
    var k = 0
    while (true) {
      if (s >= target && (s - target) % 2 == 0) {
        return k
      }
      ++k
      s += k
    }
  }
}
