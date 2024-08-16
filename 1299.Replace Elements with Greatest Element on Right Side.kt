internal class Solution {
  fun replaceElements(arr: IntArray): IntArray {
    var i = arr.size - 1
    var max = -1
    while (i >= 0) {
      val t = arr[i]
      arr[i] = max
      max = max(max, t)
      --i
    }
    return arr
  }
}
