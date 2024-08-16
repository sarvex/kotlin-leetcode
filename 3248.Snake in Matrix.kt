internal class Solution {
  fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
    var x = 0
    var y = 0
    for (c in commands) {
      when (c.charAt(0)) {
        'U' -> x--
        'D' -> x++
        'L' -> y--
        'R' -> y++
      }
    }
    return x * n + y
  }
}
