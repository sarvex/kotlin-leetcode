import java.util.*

internal class PrimeTable(n: Int) {
  private val prime = BooleanArray(n + 1)

  init {
    Arrays.fill(prime, true)
    prime[0] = false
    prime[1] = false
    for (i in 2..n) {
      if (prime[i]) {
        var j = i + i
        while (j <= n) {
          prime[j] = false
          j += i
        }
      }
    }
  }

  fun isPrime(x: Int): Boolean {
    return prime[x]
  }
}

internal class UnionFind(n: Int) {
  private val p = IntArray(n)
  private val size = IntArray(n)

  init {
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  fun union(a: Int, b: Int): Boolean {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return false
    }
    if (size[pa] > size[pb]) {
      p[pb] = pa
      size[pa] += size[pb]
    } else {
      p[pa] = pb
      size[pb] += size[pa]
    }
    return true
  }

  fun size(x: Int): Int {
    return size[find(x)]
  }
}

internal class Solution {
  fun countPaths(n: Int, edges: Array<IntArray>): Long {
    val g: Array<List<Int>> = arrayOfNulls(n + 1)
    Arrays.setAll(g) { i -> ArrayList() }
    val uf = UnionFind(n + 1)
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
      if (!Solution.Companion.PT.isPrime(u) && !Solution.Companion.PT.isPrime(v)) {
        uf.union(u, v)
      }
    }
    var ans: Long = 0
    for (i in 1..n) {
      if (Solution.Companion.PT.isPrime(i)) {
        var t: Long = 0
        for (j in g[i]) {
          if (!Solution.Companion.PT.isPrime(j)) {
            val cnt: Long = uf.size(j).toLong()
            ans += cnt
            ans += cnt * t
            t += cnt
          }
        }
      }
    }
    return ans
  }

  companion object {
    private val PT = PrimeTable(100010)
  }
}
