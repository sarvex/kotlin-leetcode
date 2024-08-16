internal class Solution {
  fun numberOfSequence(n: Int, sick: IntArray): Int {
    val m = sick.size
    val nums = IntArray(m + 1)
    nums[0] = sick[0]
    nums[m] = n - sick[m - 1] - 1
    for (i in 1 until m) {
      nums[i] = sick[i] - sick[i - 1] - 1
    }
    var s = 0
    for (x in nums) {
      s += x
    }
    var ans: Int = Solution.Companion.FAC.get(s)
    for (x in nums) {
      if (x > 0) {
        ans = (ans.toLong() * qpow(
          Solution.Companion.FAC.get(x).toLong(),
          (Solution.Companion.MOD - 2).toLong()
        ) % Solution.Companion.MOD).toInt()
      }
    }
    for (i in 1 until nums.size - 1) {
      if (nums[i] > 1) {
        ans = (ans.toLong() * qpow(2, (nums[i] - 1).toLong()) % Solution.Companion.MOD).toInt()
      }
    }
    return ans
  }

  private fun qpow(a: Long, n: Long): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if ((n and 1L) == 1L) {
        ans = ans * a % Solution.Companion.MOD
      }
      a = a * a % Solution.Companion.MOD
      n = n shr 1
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = (1e9 + 7).toInt()
    private const val MX = 100000
    private val FAC = IntArray(Solution.Companion.MX + 1)

    init {
      Solution.Companion.FAC.get(0) = 1
      for (i in 1..Solution.Companion.MX) {
        Solution.Companion.FAC.get(i) =
          (Solution.Companion.FAC.get(i - 1).toLong() * i % Solution.Companion.MOD).toInt()
      }
    }
  }
}
