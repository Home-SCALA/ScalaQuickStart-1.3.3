package com.learning.scala_slides2

/**
 * Область видимости
 */
object Source6 {

  def main(args: Array[String]): Unit = {
    println( "factorial vs 5 = " + factorial(5) )

    println( "combination vs 3,4 = " + combination(3, 4) )
//    println( fact(10) ) // compile error
  }

  /* Вспомним рекурсию: */
  def factorial(x: Int): Int = if(x==0) 1 else x*factorial(x-1)

  /* Посчитаем число сочетаний из 'n' элементов по 'm' элементов: */
  def combination(m: Int, n: Int) = {
    def fact(x: Int): Int = if(x==0) 1 else x*fact(x-1)

    fact(n) / (fact(m) * fact(n-m))
  }

}
