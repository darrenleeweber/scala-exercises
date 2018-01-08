package org.example.scala

import org.scalacheck.Prop.{forAll, throws}
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Test.Parameters

object FactorialChecks extends Properties("Factorial") {

  private val smallMin = -1

  // Factorial.recursive(n) hits stack overflow exceptions, so
  // limit the range of inputs to -1 to 100
  private val smallMax = 1000
  private val smallInteger = Gen.choose(smallMin, smallMax)
  property("recursive") = forAll(smallInteger) { (n:Int) =>
    if(n < 0) {
      throws(classOf[ArithmeticException]) {
        Factorial.recursive(n)
      }
    } else if(n == 0 || n == 1) {
      Factorial.recursive(n) == 1
    } else {
      Factorial.recursive(n).isInstanceOf[BigInt]
    }
  }

  // limit the range of inputs to -1 to 1000
  private val biggerMax = 5000
  private val biggerInteger = Gen.choose(smallMin, biggerMax)
  property("recursiveTail") = forAll(biggerInteger) { (n:Int) =>
    if(n < 0) {
      throws(classOf[ArithmeticException]) {
        Factorial.recursiveTail(n)
      }
    } else if(n == 0 || n == 1) {
      Factorial.recursiveTail(n) == 1
    } else {
      Factorial.recursiveTail(n).isInstanceOf[BigInt]
    }
  }

}