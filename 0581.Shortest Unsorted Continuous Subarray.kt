internal class Solution {
  fun findUnsortedSubarray(nums: IntArray): Int {
    val arr = nums.clone()
    Arrays.sort(arr)
    var l = 0
    var r = arr.size - 1
    while (l <= r && nums[l] == arr[l]) {
      l++
    }
    while (l <= r && nums[r] == arr[r]) {
      r--
    }
    return r - l + 1
  }
}
