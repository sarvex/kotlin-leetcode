internal class Solution {
  fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
    var a = capacityA
    var b = capacityB
    var ans = 0
    var i = 0
    var j = plants.size - 1
    while (i < j) {
      if (a < plants[i]) {
        ++ans
        a = capacityA
      }
      a -= plants[i]
      if (b < plants[j]) {
        ++ans
        b = capacityB
      }
      b -= plants[j]
      ++i
      --j
    }
    ans += if (i == j && max(a, b) < plants[i]) 1 else 0
    return ans
  }
}
