package org.example.scala

class RangesSpecs extends SpecHelper {

  def stream : List[(Int, Int)] = {
    List[(Int, Int)](
      (2, 6),
      (9, 12),
      (8, 9),
      (18, 21),
      (4, 7),
      (10, 11)
    )
  }

  def ranges : Ranges = {
    val ranges = Ranges()
    for(tuple <- stream) {
      ranges.update(Range(tuple._1, tuple._2))
    }
    ranges
  }

  describe("Ranges") {
    describe("with interval stream") {
      // Open ended intervals, i.e. [a, b)
      // Range(2,6).toList -> List(2, 3, 4, 5)
      // sorted:  List(Range 2 until 6, Range 4 until 7, Range 8 until 9, Range 9 until 12, Range 10 until 11, Range 18 until 21)
      // skipped: List(Range 7 until 8, Range 11 until 18)
      it("sorts ranges") {
        val sorted = ranges.sorted
        assert(sorted.head == Range( 2, 6)) // scalastyle:ignore
        assert(sorted.last == Range(18,21)) // scalastyle:ignore
      }
      it("finds skipped ranges") {
        val skipped = ranges.skipped
        assert(skipped.head == Range( 7, 8)) // scalastyle:ignore
        assert(skipped.last == Range(11,18)) // scalastyle:ignore
      }
    }
  }
}
