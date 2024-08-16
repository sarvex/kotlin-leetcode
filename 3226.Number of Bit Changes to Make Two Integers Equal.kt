internal class Solution {
  fun minChanges(n: Int, k: Int): Int {
    return if ((n and k) != k) -1 else Integer.bitCount(n xor k)
  }
}
