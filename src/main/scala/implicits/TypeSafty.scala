package implicits

object TypeSafty extends App{

  abstract class Human{}
  case class Person(name:String, id:String) extends Human
  case class User(username:String, publicId: String,userId:String) extends Human

  class Equality[T]{
    def apply(to:T, from:T):Boolean = to == from
  }


  implicit object StringEquality extends Equality[String]{
    override def apply(to:String, from: String): Boolean = to.startsWith(from) || from.startsWith(to)
  }

  implicit object PersonEquality {
     def apply(to: Human, from:Human ): Boolean= {
      (to,from) match {
        case (x@Person(_,_),y@User(_,_,_))=>{ x.id == y.publicId }
        case _ => false
      }
    }
  }


  trait Equalizer[T]{
    def ===(to:T, from:T)(implicit equalizer:Equality[T]):Boolean = equalizer(to,from)
  }

  implicit class StringEqualizer(val to:String) extends Equalizer[String]{
     def ===(from: String)(implicit equalizer: Equality[String]): Boolean = super.===(to, from)
  }

  implicit class HumanEqualizer(val to: Human) extends Equalizer[Human]{
    def ===(from: Human)(implicit equalizer: Equality[Human]): Boolean = super.===(to, from)
  }

  implicit class PersonEqualizer(val to:Person) extends Equalizer[Person]{
    def ===(from:User): Boolean = {
      PersonEquality(to,from)

    }
  }


  val res = ("hello" === "gello world")

  val user = User("Sharad","89B","XYZ")
  val p = Person("Sharad singh","89B")

  val res1 = (p === user)
  println(res)
  println(res1)

}
