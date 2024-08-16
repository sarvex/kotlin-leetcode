internal class Solution {
  fun longestString(x: Int, y: Int, z: Int): Int {
    if (x < y) {
      return (x * 2 + z + 1) * 2
    }
    if (x > y) {
      return (y * 2 + z + 1) * 2
    }
    return (x + y + z) * 2
  }
}
