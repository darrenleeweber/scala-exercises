package org.example.scala

class IntervalSpecs extends SpecHelper {


  describe("Interval.constructor with Tuple2") {
    describe("with (1, 2)") {
      it("contains 1 is true") {
        val interval = new Interval((1, 2))
        assert(interval.contains(1))
      }
    }
  }

  describe("Interval.contains") {
    describe("with (1, 2)") {
      it("contains 1 is true") {
        val interval = Interval(1, 2)
        assert(interval.contains(1))
      }
      it("contains 0 is false") {
        val interval = Interval(1, 2)
        assert(! interval.contains(0))
      }
    }
  }

  describe("Interval.isValid") {
    describe("with (1, 1)") {
      it("isValid is true") {
        val interval = Interval(1, 1)
        assert(interval.isValid)
      }
    }
    describe("with (1, 2)") {
      it("isValid is true") {
        val interval = Interval(1, 2)
        assert(interval.isValid)
      }
    }
    describe("with (2, 1)") {
      it("isValid is false") {
        val interval = Interval(2, 1)
        assert(!interval.isValid)
      }
    }
  }

  describe("Interval.toRange") {
    describe("with (1, 2)") {
      it("equals Range(1,3)") {
        val interval = Interval(1, 2)
        assert(interval.toRange == Range(1,3))
      }
    }
  }

}
