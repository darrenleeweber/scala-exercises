package org.example.bench

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
class IntervalsState100() extends GenerateIntervals() {
  override val arrayLength: Int = 100
}
@State(Scope.Thread)
class IntervalsState200() extends GenerateIntervals() {
  override val arrayLength: Int = 200
}
@State(Scope.Thread)
class IntervalsState400() extends GenerateIntervals() {
  override val arrayLength: Int = 400
}
@State(Scope.Thread)
class IntervalsState600() extends GenerateIntervals() {
  override val arrayLength: Int = 600
}
@State(Scope.Thread)
class IntervalsState800() extends GenerateIntervals() {
  override val arrayLength: Int = 800
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
  def skipped100(state: IntervalsState100, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }
  @Benchmark
  def skipped200(state: IntervalsState200, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }
  @Benchmark
  def skipped400(state: IntervalsState400, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }
  @Benchmark
  def skipped600(state: IntervalsState600, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }
  @Benchmark
  def skipped800(state: IntervalsState800, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }
  @Benchmark
  def skipped1000(state: IntervalsState1000, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }

}
