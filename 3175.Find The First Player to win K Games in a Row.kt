internal class Solution {
  fun findWinningPlayer(skills: IntArray, k: Int): Int {
    var k = k
    val n = skills.size
    k = min(k, n - 1)
    var i = 0
    var cnt = 0
    for (j in 1 until n) {
      if (skills[i] < skills[j]) {
        i = j
        cnt = 1
      } else {
        ++cnt
      }
      if (cnt == k) {
        break
      }
    }
    return i
  }
}
