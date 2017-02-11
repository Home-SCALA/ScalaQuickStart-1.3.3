package com.learning.scala_slides2

/**
 * @see http://www.ibm.com/developerworks/ru/library/j-scala06278/
 * Массивы в Scala
 * Листинг 4. array.scala
 */
object ArrayExample1 {

  def main(args : Array[String]) : Unit = {
    for (i <- 0 to args.length-1) {
      System.out.println(args(i))
    }
  }

}
