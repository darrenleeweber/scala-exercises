package org.example.bench

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
class IntervalsState10() extends GenerateIntervals() {
  override val arrayLength: Int = 10
}

@State(Scope.Thread)
class IntervalsState100() extends GenerateIntervals() {
  override val arrayLength: Int = 100
}

@State(Scope.Thread)
class IntervalsState1000() extends GenerateIntervals() {
  override val arrayLength: Int = 1000
}


/* Default settings for benchmarks in this class */
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class BenchIntervals {

  @Benchmark
  def skipped10(state: IntervalsState10, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }

  @Benchmark
  def skipped100(state: IntervalsState100, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }

  @Benchmark
  def skipped1000(state: IntervalsState1000, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }


  @Benchmark
  def sorted10(state: IntervalsState10, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.sorted)
  }

  @Benchmark
  def sorted100(state: IntervalsState100, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.sorted)
  }

  @Benchmark
  def sorted1000(state: IntervalsState1000, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.sorted)
  }
}
