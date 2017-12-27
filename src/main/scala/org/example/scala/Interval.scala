package org.example.scala

/**
  * An inclusive interval, i.e. [a, a] denotes the set {a}
  * Note - the scala Range is not inclusive, it's [a, b)
  * @param start - start of the interval (inclusive)
  * @param end - end of the interval (inclusive)
  */
case class Interval(start:Int, end:Int) {

  /**
    * start <= x <= end
    * @return boolean
    */
  def contains(x:Int) : Boolean = {
    start <= x && x <= end
  }

  /**
    * isValid when start <= end
    * @return boolean
    */
  def isValid : Boolean = {
    start <= end
  }

  def canEqual(a:Any) : Boolean = a.isInstanceOf[Interval]

  override def equals(that:Any) : Boolean =
    that match {
      case that: Interval => that.canEqual(this) && this.hashCode == that.hashCode
      case _ => false
    }

  override def hashCode : Int = {
    val prime = 31
    prime + start + end
  }

  /**
    * Range(start, end + 1)
    * @return Range
    */
  def toRange : Range = Range(start, end + 1)

}
