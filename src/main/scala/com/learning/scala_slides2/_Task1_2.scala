//package com.learning.scala_slides2
//
///**
// * Используя рекурсивную функцию, написать программу, распечатывающую треугольник Паскаля
// * Количество строк в треугольнике передается в виде первого аргумента. Используйте метод toInt() для преобразования строки в число: val n = "3".toInt
// * ВАЖНО: постарайтесь написать чистый функциональный код, не использующий циклов, mutable переменных и return
// * -------------
// * 1
// * 1 1
// * 1 2 1
// * 1 2 3 3 2 1
// * 1 2 3 4 5 5 4 3 2 1
// * 1 2 3 4 5 6 6 5 4 3 2 1
// * --------------
// * С использованием функции связаны 3-и понятия:
// * 1. объявление функции (прототип);
// * 2. определение функции (реализация);
// * 3. вызов функции;
// */
//object Task1_2 {
//
//  def main(args: Array[String]): Unit = {
//    val size = 3
//
//    //    funcPrint(size)
//    func2(size, typePrint2)
//  }
//
//
//  /* (2) определение функции-1 */
//  private def straightPrint(index: Int, item: Int): Int = {
//    print( index + " " )
//    if (index<item) straightPrint(index+1, item)
//    0
//  }
//  /* (1) псевдо-объявление функции */
//  val typeStraightPrint: (Int, Int) => Int = straightPrint
//
//  /* (2) определение функции-2 */
//  private def reversePrint(item: Int): Int = {
//    print( item + " " )
//    if (0<item) reversePrint(item-1)
//    0
//  }
//  /* (1) псевдо-объявление функции */
//  val typeReversePrint: (Int) => Int = reversePrint
//
//  //  def straightReversePrint(size: Int) {
//  //    /* (3) вызов функции-1,2 */
//  //    straightPrint(0, size)
//  //    reversePrint(size)
//  //    println()
//  //  }
//  /* (2) определение функции-3 */
//  def straightReversePrint2(size: Int, funcStraight: ((Int, Int) => Int), funcReverse: ((Int) => Int)) = {
//    /* (3) вызов функции-1,2 */
//    funcStraight(0, size)
//    funcReverse(size)
//    println()
//  }
//
//  //  def funcPrint(size: Int) {
//  //    def func(index: Int, item: Int): Int = {
//  ////      straightReversePrint(index)
//  //      straightReversePrint2(index, typeStraightPrint, typeReversePrint)
//  //      if (index<item) func(index+1, item)
//  //      0
//  //    }
//  //
//  //    func(0, size)
//  //  }
//
//  private def print2(index: Int, item: Int): Int = {
//    straightReversePrint2(index, typeStraightPrint, typeReversePrint)
//    if (index<item) print2(index+1, item)
//    0
//  }
//  val typePrint2: (Int, Int) => Int = print2
//
//  def func2(size: Int, func: ((Int, Int) => Int)) = {
//    func(0, size)
//  }
//
//}
