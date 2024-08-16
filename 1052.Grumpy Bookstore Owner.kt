internal class Solution {
  fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var cnt = 0
    var tot = 0
    for (i in 0 until minutes) {
      cnt += customers[i] * grumpy[i]
      tot += customers[i] * (grumpy[i] xor 1)
    }
    var mx = cnt
    val n = customers.size
    for (i in minutes until n) {
      cnt += customers[i] * grumpy[i]
      cnt -= customers[i - minutes] * grumpy[i - minutes]
      mx = max(mx, cnt)
      tot += customers[i] * (grumpy[i] xor 1)
    }
    return tot + mx
  }
}
