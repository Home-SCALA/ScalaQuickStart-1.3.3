package com.learning.scala_school.basics2

/**
 * Объекты используются для хранения одного экземпляра класса. Чаще всего они используются с фабриками объектов.
 */
object Timer {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }

  def main(args: Array[String]): Unit = {
    println( Timer.currentCount() )
    println( Timer.currentCount() )
    println( Timer.currentCount() )
  }

}
