package org.example.scala

class IntervalsSpecs extends SpecHelper {

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

  def intervals : Intervals = {
    val intervals = Intervals()
    for(tuple <- stream) {
      intervals.update(Interval(tuple._1, tuple._2))
    }
    intervals
  }

  describe("Intervals") {
    describe("with interval stream") {
      // inclusive intervals
      // sorted:  List(Interval(2,6), Interval(4,7), Interval(8,9), Interval(9,12), Interval(10,11), Interval(18,21))
      // skipped: List(Interval(12,17))
      it("sorts intervals") {
        val sorted = intervals.sorted
        assert(sorted.head == Interval( 2, 6)) // scalastyle:ignore
        assert(sorted.last == Interval(18,21)) // scalastyle:ignore
      }
      it("finds skipped intervals") {
        val skipped = intervals.skipped
        assert(skipped.head == Interval(12,17)) // scalastyle:ignore
      }
    }
  }
}
