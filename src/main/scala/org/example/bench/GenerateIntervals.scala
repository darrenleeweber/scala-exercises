package org.example.bench

import org.example.scala.{Interval, Intervals}

import org.openjdk.jmh.annotations.{State, Scope}

@State(Scope.Thread)
class GenerateIntervals() {
  val arrayLength: Int = 5
  val ArrayIntPlus: Int = 20

  def intervals: Intervals = {
    val intervals = Intervals()
    for(i <- randomIntervals) { intervals.update(i) }
    intervals
  }

  def randomIntervals: Array[Interval] = {
    GenerateArray(arrayLength).randomArray.map { a =>
      val b = a + util.Random.nextInt(ArrayIntPlus)
      Interval(a, b)
    }
  }
}
