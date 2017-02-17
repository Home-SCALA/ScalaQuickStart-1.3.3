package com.learning.scala_slides2

import org.junit._, Assert._

class Source1Test {

  /**
   * Array Pattern matching in Scala
   * @see https://gist.github.com/kings13y/882292
   */
  @Test def testSum = {
    val list = List(1, 2, 3, 4)
    println( sum(list) )
  }

  @Test def testCountMatchs = {
    //    case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
    //    case 'B' => 2
    println( "countHoles = " + countMatchs(Array('R', 'R', 'R', 'a', 'b')) )
    println( "countHoles = " + countMatchs(Array('B', 'a', 'b')) )

    //    val str3: String = "QRO" //val str3: String = "QROPAD"
    //    println( "countHoles-2 = " + countMatchs(str1.toList) )
    //    println( "countHoles-2 = " + countMatchs(str3.toList) )
    println( "countHoles-2 = " + countMatchs("QROPAD".toList) ) // 6
    println( "countHoles-2 = " + countMatchs("qwebrt".toList) ) // 0
    println( "countHoles-2 = " + countMatchs("RRb".toList) )    // 2
    println( "countHoles-2 = " + countMatchs("B".toList) )      // 2
  }

  /**
   * @see https://www.ibm.com/developerworks/ru/library/j-scala06278
   *      **********************************************************
   *      Пример создания списка
   * Будьте внимательны при использовании метода ::, поскольку с ним связано несколько непривычных правил:
   * - для того чтобы она работала корректно, пришлось ввести одно необычное правило: любой метод с "забавным именем", заканчивающимся двоеточием, является правоассоциативным.
   * Это означает, что выражение интерпретируется справа налево, т.е. список строится начиная с правого элемента Nil, который, к счастью, сам по себе является списком. Таким образом, :: является глобальным методом, а не методом-членом конкретного класса (в данном случае, String)
   * При использовании :: крайним правым элементом также должен быть список, иначе компилятор выдаст сообщение об ошибке.
   */
  @Test def recurseConsedList = {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil

    def count(VIPs: List[String]) : Int = {
      if (VIPs.isEmpty) 0
      else count(VIPs.tail) + 1
    }

    assertEquals(count(myVIPList), myVIPList.length)
  }

  /**
   * @see https://www.ibm.com/developerworks/ru/library/j-scala06278
   *      **********************************************************
   *      Обработка списка методом сопоставления с образцом
   */
  @Test def recurseWithPM = {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil

    def count(VIPs : List[String]): Int = {
      VIPs match {
        case h :: t => count(t) + 1
        case Nil => 0
      }
    }

    assertEquals(count(myVIPList), myVIPList.length)
  }


  def sum(listOfInts: List[Int]) : Int = listOfInts match {
    case List() => 0 		// If it is an empty list, just return zero
    case h :: t => h + sum(t) // Otherwise, recurse and sum elements
  }

  def countMatchs(chars: Array[Char]): Int = chars match {
    case Array() => 0
    case _ => countMatchs(chars.tail) + (chars.head match {
      case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
      case 'B' => 2
      case _ => 0
    })
  }

  def countMatchs(chars: List[Char]): Int =
    chars match {
      case List() => 0 // если список пустой - тогда возвращаем '0'
      case _ => countMatchs(chars.tail) + (chars.head match { // берем порядковый элемент с конца
        case 'Q' | 'R' | 'O' | 'P' | 'A' | 'D' => 1
        case 'B' => 2
        case _ => 0 // на все остальное - возвращаем '0'
      })
    }

}
