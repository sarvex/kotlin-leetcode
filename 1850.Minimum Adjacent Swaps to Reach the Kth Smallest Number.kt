internal class Solution {
  fun getMinSwaps(num: String, k: Int): Int {
    val s: CharArray = num.toCharArray()
    for (i in 0 until k) {
      nextPermutation(s)
    }
    val d: Array<List<Int>> = arrayOfNulls(10)
    Arrays.setAll(d) { i -> ArrayList() }
    val n = s.size
    for (i in 0 until n) {
      d[num[i].code - '0'.code].add(i)
    }
    val idx = IntArray(10)
    val arr = IntArray(n)
    for (i in 0 until n) {
      arr[i] = d[s[i].code - '0'.code][idx[s[i].code - '0'.code]++]
    }
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until i) {
        if (arr[j] > arr[i]) {
          ++ans
        }
      }
    }
    return ans
  }

  private fun nextPermutation(nums: CharArray): Boolean {
    val n = nums.size
    var i = n - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      --i
    }
    if (i < 0) {
      return false
    }
    var j = n - 1
    while (j >= 0 && nums[i] >= nums[j]) {
      --j
    }
    swap(nums, i++, j)
    j = n - 1
    while (i < j) {
      swap(nums, i, j)
      ++i
      --j
    }
    return true
  }

  private fun swap(nums: CharArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
