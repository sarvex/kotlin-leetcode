internal class Solution {
  private var nums1: IntArray
  private var nums2: IntArray

  fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
    this.nums1 = nums1
    this.nums2 = nums2
    val m = nums1.size
    val n = nums2.size
    val a: Int = max(abs(nums1[0]), abs(nums1[m - 1]))
    val b: Int = max(abs(nums2[0]), abs(nums2[n - 1]))
    var r = a.toLong() * b
    var l = -a.toLong() * b
    while (l < r) {
      val mid = (l + r) shr 1
      if (count(mid) >= k) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun count(p: Long): Long {
    var cnt: Long = 0
    val n = nums2.size
    for (x in nums1) {
      if (x > 0) {
        var l = 0
        var r = n
        while (l < r) {
          val mid = (l + r) shr 1
          if (x.toLong() * nums2[mid] > p) {
            r = mid
          } else {
            l = mid + 1
          }
        }
        cnt += l.toLong()
      } else if (x < 0) {
        var l = 0
        var r = n
        while (l < r) {
          val mid = (l + r) shr 1
          if (x.toLong() * nums2[mid] <= p) {
            r = mid
          } else {
            l = mid + 1
          }
        }
        cnt += (n - l).toLong()
      } else if (p >= 0) {
        cnt += n.toLong()
      }
    }
    return cnt
  }
}
