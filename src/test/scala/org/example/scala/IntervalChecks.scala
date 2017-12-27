package org.example.scala

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object IntervalChecks extends Properties("Interval") {

  property("contains") = forAll { (a:Int, b:Int, x:Int) =>
    val interval = Interval(a, b)
    if (a <= x && x <= b) {
      interval.contains(x)
    } else {
      ! interval.contains(x)
    }
  }

  property("isValid") = forAll { (a:Int, b:Int) =>
    val interval = Interval(a, b)
    if (a <= b) {
      interval.isValid
    } else {
      ! interval.isValid
    }
  }

}