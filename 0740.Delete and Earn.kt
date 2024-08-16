internal class Solution {
  fun deleteAndEarn(nums: IntArray): Int {
    if (nums.size == 0) {
      return 0
    }

    val sums = IntArray(10010)
    val select = IntArray(10010)
    val nonSelect = IntArray(10010)

    var maxV = 0
    for (x in nums) {
      sums[x] += x
      maxV = max(maxV, x)
    }

    for (i in 1..maxV) {
      select[i] = nonSelect[i - 1] + sums[i]
      nonSelect[i] = max(select[i - 1], nonSelect[i - 1])
    }
    return max(select[maxV], nonSelect[maxV])
  }
}
