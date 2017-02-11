package com.learning.scala_slides2

import org.junit._, Assert._

/**
 * @see http://www.ibm.com/developerworks/ru/library/j-scala06278/
 */

class ListTest {

  /**
   * Листинг 1. Готовы сыграть в футбол?
   */
  @Test def simpleOptionTest = {
    val footballTeamsAFCEast = Map("New England" -> "Patriots",
        "New York" -> "Jets",
        "Buffalo" -> "Bills",
        "Miami" -> "Dolphins",
        "Los Angeles" -> null)

    assertEquals(footballTeamsAFCEast.get("Miami"), Some("Dolphins"))
//    assertEquals(footballTeamsAFCEast.get("Miami").get(), "Dolphins") //assertEquals(footballTeamsAFCEast.get("Miami").get(0), "Dolphins")
    assertEquals(footballTeamsAFCEast.get("Los Angeles"), Some(null))
    assertEquals(footballTeamsAFCEast.get("Sacramento"), None)
  }

  /**
   * Листинг 2. Типичный пример сопоставления с образцом
   */
  @Test def optionWithPM = {
    val footballTeamsAFCEast = Map("New England" -> "Patriots",
        "New York" -> "Jets",
        "Buffalo" -> "Bills",
        "Miami" -> "Dolphins")

    def show(value: Option[String]) = {
      value match {
        case Some(x) => x
        case None => "No team found"
      }
    }

    assertEquals(show(footballTeamsAFCEast.get("Miami")), "Dolphins")
  }

  /**
   * Кортежи и множества - в Scala они получили название кортежи (tuples) (в Java – более известны как объекты передачи данных (DTO) или объекты-параметры)
   * Листинг 3. tuples.scala
   */
  class TupleTest {
    import org.junit._, Assert._
    import java.util.Date

    @Test def simpleTuples() = {
      val tedsStartingDateWithScala = Date.parse("3/7/2006")
      val tuple = ("Ted", "Scala", tedsStartingDateWithScala)

      assertEquals(tuple._1, "Ted")
      assertEquals(tuple._2, "Scala")
      assertEquals(tuple._3, tedsStartingDateWithScala)
    }
  }

  /**
   * Листинг 6. Поиск всех Scala-разработчиков
   */
  // Class to represent a person (programmer, really, but "Person" is shorter)
  // For demo purposes only
  class Person(val firstName: String, val lastName: String, val age: Int, var salary: Int, val skills: Array[String]) {
    override def toString = "Person("+firstName+", "+lastName+", "+age+", "+salary+", {"+skills.toList+"})"
  }

  class ArrayTest {
    import org.junit._, Assert._

    @Test def testFilter = {
      val programmers = Array(
        new Person("Ted", "Neward", 37, 50000,
          Array("C++", "Java", "Scala", "Groovy", "C#", "F#", "Ruby")),
        new Person("Amanda", "Laucher", 27, 45000,
          Array("C#", "F#", "Java", "Scala")),
        new Person("Luke", "Hoban", 32, 45000,
          Array("C#", "Visual Basic", "F#")),
        new Person("Scott", "Davis", 40, 50000,
          Array("Java", "Groovy"))
      )

      // Найти всех разработчиков на Scala ...
      val scalaProgs =
        programmers.filter((p) => p.skills.contains("Scala") )

      // Их должно быть 2
      assertEquals(2, scalaProgs.length)

      // ... и выполнить некоторую операцию над полученным массивом Scala-разработчиков (повысить им зарплату, разумеется!)
      scalaProgs.foreach((p) => p.salary += 5000)

      // Увеличить зарплату каждого на 5000 ...
      assertEquals(programmers(0).salary, 50000 + 5000)
      assertEquals(programmers(1).salary, 45000 + 5000)

      // ... кроме тех, кто не знает Scala
      assertEquals(programmers(2).salary, 45000)
      assertEquals(programmers(3).salary, 50000)
    }
  }

  /**
   * Листинг 7. Сочетание filter и map
   */
  @Test def testFilterAndMap = {
    val programmers = Array(
      new Person("Ted", "Neward", 37, 50000,
        Array("C++", "Java", "Scala", "C#", "F#", "Ruby")),
      new Person("Amanda", "Laucher", 27, 45000,
        Array("C#", "F#", "Java", "Scala")),
      new Person("Luke", "Hoban", 32, 45000,
        Array("C#", "Visual Basic", "F#")),
    new Person("Scott", "Davis", 40, 50000,
      Array("Java", "Groovy"))
    )

    // Найти всех разработчиков на Scala ...
    val scalaProgs =
      programmers.filter((p) => p.skills.contains("Scala") )

    // Их должно быть 2
    assertEquals(2, scalaProgs.length)

    // ... и выполнить некоторую операцию над полученным массивом Scala-разработчиков (повысить им зарплату, разумеется!)
    def raiseTheScalaProgrammer(p : Person) = {
      new Person(p.firstName, p.lastName, p.age, p.salary + 5000, p.skills)
    }
    val raisedScalaProgs = scalaProgs.map(raiseTheScalaProgrammer)

    assertEquals(2, raisedScalaProgs.length); for(raisedScalaProg <- raisedScalaProgs) println( raisedScalaProg + " || " + raisedScalaProg.salary )
    assertEquals(50000 + 5000, raisedScalaProgs(0).salary); println( (50000+5000) )
    assertEquals(45000 + 5000, raisedScalaProgs(1).salary); println( (45000+5000) )
  }

  ////////////////////////////////////////////////////////////

  /**
   * Листинг 8. Пример работы со списками
   */
  @Test def simpleList = {
    val myFirstList = List("Ted", "Amanda", "Luke")

    assertEquals(myFirstList.isEmpty, false)
    assertEquals(myFirstList.head, "Ted")
    assertEquals(myFirstList.tail, List("Amanda", "Luke"))
    assertEquals(myFirstList.last, "Luke")
  }

  /**
   * Листинг 9. Пример рекурсивной обработки списка
   */
  @Test def recurseList = {
    val myVIPList = List("Ted", "Amanda", "Luke", "Don", "Martin")

    def count(VIPs: List[String]): Int = {
      if (VIPs.isEmpty) 0 // изначально (список НЕпустой, поэтому) выполняется условие и возвращается значение '0'
      else count(VIPs.tail) + 1 // дальше, в этом случаевсегда будет возвращаться: ('0+1') или 'n+1'
    }

//    println("recurseList >  length=" + myVIPList.length) //recurseList >  length=5
    assertEquals(count(myVIPList), myVIPList.length)
  }

  /**
   * (API для работы со списками)
   * Листинг 10. Пример создания списка
   */
  @Test def recurseConsedList = {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil

    def count(VIPs : List[String]) : Int = {
      if (VIPs.isEmpty) 0
      else count(VIPs.tail) + 1
    }

    assertEquals(count(myVIPList), myVIPList.length)
  }

  /**
   * Листинг 11. Обработка списка методом сопоставления с образцом
   */
  @Test def recurseWithPM = {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil

    def count(VIPs : List[String]) : Int = {
      VIPs match {
        case h :: t => count(t) + 1
        case Nil => 0
      }
    }

    assertEquals(count(myVIPList), myVIPList.length)
  }

  /**
   * Листинг 12. Поиск объекта "Amanda" методом сопоставления с образцом
   */
  @Test def recurseWithPMAndSayHi = {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil

    var foundAmanda = false
    def count(VIPs : List[String]) : Int = {
      VIPs match {
        case "Amanda" :: vv =>
          System.out.println("Hey, Amanda!"); foundAmanda = true; count(vv) + 1
        case v :: vv =>
//          System.out.println("-" + v + " (" + vv + ")" + "-")
          count(vv) + 1
        case Nil =>
          0
      }
    }

//    -Ted (List(Amanda, Luke, Don, Martin))-
//    Hey, Amanda!
//    -Luke (List(Don, Martin))-
//    -Don (List(Martin))-
//    -Martin (List())-
//    println("recurseWithPMAndSayHi >  length=" + myVIPList.length) //recurseWithPMAndSayHi >  length=5
    assertEquals(count(myVIPList), myVIPList.length)
    assertTrue(foundAmanda)
  }

  /**
   * Листинг 13. Поиск элемента в массиве при помощи сопоставления с образцом
   */
  @Test def recurseWithPMAndSayHi2 = {
    val myVIPList = Array("Ted", "Amanda", "Luke", "Don", "Martin")
    var foundAmanda = false

    myVIPList.foreach((s) => s match {
        case "Amanda" =>
          System.out.println("Hey, Amanda!")
          foundAmanda = true
        case _ =>
          ; // Do nothing
      }
    )

    assertTrue(foundAmanda)
  }
}
