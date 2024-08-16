internal class Solution {
  fun losingPlayer(x: Int, y: Int): String {
    var x = x
    var y = y
    val k: Int = min(x / 2, y / 8)
    x -= k * 2
    y -= k * 8
    return if (x > 0 && y >= 4) "Alice" else "Bob"
  }
}
