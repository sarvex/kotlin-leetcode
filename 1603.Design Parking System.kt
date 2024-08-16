internal class ParkingSystem(big: Int, medium: Int, small: Int) {
  private val cnt = intArrayOf(0, big, medium, small)

  fun addCar(carType: Int): Boolean {
    if (cnt[carType] == 0) {
      return false
    }
    --cnt[carType]
    return true
  }
}
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
