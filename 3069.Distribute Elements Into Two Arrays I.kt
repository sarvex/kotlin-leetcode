internal class Solution {
  fun resultArray(nums: IntArray): IntArray {
    val n = nums.size
    val arr1 = IntArray(n)
    val arr2 = IntArray(n)
    arr1[0] = nums[0]
    arr2[0] = nums[1]
    var i = 0
    var j = 0
    for (k in 2 until n) {
      if (arr1[i] > arr2[j]) {
        arr1[++i] = nums[k]
      } else {
        arr2[++j] = nums[k]
      }
    }
    for (k in 0..j) {
      arr1[++i] = arr2[k]
    }
    return arr1
  }
}
