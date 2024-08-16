import java.util.*

internal class Hashing(word: String, base: Long, mod: Int) {
  private val p: LongArray
  private val h: LongArray
  private val mod: Long

  init {
    val n = word.length
    p = LongArray(n + 1)
    h = LongArray(n + 1)
    p[0] = 1
    this.mod = mod.toLong()
    for (i in 1..n) {
      p[i] = p[i - 1] * base % mod
      h[i] = (h[i - 1] * base + word[i - 1].code.toLong()) % mod
    }
  }

  fun query(l: Int, r: Int): Long {
    return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod
  }
}

internal class Solution {
  fun minimumCost(target: String, words: Array<String>, costs: IntArray): Int {
    val base = 13331
    val mod = 998244353
    val inf: Int = MAX_VALUE / 2

    val n = target.length
    val hashing = Hashing(target, base.toLong(), mod)

    val f = IntArray(n + 1)
    Arrays.fill(f, inf)
    f[0] = 0

    val ss: TreeSet<Int> = TreeSet()
    for (w in words) {
      ss.add(w.length)
    }

    val d: Map<Long, Int> = HashMap()
    for (i in words.indices) {
      var x: Long = 0
      for (c in words[i].toCharArray()) {
        x = (x * base + c.code.toLong()) % mod
      }
      d.merge(x, costs[i]) { a: Int, b: Int -> Integer.min(a, b) }
    }

    for (i in 1..n) {
      for (j in ss) {
        if (j > i) {
          break
        }
        val x = hashing.query(i - j + 1, i)
        f[i] = Math.min(f[i], f[i - j] + d.getOrDefault(x, inf))
      }
    }

    return if (f[n] >= inf) -1 else f[n]
  }
}
