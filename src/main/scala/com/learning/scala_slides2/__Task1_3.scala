//package com.learning.scala_slides2
//
//import annotation.tailrec
//import collection.mutable.ArrayBuffer
//import Array._
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
//    //    /**
//    //     * при поиска элемента в массиве можно (кроме циклов) сделать так:
//    //     * - замерять размер обоих массивов
//    //     * - провести слияние массивов
//    //     * - и снова замерить размер массива уже после слияния
//    //     * (если конечный размер стал меньше - тогда в массиве были совпадающие элементы... - это при условии если в момент слияния одинаковые элементы НЕбудут дублироваться)
//    //     */
//
//    //    val arr = ofDim[Double](2,4)
//    //    arr(0) = operations(1,5)
//    //    arr(1) = operations(8,2)
//    //
//    //    val arr = Array(operations(1,5), operations(8,2))
//    //    val arr = operations(1,5,8,2)
//    //
//    //    var arr = ofDim[Double](2,4) //var arr: Array[Array[Double]] = ofDim[Double](2,4)
//    //    arr = operations(1,5,8,2)
//    //
//    //    val arr = operations2(1,5,8,2)
//    //
//    val arr = typeOperations31.apply(1,5,8,2) //val arr = operations3(1,5,8,2,typeOperations31) //val arr = operations3(1,5,8,2) //val arr = operations3(1,5,8,2,typeOperations31)
//    //
//    //    val arr = typeOperations42.apply(1,5,8,2) //val arr = typeOperations41.apply(1,5,8,2) ////val arr = typeOperations41.apply(1,5,8,2,"x")
//    //    val arr = operations4(1,5,8,2)
//
//    for (i1 <- 0 to arr(0).length-1) {
//      for (i2 <- 0 to arr(1).length-1) {
//        if (arr(0)(i1)==arr(1)(i2)) println("ok: (" + i1 + ")=" +  arr(0)(i1) + " (" + i2 + ")=" + arr(1)(i2))
//      }
//    }
//    println()
//    (0 to arr(0).length-1).foreach(
//      i1 => (0 to arr(1).length-1).foreach(
//        i2 => if (arr(0)(i1)==arr(1)(i2)) println("ok: (" + i1 + ")=" +  arr(0)(i1) + " (" + i2 + ")=" + arr(1)(i2))
//      )
//    )
//
//    println()
//    for (i1 <- arr(0)) {
//      for (i2 <- arr(1)) {
//        if (i1==i2) println("ok: (i1=" +  i1 + " i2=" + i2 + ")")
//      }
//    }
//    println()
//    arr(0).foreach(
//      i1 => arr(1).foreach(
//        i2 => if (i1==i2) println("ok: (i1=" +  i1 + " i2=" + i2 + ")")
//      )
//    )
//    myPrint.apply(arr)
//  }
//
//  val myPrint = (args: Array[Array[Double]]) => args(0).foreach(i1 => args(1).foreach(i2 => if (i1==i2) println("ok: (i1=" +  i1 + " i2=" + i2 + ")")))
//
//  /*
//   * @see http://stackoverflow.com/questions/4981689/get-item-in-the-list-in-scala
//   */
//  def operations(a: Int, b: Int): Array[Double] = {
//    val arr = new Array[Double](4)
//    arr(0) = a+b
//    arr(1) = a-b
//    arr(2) = a*b
//    arr(3) = a/b
//    arr
//  }
//
//  //  def operations(a: Int, b: Int, c: Int, d: Int): Array[Array[Double]] = {
//  ////    val arr = ofDim[Double](2,4)
//  ////    arr(0)(0) = a+b
//  ////    arr(0)(1) = a-b
//  ////    arr(0)(2) = a*b
//  ////    arr(0)(3) = a/b
//  ////    arr(1)(0) = c+d
//  ////    arr(1)(1) = c-d
//  ////    arr(1)(2) = c*d
//  ////    arr(1)(3) = c/d
//  ////    arr
//  //
//  //    Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
//  //  }
//  //
//  //  def operations(a: Int, b: Int, c: Int, d: Int): Array[Array[Double]] = Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
//  def operations(a: Int, b: Int, c: Int, d: Int) = Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
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
//  def operations2(a: Int, b: Int, c: Int, d: Int): ArrayBuffer[ArrayBuffer[Double]] = {
//    //    val arr: ArrayBuffer[ArrayBuffer[Double]] = operations2(a,b,c,d) // зацыкливание
//    //    val arr = ofDim[Double](2,4) // ошибка компиляции
//
//    //    val arr = ArrayBuffer(ArrayBuffer(.0,.0,.0,.0),ArrayBuffer(.0,.0,.0,.0)) //val arr: ArrayBuffer[ArrayBuffer[Double]] = ArrayBuffer(ArrayBuffer(0,0,0,0),ArrayBuffer(0,0,0,0))
//    //    arr(0)(0) = a+b
//    //    arr(0)(1) = a-b
//    //    arr(0)(2) = a*b
//    //    arr(0)(3) = a/b
//    //    arr(1)(0) = c+d
//    //    arr(1)(1) = c-d
//    //    arr(1)(2) = c*d
//    //    arr(1)(3) = c/d
//
//    //    val arr: ArrayBuffer[ArrayBuffer[Double]] = ArrayBuffer(ArrayBuffer(a+b,a-b,a*b,a/b),ArrayBuffer(c+d,c-d,c*d,c/d))
//    //    arr
//
//    ArrayBuffer( ArrayBuffer(a+b,a-b,a*b,a/b), ArrayBuffer(c+d,c-d,c*d,c/d) )
//  }
//
//  /**
//   * #0
//   * **
//   * Например: у меня есть написаная реализация какой-то функции-X И в старом коде эта функция уже используется во многих местах - а что если позже я захочу переопределить реализацию этой функции И применять ее уже в новом коде...
//   * > есть несколько вариантов это сделать: #1 - переопределить тело функции в классе наследнике; #2 - перегрузить функцию параметрами;
//   *   такой подход ПЛОХОЙ тем что заставляет запоминать для разработчика либо новый класс либо новые параметры для этой функции..., и являтся НЕбезопасным в старом коде при вызове такой функции
//   * > вариант: перегрузить такую функцию только один раз и только в одном классе (...при этом количество перегруженных копий может быть много...);
//   *   такой подход ЛУЧШЕ тем что можно безопасно использовать функцию в старом коде, и разработчику не нужно беспокоится о требуемых параметрах (поскольку даже их можно шаблонизировать и именовать...)
//   */
//  def operations3(a: Double, b: Double, c: Double, d: Double) = Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
//  // #1
//  //  def operations3(a: Double, b: Double, c: Double, d: Double): Array[Array[Double]] // ошибка компиляции (1)
//  //  def operations3(a: Double, b: Double, c: Double, d: Double, func: ((Double,Double,Double,Double) => Array[Array[Double]])) = ??? // ошибка компиляции (2)
//  //  def operations3(a: Double, b: Double, c: Double, d: Double, func: ((Double,Double,Double,Double) => Array[Array[Double]])) = func // ошибка компиляции (3)
//  //  def operations3(a: Double, b: Double, c: Double, d: Double, func: ((Double,Double,Double,Double) => Array[Array[Double]])) = func _ // ошибка компиляции (4)
//  def operations3(a: Double, b: Double, c: Double, d: Double, func: ((Double,Double,Double,Double) => Array[Array[Double]])) = func(a,b,c,d)
//  /*
//   * Это именно объект-функция, который потом можно использовать для передачи параметров
//   * + это ХОРОШО тем что все вычисления являются ленивыми (будут выполняться только уже в момент вызова...)
//   */
//  val typeOperations31 = (a: Double, b: Double, c: Double, d: Double) => Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) ) //val typeOperations31 = (a: Double, b: Double, c: Double, d: Double) => { Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) ) }
//  /**
//   * #2
//   * **
//   * Это именно уже (объект) значение
//   * + это удобно НЕнужно создавать-плодить отдельные функции для предварительной обработки данных...
//   * - все вычисления выполняются сразу-НЕотложно
//   * - НЕпозволяет переопределять реализацию тела для обработчика (НЕЛЬЗЯ повторно использовать код)
//   */
//  val typeOperations42 = (a: Double, b: Double, c: Double, d: Double) => Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
//  //  def operations4(a: Double, b: Double, c: Double, d: Double, x: String) = Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) ) // ошибка компиляции
//  //  def operations4(a: => Double, b: => Double, c: => Double, d: => Double) = Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
//  private def operations4(a: Double, b: Double, c: Double, d: Double) = Array( Array(a+b,a-b,a*b,a/b), Array(c+d,c-d,c*d,c/d) )
//  val typeOperations41 = operations4 _
//
//
//
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
