package org.example.bench

import org.example.scala.Ranges
import org.openjdk.jmh.annotations.{Scope, State}

@State(Scope.Thread)
class GenerateRanges() {
  val arrayLength: Int = 5
  val ArrayIntPlus: Int = 20

  def intervals: Ranges = {
    val intervals = Ranges()
    for(i <- randomRanges) { intervals.update(i) }
    intervals
  }

  def randomRanges: Array[Range] = {
    GenerateArray(arrayLength).randomArray.map { a =>
      val b = a + util.Random.nextInt(ArrayIntPlus)
      Range(a, b)
    }
  }
}
