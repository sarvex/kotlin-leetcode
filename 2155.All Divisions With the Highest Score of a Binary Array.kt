internal class Solution {
  fun maxScoreIndices(nums: IntArray): List<Int> {
    var l0 = 0
    var r1: Int = Arrays.stream(nums).sum()
    var mx = r1
    val ans: List<Int> = ArrayList()
    ans.add(0)
    for (i in 1..nums.size) {
      val x = nums[i - 1]
      l0 += x xor 1
      r1 -= x
      val t = l0 + r1
      if (mx == t) {
        ans.add(i)
      } else if (mx < t) {
        mx = t
        ans.clear()
        ans.add(i)
      }
    }
    return ans
  }
}
