package org.example.scala

class ArrayUniqueSubarraysSpecs extends SpecHelper {

 /*
  * ## Sample Input
  * 1 2 3 4 5
  * ## Sample Output
  * 35
  *
  * Sample Case 1: Since, all integers are distinct within any contiguous
  * subarray, therefore the unique weight will be the summation of lengths of all
  * subarrays. Hence, this sums up to 5 + 4*2 + 3*3 + 2*4 + 1*5 = 35
  */

  describe("ArrayUniqueSubarrays.sum") {
    describe("with (1 2 3 4 5)") {
      it("returns 35") {
        val arr = Array(1, 2, 3, 4, 5) // scalastyle:ignore
        val sum = ArrayUniqueSubarrays().sum(arr)
        assert(sum == 35)
      }
    }
  }
}
