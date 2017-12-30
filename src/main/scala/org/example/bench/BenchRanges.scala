package org.example.bench

import org.example.scala.Ranges

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

@BenchmarkMode(Array(Mode.Throughput)) @OutputTimeUnit(TimeUnit.MILLISECONDS)
class BenchRanges {

  def intervals(randomIntervals: Array[(Int,Int)]): Ranges = {
    val intervals = Ranges()
    for(i <- randomIntervals) {
      intervals.update(Range(i._1, i._2))
    }
    intervals
  }

  @Benchmark
  def skipped100(state: IntervalsState100, blackhole: Blackhole) : Unit = {
    val skipped = intervals(state.randomIntervals).skipped.size
    blackhole.consume(skipped)
  }
  @Benchmark
  def skipped300(state: IntervalsState300, blackhole: Blackhole) : Unit = {
    val skipped = intervals(state.randomIntervals).skipped.size
    blackhole.consume(skipped)
  }
  @Benchmark
  def skipped500(state: IntervalsState500, blackhole: Blackhole) : Unit = {
    val skipped = intervals(state.randomIntervals).skipped.size
    blackhole.consume(skipped)
  }
  @Benchmark
  def skipped700(state: IntervalsState700, blackhole: Blackhole) : Unit = {
    val skipped = intervals(state.randomIntervals).skipped.size
    blackhole.consume(skipped)
  }
  @Benchmark
  def skipped900(state: IntervalsState900, blackhole: Blackhole) : Unit = {
    val skipped = intervals(state.randomIntervals).skipped.size
    blackhole.consume(skipped)
  }
}
