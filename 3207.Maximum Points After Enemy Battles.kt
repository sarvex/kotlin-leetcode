import java.util.*

internal class Solution {
  fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
    var currentEnergy = currentEnergy
    Arrays.sort(enemyEnergies)
    if (currentEnergy < enemyEnergies[0]) {
      return 0
    }
    var ans: Long = 0
    for (i in enemyEnergies.indices.reversed()) {
      ans += (currentEnergy / enemyEnergies[0]).toLong()
      currentEnergy %= enemyEnergies[0]
      currentEnergy += enemyEnergies[i]
    }
    return ans
  }
}
