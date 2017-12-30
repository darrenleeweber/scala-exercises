package org.example.bench

import java.util.concurrent.TimeUnit

import org.example.scala.{Interval, IntervalCollection, Intervals}
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Array(Mode.Throughput)) @OutputTimeUnit(TimeUnit.MILLISECONDS)
class BenchIntervals extends BenchIntervalBase {

  override def intervals(randomIntervals: Array[(Int,Int)]): IntervalCollection[Interval] = {
    val intervals = Intervals()
    for(i <- randomIntervals) {
      intervals.update(new Interval(i))
    }
    intervals
  }

}
