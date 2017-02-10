package com.learning.scala_slides2

import scala.annotation.tailrec

/**
 * Цикл foreach
 */
object Source7 {

  def main(args: Array[String]): Unit = {
    val iArgs: Array[Int] = Array( 10,20,30,40,50,60,70,80,90,100 )

    /* Внутри for разворачивается в декларативную конструкцию... (от меньшего к большему) */
    for (iArg <- iArgs) print(iArg + " ")

    println()
    /* Цикл for с явным указанием границ итерации... (от меньшего к большему) */
    for (i <- 0 to iArgs.length-1) print(iArgs(i) + " ")

    println()
    /* Цикл while и do ... while (нет встроенных ++ и --) */
    var i = 0
    while (i<iArgs.length) { print(iArgs(i) + " "); i = i+1 }

    println()
    /* Хвостовая рекурсия */
    printArr(iArgs, 0)

    println()
    /* Вызываем функцию для всех элементов: */
    iArgs.foreach(x => print(x + " "))
    println()
    /* неформатированный вывод: */
    iArgs.foreach(print _)
    println()
    iArgs.foreach(print)

    println()
    /* Вызываем функцию для всех индексов: */
    (0 to iArgs.length-1).foreach(i => print(iArgs(i) + " "))


    println()
    println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
    println( sum(fX,2,5) )
    println( sumInts(2,5) ) /* #1 */
    println( sumSquares(2,5) ) /* #2 */
    println( sumPowersOfTwo(2,5) ) /* #3 */
  }

  /**
   * Хвостовая рекурсия
   * ******************
   * @see http://ccfit.nsu.ru/~den/Scala/scala_slides2.pdf
   */
  def printArr(arr: Array[Int], pos: Int) { //@tailrec def printArr(arr: Array[Int], pos: Int) {
    if (pos<arr.length) { print(arr(pos) + " "); printArr(arr, pos+1) }
  }


  /**
   * Функции первого класса (функции высшего порядка)
   * ************************************************
   * @see https://ru.wikibooks.org/wiki/Scala_в_примерах
   *
   * (Функции в Scala являются "значениями первого класса")
   * Функции которые принимают другие функции в качестве параметров или возвращают их как результаты, называются - "функциями высшего порядка"
   */
  def fX(a: Int) = a
  /* Тип Int => Int — это тип функции, которая принимает аргумент типа Int и возвращает результат типа Int */
  /* sum — функция высшего порядка, берущая в качестве параметра другую функцию */
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  /* #1 Написать функцию для суммирования всех целых чисел между двумя данными числами a и b */
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  /* #2 Написать функцию для суммирования квадратов всех целых чисел между двумя данными числами a и b */
  def square(x: Int): Int = x * x
  def sumSquares(a: Int, b: Int): Int =
    if (a > b) 0 else square(a) + sumSquares(a + 1, b)

  /* #3. Написать функцию для суммирования степеней двойки 2n для всех целых чисел между двумя данными числами a и b */
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
  def sumPowersOfTwo(a: Int, b: Int): Int =
    if (a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)

  /**
   * "Каррирование" - Функций, возвращающие функции: эквивалентно предыдущему, но оно короче
   * ************************************************
   * @see https://ru.wikibooks.org/wiki/Scala_в_примерах
   */
}
