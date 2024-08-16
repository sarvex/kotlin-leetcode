class Solution {
  fun computeLPS(pattern: String, lps: IntArray) {
    val M = pattern.length
    var len = 0

    lps[0] = 0

    var i = 1
    while (i < M) {
      if (pattern[i] == pattern[len]) {
        len++
        lps[i] = len
        i++
      } else {
        if (len != 0) {
          len = lps[len - 1]
        } else {
          lps[i] = 0
          i++
        }
      }
    }
  }

  fun KMP_codestorywithMIK(pat: String, txt: String): List<Int> {
    val N = txt.length
    val M = pat.length
    val result: List<Int> = ArrayList()

    val lps = IntArray(M)
    computeLPS(pat, lps)

    var i = 0 // Index for text
    var j = 0 // Index for pattern

    while (i < N) {
      if (pat[j] == txt[i]) {
        i++
        j++
      }

      if (j == M) {
        result.add(i - j) // Pattern found at index i-j+1 (If you have to return 1 Based
        // indexing, that's why added + 1)
        j = lps[j - 1]
      } else if (i < N && pat[j] != txt[i]) {
        if (j != 0) {
          j = lps[j - 1]
        } else {
          i++
        }
      }
    }

    return result
  }

  private fun lowerBound(list: List<Int>, target: Int): Int {
    var left = 0
    var right: Int = list.size() - 1
    var result: Int = list.size()

    while (left <= right) {
      val mid = left + (right - left) / 2

      if (list[mid] >= target) {
        result = mid
        right = mid - 1
      } else {
        left = mid + 1
      }
    }

    return result
  }

  fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
    val n = s.length

    val i_indices = KMP_codestorywithMIK(a, s)
    val j_indices = KMP_codestorywithMIK(b, s)

    val result: List<Int> = ArrayList()

    for (i in i_indices) {
      val left_limit: Int = max(0, i - k) // To avoid out of bound -> I used max(0, i-k)
      val right_limit
          : Int = min(n - 1, i + k) // To avoid out of bound -> I used min(n-1, i+k)

      val lowerBoundIndex = lowerBound(j_indices, left_limit)

      if (lowerBoundIndex < j_indices.size()
        && j_indices[lowerBoundIndex] <= right_limit
      ) {
        result.add(i)
      }
    }

    return result
  }
}
