internal class Solution {
  fun maxJump(stones: IntArray): Int {
    var ans = stones[1] - stones[0]
    for (i in 2 until stones.size) {
      ans = max(ans, stones[i] - stones[i - 2])
    }
    return ans
  }
}
