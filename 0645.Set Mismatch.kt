internal class Solution {
  fun findErrorNums(nums: IntArray): IntArray {
    val n = nums.size
    val s1 = (1 + n) * n / 2
    var s2 = 0
    val set: Set<Int> = HashSet()
    var s = 0
    for (x in nums) {
      if (set.add(x)) {
        s2 += x
      }
      s += x
    }
    return intArrayOf(s - s2, s1 - s2)
  }
}
