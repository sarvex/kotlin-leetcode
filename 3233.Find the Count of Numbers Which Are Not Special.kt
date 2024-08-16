import java.util.*

internal class Solution {
  fun nonSpecialCount(l: Int, r: Int): Int {
    val lo = ceil(sqrt(l)) as Int
    val hi = floor(sqrt(r)) as Int
    var cnt = 0
    for (i in lo..hi) {
      if (Solution.Companion.primes.get(i)) {
        cnt++
      }
    }
    return r - l + 1 - cnt
  }

  companion object {
    var m: Int = 31623
    var primes: BooleanArray = BooleanArray(Solution.Companion.m + 1)

    init {
      Arrays.fill(Solution.Companion.primes, true)
      Solution.Companion.primes.get(1) = false
      Solution.Companion.primes.get(0) = Solution.Companion.primes.get(1)
      for (i in 2..Solution.Companion.m) {
        if (Solution.Companion.primes.get(i)) {
          var j = i + i
          while (j <= Solution.Companion.m) {
            Solution.Companion.primes.get(j) = false
            j += i
          }
        }
      }
    }
  }
}
