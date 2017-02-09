//package com.learning.scala_slides2
//
//import scala.annotation.tailrec
//import scala.collection.mutable.ArrayBuffer
//
///**
// * Написать программу, которая на вход принимает 4 числа, а на выходе указывает можно ли найти такие арифметические действия (умножение, деление, разность или сумма),
// * чтобы приравнять результат первых двух чисел к результату вторых двух чисел.
// * Если можно, то программа выводит Y, если нельзя, то N.
// * Например, на вход подается: 1 5 8 2
// * Программа отвечает Y, потому что 1+5 = 8-2
// *
// * Синтаксис создания массива:
// * val arr:Array(Int) = Array(1,2,3) или val arr=Array(1,2,3)
// *
// * @see https://ru.wikibooks.org/wiki/Scala_в_примерах
// * ****************
// * Scala в примерах
// */
//object Task1_3 {
//
//  def main(args: Array[String]): Unit = {
//    val arr1 = operations2(1,5)
//    val arr2 = operations2(8,2)
//    //    val arr1 = operations2(3,4)
//    //    val arr2 = operations2(4,5)
//
//    printEquals1(arr1,arr2)
//    println()
//    printEquals4(arr1,0); println(); printEquals4(arr2,0); println()
//    printEquals11(arr1,arr2)
//    println()
//    printEquals2(arr1,arr2)
//    println()
//    printEquals3(arr1,arr2)
//
//    println()
//    ////    printEquals4(arr1,0)
//    ////    println( "6.0 == " + arr1.forall(6.0) )
//    ////    println( "10.0 == " + arr1.canEqual(10.0) )
//    //    println( "6.0 == " + arr1.equals(6.0) )
//    //    println( "10.0 == " + arr1.equals(10.0) )
//    /**
//     * при поиска элемента в массиве можно (кроме циклов) сделать так:
//     * - замерять размер обоих массивов
//     * - провести слияние массивов
//     * - и снова замерить размер массива уже после слияния
//     * (если конечный размер стал меньше - тогда в массиве были совпадающие элементы... - это при условии если в момент слияния одинаковые элементы НЕбудут дублироваться)
//     */
//
//    println()
//    println()
//    println( gcd(3,6) )
//    println( gcd(7,3) )
//    println( gcd(14,24) )
//    println( factorial(5) )
//  }
//
//  //  def operations(a: Int, b: Int): Array[Double] = {
//  //    val arr = new Array[Double](4)
//  //    arr(0) = a+b
//  //    arr(1) = a-b
//  //    arr(2) = a*b
//  //    arr(3) = a/b
//  //    arr
//  //  }
//
//  def operations2(a: Int, b: Int): ArrayBuffer[Double] = {
//    var arr = new ArrayBuffer[Double]()
//    arr += a+b
//    arr += a-b
//    arr += a*b
//    arr += a/b
//    arr
//  }
//
//
//  def printEquals1(args1: ArrayBuffer[Double], args2: ArrayBuffer[Double]) {
//    args1.foreach(i1 => args2.foreach(i2 => if (i1==i2) println("ok: (i1=" +  i1 + " i2=" + i2 + ")")))
//  }
//
//  def printEquals11(args1: ArrayBuffer[Double], args2: ArrayBuffer[Double]) {
//    args1.foreach(i1 => if(args2.canEqual(i1)) println("ok: (i1/i2=" +  i1 + ")") )
//  }
//
//  def printEquals2(args1: ArrayBuffer[Double], args2: ArrayBuffer[Double]) {
//    (0 to args1.length-1).foreach(i1 => (0 to args2.length-1).foreach(i2 => if (args1(i1)==args2(i2)) println("ok: (" + i1 + ")=" +  args1(i1) + " (" + i2 + ")=" + args2(i2))))
//  }
//
//  def printEquals3(args1: ArrayBuffer[Double], args2: ArrayBuffer[Double]) {
//    for (i1 <- 0 to args1.length-1) {
//      for (i2 <- 0 to args2.length-1) {
//        if (args1(i1)==args2(i2)) println("ok: (" + i1 + ")=" +  args1(i1) + " (" + i2 + ")=" + args2(i2))
//      }
//    }
//  }
//
//
//  @tailrec def printEquals4(args: ArrayBuffer[Double], pos: Int) {
//    if (pos < args.length) {
//      print("(" + pos + ")=" + args(pos) + " ")
//      printEquals4(args, pos+1)
//    }
//  }
//
//
//
//  /* Хвостовая рекурсия | Функции первого класса ** Рассмотрим функцию для нахождения наибольшего общего делителя двух чисел */
//  //  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
//  def gcd(a: Int, b: Int): Int = {
//    print(">")
//    if (b == 0) {
//      println(" a="+a)
//      a
//    } else {
//      println(" a="+a+" b="+b)
//      gcd(b, a % b)
//    }
//  }
//  /*
//      gcd(14, 21)
//  →   if (21 == 0) 14 else gcd(21, 14 % 21)
//  →   if (false) 14 else gcd(21, 14 % 21)
//  →   gcd(21, 14 % 21)
//  →   gcd(21, 14)
//  →   if (14 == 0) 21 else gcd(14, 21 % 14)
//  → → gcd(14, 21 % 14)
//  →   gcd(14, 7)
//  →   if(7 == 0) 14 else gcd(7, 14 % 7)
//  → → gcd(7, 14 % 7)
//  →   gcd(7, 0)
//  →   if(0 == 0) 7 else gcd(0, 7 % 0)
//  → → 7
//  */
//
//  /* Сравним это с вычислением другой рекурсивной функции, factorial */
//  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
//  /*
//        factorial(5)
//  →     if (5 == 0) 1 else 5 * factorial(5 - 1)
//  →     5 * factorial(5 - 1)
//  →     5 * factorial(4)
//  → … → 5 * (4 * factorial(3))
//  → … → 5 * (4 * (3 * factorial(2)))
//  → … → 5 * (4 * (3 * (2 * factorial(1))))
//  → … → 5 * (4 * (3 * (2 * (1 * factorial(0))))
//  → … → 5 * (4 * (3 * (2 * (1 * 1))))
//  → … → 120
//  */
//}
