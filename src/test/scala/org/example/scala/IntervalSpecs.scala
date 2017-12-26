package org.example.scala

class IntervalSpecs extends SpecHelper {

  describe("Interval") {
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
        assert(interval.isValid == false)
      }
    }
  }
}
