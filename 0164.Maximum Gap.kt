internal class Solution {
  fun maximumGap(nums: IntArray): Int {
    val n = nums.size
    if (n < 2) {
      return 0
    }
    val inf = 0x3f3f3f3f
    var mi = inf
    var mx = -inf
    for (v in nums) {
      mi = min(mi, v)
      mx = max(mx, v)
    }
    val bucketSize: Int = max(1, (mx - mi) / (n - 1))
    val bucketCount = (mx - mi) / bucketSize + 1
    val buckets = Array(bucketCount) { IntArray(2) }
    for (bucket in buckets) {
      bucket[0] = inf
      bucket[1] = -inf
    }
    for (v in nums) {
      val i = (v - mi) / bucketSize
      buckets[i][0] = min(buckets[i][0], v)
      buckets[i][1] = max(buckets[i][1], v)
    }
    var prev = inf
    var ans = 0
    for (bucket in buckets) {
      if (bucket[0] > bucket[1]) {
        continue
      }
      ans = max(ans, bucket[0] - prev)
      prev = bucket[1]
    }
    return ans
  }
}
