import java.util.*

internal class Solution {
  fun secondGreaterElement(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    val arr = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(nums[i], i)
    }
    Arrays.sort(arr) { a, b -> if (a[0] === b[0]) a[1] - b[1] else b[0] - a[0] }
    val ts: TreeSet<Int> = TreeSet()
    for (pair in arr) {
      val i = pair[1]
      val j: Int = ts.higher(i)
      if (j != null && ts.higher(j) != null) {
        ans[i] = nums[ts.higher(j)]
      }
      ts.add(i)
    }
    return ans
  }
}
