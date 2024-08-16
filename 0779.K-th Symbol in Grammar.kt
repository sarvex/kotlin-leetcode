internal class Solution {
  fun kthGrammar(n: Int, k: Int): Int {
    if (n == 1) {
      return 0
    }
    if (k <= (1 shl (n - 2))) {
      return kthGrammar(n - 1, k)
    }
    return kthGrammar(n - 1, k - (1 shl (n - 2))) xor 1
  }
}
