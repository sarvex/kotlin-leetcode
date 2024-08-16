internal class Solution {
  fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
    val n = books.size
    val f = IntArray(n + 1)
    for (i in 1..n) {
      var w = books[i - 1][0]
      var h = books[i - 1][1]
      f[i] = f[i - 1] + h
      for (j in i - 1 downTo 1) {
        w += books[j - 1][0]
        if (w > shelfWidth) {
          break
        }
        h = max(h, books[j - 1][1])
        f[i] = min(f[i], f[j - 1] + h)
      }
    }
    return f[n]
  }
}
