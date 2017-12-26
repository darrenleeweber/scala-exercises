package org.example.scala

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object IntervalChecks extends Properties("Interval") {

  property("isValid") = forAll { (a:Int, b:Int) =>
    val interval = Interval(a, b)
    if (a <= b) {
      interval.isValid
    } else {
      ! interval.isValid
    }
  }

}