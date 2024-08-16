import java.util.*

internal class Solution {
  fun smallestTrimmedNumbers(nums: Array<String>, queries: Array<IntArray>): IntArray {
    val n = nums.size
    val m = queries.size
    val ans = IntArray(m)
    val t = Array<Array<String>>(n) { arrayOfNulls(2) }
    for (i in 0 until m) {
      val k = queries[i][0]
      val trim = queries[i][1]
      for (j in 0 until n) {
        t[j] = arrayOf<String>(nums[j].substring(nums[j].length - trim), j.toString())
      }
      Arrays.sort(t) { a, b ->
        val x = a[0].compareTo(b[0])
        if (x == 0) java.lang.Long.compare(
          Integer.valueOf(a[1]).toLong(),
          Integer.valueOf(b[1]).toLong()
        ) else x
      }
      ans[i] = t[k - 1][1].toInt()
    }
    return ans
  }
}
