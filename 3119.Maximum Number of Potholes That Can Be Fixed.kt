internal class Solution {
  fun maxPotholes(road: String, budget: Int): Int {
    var road = road
    var budget = budget
    road += "."
    val n = road.length
    val cnt = IntArray(n)
    var k = 0
    for (c in road.toCharArray()) {
      if (c == 'x') {
        ++k
      } else if (k > 0) {
        ++cnt[k]
        k = 0
      }
    }
    var ans = 0
    k = n - 1
    while (k > 0 && budget > 0) {
      val t: Int = min(budget / (k + 1), cnt[k])
      ans += t * k
      budget -= t * (k + 1)
      cnt[k - 1] += cnt[k] - t
      --k
    }
    return ans
  }
}
