package implicits

import java.{util => ju}
object ScalaJavaConvrsions extends App {

  import collection.JavaConverters._

  val jSet:ju.Set[Int] = new ju.HashSet[Int]()
  (1 to 5).map(jSet.add(_))

  println(jSet)

  println(jSet.asScala)

  import collection.mutable._

  val buffer = ArrayBuffer[Int](1,2,3)
  val jbuffer = buffer.asJava
  println(jbuffer)

  //immutable scala types to Java types not recommended
}
