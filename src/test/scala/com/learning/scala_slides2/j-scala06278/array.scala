//object ArrayExample1
//{
//  def main(args : Array[String]) : Unit =
//  {
//    for (i <- 0 to args.length-1)
//    {
//      System.out.println(args(i))
//    }
//  }
//}
//
//object ArrayExample2
//{
//  def main(args : Array[String]) : Unit =
//  {
//	args.foreach( (arg) => System.out.println(arg) )
//  }
//}
//
//// Class to represent a person (programmer, really, but "Person" is shorter)
////
//// For demo purposes only
////
//class Person(val firstName: String, val lastName: String, val age: Int,
//             var salary: Double, val skills: Array[String])
//{
//}
//
//// JUnit test suite
////
//class ArrayTest
//{
//  import org.junit._, Assert._
//
//  @Test def testSimpleArray =
//  {
//    val arr = Array(0, 1, 2, 3, 4, 5)
//
//    for (i <- 0 to arr.length-1)
//      assertEquals(i, arr(i))
//  }
//
//  @Test def testFilter =
//  {
//    val programmers = Array(
//        new Person("Ted", "Neward", 37, 50000,
//          Array("C++", "Java", "Scala", "C#", "F#", "Ruby")),
//        new Person("Amanda", "Laucher", 27, 45000,
//          Array("C#", "F#", "Java", "Scala")),
//        new Person("Luke", "Hoban", 32, 45000,
//          Array("C#", "Visual Basic", "F#"))
//      )
//
//    // Find all the Scala programmers ...
//    val scalaProgs =
//      programmers.filter((p) => p.skills.contains("Scala") )
//
//    // Should only be 2
//    assertEquals(2, scalaProgs.length)
//
//    // ... now perform an operation on each programmer in the resulting
//    // array of Scala programmers (give them a raise, of course!)
//    //
//    scalaProgs.foreach((p) => p.salary += 5000)
//
//    // Should each be increased by 5000
//    assertEquals(programmers(0).salary, 50000 + 5000)
//    assertEquals(programmers(1).salary, 45000 + 5000)
//
//    // ... except for our programmer who doesn't know Scala
//    assertEquals(programmers(2).salary, 45000)
//  }
//
//  @Test def testFilterAndMap =
//  {
//    val programmers = Array(
//        new Person("Ted", "Neward", 37, 50000,
//          Array("C++", "Java", "Scala", "C#", "F#", "Ruby")),
//        new Person("Amanda", "Laucher", 27, 45000,
//          Array("C#", "F#", "Java", "Scala")),
//        new Person("Luke", "Hoban", 32, 45000,
//          Array("C#", "Visual Basic", "F#"))
//      )
//
//    // Find all the Scala programmers ...
//    val scalaProgs =
//      programmers.filter((p) => p.skills.contains("Scala") )
//
//    // Should only be 2
//    assertEquals(2, scalaProgs.length)
//
//    // ... now perform an operation on each programmer in the resulting
//    // array of Scala programmers (give them a raise, of course!)
//    //
//    def raiseTheScalaProgrammer(p : Person) =
//    {
//      new Person(p.firstName, p.lastName, p.age,
//        p.salary + 5000, p.skills)
//    }
//    val raisedScalaProgs =
//      scalaProgs.map(raiseTheScalaProgrammer)
//
//    assertEquals(2, raisedScalaProgs.length)
//    assertEquals(50000 + 5000, raisedScalaProgs(0).salary)
//    assertEquals(45000 + 5000, raisedScalaProgs(1).salary)
//  }
//
//  @Test def findAmanda =
//  {
//    val myVIPList = Array("Ted", "Amanda", "Luke", "Don", "Martin")
//
//    var foundAmanda = false
//
//    myVIPList.foreach((s) =>
//      s match
//      {
//        case "Amanda" =>
//          System.out.println("Hey, Amanda!")
//          foundAmanda = true
//        case _ =>
//          ; // Do nothing
//      }
//    )
//
//    assertTrue(foundAmanda)
//  }
//
//  @Test def recurseWithPMCountAndSayHiSolution =
//  {
//    val myVIPList = Array("Ted", "Amanda", "Luke", "Don", "Martin")
//    var foundAmanda = false
//    def count(VIPs : Array[String]) : Int =
//    {
//      VIPs match
//      {
//        case Array() =>
//          0
//
//        case Array("Amanda", rest) =>
//          System.out.println("Howdy, Amanda!")
//          foundAmanda = true
//          count(rest) + 1
//
//        case x =>
//          x(0) match
//          {
//            case "Amanda" =>
//              System.out.println("Howdy, Amanda!")
//              foundAmanda = true
//              count(VIPs.subArray(1, x.length)) + 1
//
//            case _ =>
//              count(VIPs.subArray(1, x.length)) + 1
//          }
//      }
//    }
//
//    assertEquals(count(myVIPList), myVIPList.length)
//    assertTrue(foundAmanda)
//  }
//}
