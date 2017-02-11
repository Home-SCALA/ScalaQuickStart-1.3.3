//// JUnit test suite
////
//class TupleTest
//{
//  import org.junit._, Assert._
//  import java.util.Date
//
//  @Test def simpleTuples() =
//  {
//    val tedsStartingDateWithScala = Date.parse("3/7/2006")
//
//    val tuple = ("Ted", "Scala", tedsStartingDateWithScala)
//
//    assertEquals(tuple._1, "Ted")
//    assertEquals(tuple._2, "Scala")
//    assertEquals(tuple._3, tedsStartingDateWithScala)
//
//    System.out.println(tuple)
//    System.out.println(tuple.getClass())
//  }
//
//  @Test def charCount2() =
//  {
//    val message = "When, in the course of human events, it becomes necessary " +
//      "for a people to dissolve their association with a language, it is in " +
//      "the best interests of those people to choose another language that is " +
//      "compatible with the one they have just left."
//
//    val list = message.toList()
//    val h = new scala.collection.mutable.HashMap[String, List[String]]()
//
//    list foreach(v => names.put(v.foo, v.bar :: h.get(v.foo).getOrElse(List[String]())))
//  }
//
//  @Test def charCount() =
//  {
//    val message = "When, in the course of human events, it becomes necessary " +
//      "for a people to dissolve their association with a language, it is in " +
//      "the best interests of those people to choose another language that is " +
//      "compatible with the one they have just left."
//
//    def mostPopularChar(message : String) =
//    {
//      var chars = scala.collection.mutable.Map[Char, Int]()
//
//      for (ch <- message)
//      {
//        System.out.println("Found " + ch)
//        chars.getOrElse(ch) { 0 } match
//        {
//          case 0 =>
//            chars.update(ch, 1)
//          case ct =>
//            chars.update(ch, ct)
//        }
//      }
//
//      chars.foreach ( (x) => System.out.println(x._1.toString() + " = " + x._2) )
//    }
//
//    val mpc = mostPopularChar(message)
//    System.out.println("Huh?")
//
//    assertEquals(1,1)
//    //assertEquals(mpc._1, 1)
//    //assertEquals(mpc._2, 1)
//  }
//}
