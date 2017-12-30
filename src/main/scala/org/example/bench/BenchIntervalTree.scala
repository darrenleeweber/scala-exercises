package org.example.bench

import org.example.scala.{Interval, IntervalCollection, IntervalTree}

class BenchIntervalTree extends BenchIntervalBase {

  override def intervals(randomIntervals: Array[(Int,Int)]): IntervalCollection[Interval] = {
    val intervals = IntervalTree()
    for(i <- randomIntervals) {
      intervals.update(new Interval(i))
    }
    intervals
  }
}
