package com.learning.scala_slides2

/**
 * Используя рекурсивную функцию, написать программу, распечатывающую треугольник Паскаля
 * Количество строк в треугольнике передается в виде первого аргумента. Используйте метод toInt() для преобразования строки в число: val n = "3".toInt
 * ВАЖНО: постарайтесь написать чистый функциональный код, не использующий циклов, mutable переменных и return
 * -------------
 * 1
 * 1 1
 * 1 2 1
 * 1 2 3 3 2 1
 * 1 2 3 4 5 5 4 3 2 1
 * 1 2 3 4 5 6 6 5 4 3 2 1
 * --------------
 * С использованием функции связаны 3-и понятия:
 * 1. объявление функции (прототип);
 * 2. определение функции (реализация);
 * 3. вызов функции;
 */
object Task1_2{

  def main(args: Array[String]): Unit = {
    val data: Int = 3
    myPrint(data, typeMyPrint1) /* (3) вызов функции-5 */
    myPrint(data, typeMyPrint2)
    println()
    myPrint(data, typeMyPrint3)
    myPrint(data, typeMyPrint4)
  }


  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * реализация программы распечатывающую треугольник Паскаля
   */

  /* (2) определение функции-1 */
  private def straightPrint(index: Int, item: Int): Int = {
    print( index + " " )
    if (index<item) straightPrint(index+1, item)
    0
  }
  val typeStraightPrint: (Int, Int) => Int = straightPrint /* (1) объявление функции-1 */

  /* (2) определение функции-2 */
  private def reversePrint(item: Int): Int = {
    print( item + " " )
    if (0<item) reversePrint(item-1)
    0
  }
  val typeReversePrint: (Int) => Int = reversePrint /* (1) объявление функции-2 */

  /*
   * варианты вызова печати...
   * ( список параметров для функции является сложный - с таким тяжело в коде проэкта работать... )
   */
  /* (моя перегруженная функция...) */
  /* (2) определение функции-3 */
  def straightReverse(size: Int, funcStraight: ((Int, Int) => Int), funcReverse: ((Int) => Int)) = {
    /* (3) вызов функции-1,2 */
    funcStraight(0, size)
    funcReverse(size)
    println()
  }
  def straightReverse(size: Int, funcReverse: ((Int) => Int), funcStraight: ((Int, Int) => Int)) = {
    funcReverse(size)
    funcStraight(0, size)
    println()
  }


  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*
   * Например я хочу написать универсальную функцию которая будет уметь печатать...с возможностью опционально изменять шаблоны печати
   * ***********
   * Здесь логика которая опционально управляет вариантами печати - легко работать в коде проэкта...
   */

  /* (мои шаблонные функции) */
  /* (2) определение функции-4 */
  private def myPrint1(index: Int, item: Int): Int = {
    straightReverse(index, typeStraightPrint, typeReversePrint) /* (3) вызов функции-3 */
    if (index<item) myPrint1(index+1, item)
    0
  }
  private def myPrint2(index: Int, item: Int): Int = {
    straightReverse(index, typeReversePrint, typeStraightPrint)
    if (index<item) myPrint2(index+1, item)
    0
  }
  private def myPrint3(item: Int): Int = {
    straightReverse(item, typeStraightPrint, typeReversePrint)
    if (0<item) myPrint3(item-1)
    0
  }
  private def myPrint4(item: Int): Int = {
    straightReverse(item, typeReversePrint, typeStraightPrint)
    if (0<item) myPrint4(item-1)
    0
  }

  /* (мои шаблонны) */
  /* (1) объявление функции-4 */
  val typeMyPrint1: (Int, Int) => Int = myPrint1
  val typeMyPrint2: (Int) => Int = myPrint3
  val typeMyPrint3: (Int) => Int = myPrint4
  val typeMyPrint4: (Int, Int) => Int = myPrint2

  /* (моя перегруженная функция...) */
  /* (2) определение функции-5 */
  def myPrint(size: Int, func: ((Int, Int) => Int)) = func(0, size)
  def myPrint(size: Int, func: ((Int) => Int)) = func(size)
}
