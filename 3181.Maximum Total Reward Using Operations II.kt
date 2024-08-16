import java.math.BigInteger
import java.util.*

internal class Solution {
  fun maxTotalReward(rewardValues: IntArray): Int {
    val nums = Arrays.stream(rewardValues).distinct().sorted().toArray()
    var f = BigInteger.ONE
    for (v in nums) {
      val mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE)
      val shifted = f.and(mask).shiftLeft(v)
      f = f.or(shifted)
    }
    return f.bitLength() - 1
  }
}
