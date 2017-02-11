class ListTest
{
  import org.junit._, Assert._
  
  @Test def simpleList =
  {
    val myFirstList = List("Ted", "Amanda", "Luke")
    
    assertEquals(myFirstList.isEmpty, false)
    assertEquals(myFirstList.head, "Ted")
    assertEquals(myFirstList.tail, List("Amanda", "Luke"))
    assertEquals(myFirstList.last, "Luke")
  }
  
  @Test def recurseList =
  {
    val myVIPList = List("Ted", "Amanda", "Luke", "Don", "Martin")
    
    def count(VIPs : List[String]) : Int =
    {
      if (VIPs.isEmpty)
        0
      else
        count(VIPs.tail) + 1
    }
    
    assertEquals(count(myVIPList), myVIPList.length)
  }
  @Test def recurseConsedList =
  {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil
    
    def count(VIPs : List[String]) : Int =
    {
      if (VIPs.isEmpty)
        0
      else
        count(VIPs.tail) + 1
    }
    
    assertEquals(count(myVIPList), myVIPList.length)
  }
  @Test def recurseWithPM =
  {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil
    
    def count(VIPs : List[String]) : Int =
    {
      VIPs match
      {
        case h :: t => count(t) + 1
        case Nil => 0
      }
    }
    
    assertEquals(count(myVIPList), myVIPList.length)
  }
  @Test def recurseWithPMAndSayHi =
  {
    val myVIPList = "Ted" :: "Amanda" :: "Luke" :: "Don" :: "Martin" :: Nil
    
    var foundAmanda = false
    
    def count(VIPs : List[String]) : Int =
    {
      VIPs match
      {
        case "Amanda" :: t =>
          System.out.println("Hey, Amanda!")
          foundAmanda = true
          count(t) + 1
        case h :: t =>
          count(t) + 1
        case Nil =>
          0
      }
    }
    
    assertEquals(count(myVIPList), myVIPList.length)
    assertTrue(foundAmanda)
  }
}
