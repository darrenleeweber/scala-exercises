package org.example.scala

/**
  * An interval collection
  */
trait IntervalCollection[T] {

  /**
    * Build a sequence of skipped T
    * @return Seq[T]
    */
  def skipped : Seq[T]

  /**
    * Sort a sequence of T
    * @return Seq[T]
    */
  def sorted : Seq[T]

  /**
    * Append a T
    * @param value is a T
    */
  def update(value:T) : Unit
}
