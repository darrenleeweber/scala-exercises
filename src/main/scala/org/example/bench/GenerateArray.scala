package org.example.bench

import org.openjdk.jmh.annotations.{State, Scope}

@State(Scope.Thread)
case class GenerateArray(arrayLength:Int, arrayIntRange: Int) {
  def randomArray: Array[Int] = {
    Array.fill(arrayLength)(util.Random.nextInt(arrayIntRange))
  }
}
