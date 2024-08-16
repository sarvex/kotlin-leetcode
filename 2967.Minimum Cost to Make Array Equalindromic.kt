import java.util.*

class Solution {
  private var nums: IntArray

  fun minimumCost(nums: IntArray): Long {
    this.nums = nums
    Arrays.sort(nums)
    var i: Int = Arrays.binarySearch(Solution.Companion.ps, nums[nums.size / 2])
    i = if (i < 0) -i - 1 else i
    var ans = 1L shl 60
    for (j in i - 1..(i + 1)) {
      if (0 <= j && j < Solution.Companion.ps.size) {
        ans = min(ans, f(Solution.Companion.ps.get(j)))
      }
    }
    return ans
  }

  private fun f(x: Long): Long {
    var ans: Long = 0
    for (v in nums) {
      ans += abs(v - x)
    }
    return ans
  }

  companion object {
    private val ps: LongArray

    init {
      Solution.Companion.ps = LongArray(2 * 1e5.toInt())
      var i = 1
      while (i <= 1e5) {
        val s = i.toString()
        val t1 = StringBuilder(s).reverse().toString()
        val t2: String = StringBuilder(s.substring(0, s.length - 1)).reverse().toString()
        Solution.Companion.ps.get(2 * i - 2) = (s + t1).toLong()
        Solution.Companion.ps.get(2 * i - 1) = (s + t2).toLong()
        i++
      }
      Arrays.sort(Solution.Companion.ps)
    }
  }
}
