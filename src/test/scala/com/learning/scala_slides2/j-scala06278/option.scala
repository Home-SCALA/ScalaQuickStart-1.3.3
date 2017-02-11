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
//class OptionTest
//{
//  import org.junit._, Assert._
//
//  @Test def simpleOptionTest =
//  {
//    val footballTeamsAFCEast =
//      Map("New England" -> "Patriots",
//          "New York" -> "Jets",
//          "Buffalo" -> "Bills",
//          "Miami" -> "Dolphins",
//          "Los Angeles" -> null)
//
//    assertEquals(footballTeamsAFCEast.get("Miami"), Some("Dolphins"))
//    assertEquals(footballTeamsAFCEast.get("Miami").get(), "Dolphins")
//    assertEquals(footballTeamsAFCEast.get("Los Angeles"), Some(null))
//    assertEquals(footballTeamsAFCEast.get("Sacramento"), None)
//  }
//
//  @Test def optionWithPM =
//  {
//    val footballTeamsAFCEast =
//      Map("New England" -> "Patriots",
//          "New York" -> "Jets",
//          "Buffalo" -> "Bills",
//          "Miami" -> "Dolphins")
//
//    def show(value : Option[String]) =
//    {
//      value match
//      {
//        case Some(x) => x
//        case None => "No team found"
//      }
//    }
//
//    assertEquals(show(footballTeamsAFCEast.get("Miami")), "Dolphins")
//  }
//}