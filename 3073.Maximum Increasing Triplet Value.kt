internal class Solution {
  fun maximumTripletValue(nums: IntArray): Int {
    val n = nums.size
    val right = IntArray(n)
    right[n - 1] = nums[n - 1]
    for (i in n - 2 downTo 0) {
      right[i] = max(nums[i], right[i + 1])
    }
    val ts: TreeSet<Int> = TreeSet()
    ts.add(nums[0])
    var ans = 0
    for (j in 1 until n - 1) {
      if (right[j + 1] > nums[j]) {
        val it: Int = ts.lower(nums[j])
        if (it != null) {
          ans = max(ans, it - nums[j] + right[j + 1])
        }
      }
      ts.add(nums[j])
    }
    return ans
  }
}
