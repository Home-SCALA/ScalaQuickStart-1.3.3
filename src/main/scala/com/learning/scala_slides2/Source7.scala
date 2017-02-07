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
  }

  @tailrec def printArr(arr: Array[Int], pos: Int) {
    if (pos<arr.length) { print(arr(pos) + " "); printArr(arr, pos+1) }
  }
}
