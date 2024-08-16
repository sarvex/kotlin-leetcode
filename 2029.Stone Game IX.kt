internal class Solution {
  fun stoneGameIX(stones: IntArray): Boolean {
    val c1 = IntArray(3)
    for (x in stones) {
      c1[x % 3]++
    }
    val c2 = intArrayOf(c1[0], c1[2], c1[1])
    return check(c1) || check(c2)
  }

  private fun check(cnt: IntArray): Boolean {
    if (--cnt[1] < 0) {
      return false
    }
    var r: Int = 1 + min(cnt[1], cnt[2]) * 2 + cnt[0]
    if (cnt[1] > cnt[2]) {
      --cnt[1]
      ++r
    }
    return r % 2 == 1 && cnt[1] != cnt[2]
  }
}
