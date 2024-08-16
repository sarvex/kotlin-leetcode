internal class Solution {
  fun wateringPlants(plants: IntArray, capacity: Int): Int {
    var ans = 0
    var water = capacity
    for (i in plants.indices) {
      if (water >= plants[i]) {
        water -= plants[i]
        ans += 1
      } else {
        water = capacity - plants[i]
        ans += i * 2 + 1
      }
    }
    return ans
  }
}
