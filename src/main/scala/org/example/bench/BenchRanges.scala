package org.example.bench

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Thread)
class RangesState10() extends GenerateRanges() {
  override val arrayLength: Int = 10
}

@State(Scope.Thread)
class RangesState100() extends GenerateRanges() {
  override val arrayLength: Int = 100
}

@State(Scope.Thread)
class RangesState1000() extends GenerateRanges() {
  override val arrayLength: Int = 1000
}


/* Default settings for benchmarks in this class */
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class BenchRanges {

  @Benchmark
  def skipped10(state: RangesState10, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }

  @Benchmark
  def skipped100(state: RangesState100, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }

  @Benchmark
  def skipped1000(state: RangesState1000, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.skipped)
  }


  @Benchmark
  def sorted10(state: RangesState10, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.sorted)
  }

  @Benchmark
  def sorted100(state: RangesState100, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.sorted)
  }

  @Benchmark
  def sorted1000(state: RangesState1000, blackhole: Blackhole) : Unit = {
    blackhole.consume(state.intervals.sorted)
  }
}
