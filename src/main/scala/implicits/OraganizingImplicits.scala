package implicits

object OraganizingImplicits extends App {


  implicit val revOrdering:Ordering[Int] = Ordering.fromLessThan(_>_)

  val l = List(1,3,2,6,4).sorted
  println(l)

  case class Person(name:String,age:Int){
  }

  val lp = List(
    Person("sunny",30),
    Person("Sharad",34),
    Person("bhai",28)
  )

  implicit val personSorting:Ordering[Person]={
    Ordering.fromLessThan((x,y)=>x.name.compareToIgnoreCase(y.name)<0)
  }

  println(lp.sorted)


  trait JsonSerializer[T]{
    def serialize(value:T):String
  }


  object JsonSerializer{
    def serialize[T](value:T)(implicit serializer: JsonSerializer[T]): String = {
      serializer.serialize(value)
    }
  }

  implicit  object PersonSerializer extends JsonSerializer[Person]{
    override def serialize(value: Person): String = {
      s"""{
            |  "name": "${value.name},"
            |  "age" : ${value.age}
         |}""".stripMargin
    }
  }
  val  p = Person("Sharad",34)
  println(JsonSerializer.serialize(p))


}
