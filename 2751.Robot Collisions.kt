import java.util.*

internal class Solution {
  fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
    val n = positions.size
    val indices: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      indices[i] = i
    }

    Arrays.sort(indices) { i, j -> Integer.compare(positions[i], positions[j]) }

    val stack: Stack<Int> = Stack()

    for (currentIndex in indices) {
      if (directions[currentIndex] == 'R') {
        stack.push(currentIndex)
      } else {
        while (!stack.isEmpty() && healths[currentIndex] > 0) {
          val topIndex: Int = stack.pop()

          if (healths[topIndex] > healths[currentIndex]) {
            healths[topIndex] -= 1
            healths[currentIndex] = 0
            stack.push(topIndex)
          } else if (healths[topIndex] < healths[currentIndex]) {
            healths[currentIndex] -= 1
            healths[topIndex] = 0
          } else {
            healths[currentIndex] = 0
            healths[topIndex] = 0
          }
        }
      }
    }

    val result: List<Int> = ArrayList()
    for (health in healths) {
      if (health > 0) {
        result.add(health)
      }
    }

    return result
  }
}
