internal class Solution {
  fun minimumPerimeter(neededApples: Long): Long {
    var x: Long = 1
    while (2 * x * (x + 1) * (2 * x + 1) < neededApples) {
      ++x
    }
    return 8 * x
  }
}
