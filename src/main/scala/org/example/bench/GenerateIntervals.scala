package org.example.bench

import org.openjdk.jmh.annotations.{State, Scope}

@State(Scope.Thread)
class GenerateIntervals() {
  val arrayLength: Int = 5
  val arrayIntPlus: Int = 20
  val arrayIntRange: Int = 1000

  def randomArray: Array[Int] = GenerateArray(arrayLength, arrayIntRange).randomArray

  def randomIntervals: Array[(Int,Int)] = randomArray.map { a => (a, a + util.Random.nextInt(arrayIntPlus)) }
}

@State(Scope.Thread)
class IntervalsState100() extends GenerateIntervals() {
  override val arrayLength: Int = 100
}

@State(Scope.Thread)
class IntervalsState300() extends GenerateIntervals() {
  override val arrayLength: Int = 300
}

@State(Scope.Thread)
class IntervalsState500() extends GenerateIntervals() {
  override val arrayLength: Int = 500
}

@State(Scope.Thread)
class IntervalsState700() extends GenerateIntervals() {
  override val arrayLength: Int = 700
}

@State(Scope.Thread)
class IntervalsState900() extends GenerateIntervals() {
  override val arrayLength: Int = 900
}

