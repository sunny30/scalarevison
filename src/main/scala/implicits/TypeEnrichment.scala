package implicits

import implicits.OraganizingImplicits.JsonSerializer

object TypeEnrichment extends App {


  trait JsonSerializer[T]{
    def serialize(value:T):String
  }




   implicit class StringSerializer(val value:String){
    def serialize(): String = s"""\"string\": \"${value}\" """
  }

  implicit class JsonEnrichment[T](value:T){
    def jsonSerialize(implicit serializer: JsonSerializer[T]):String = serializer.serialize(value)
  }

  implicit object StringSerializer extends JsonSerializer[String]{
    def apply(value:String): StringSerializer = new StringSerializer(value)

    override def serialize(value: String): String = (new StringSerializer(value)).serialize()
  }

   class NumberSerializer() {
     def serialize(value:Int): String = s""""number": $value"""
  }

    implicit object NumberSerializer extends JsonSerializer[Int]{
    def apply(value:Int): NumberSerializer = new NumberSerializer()
    def serialize(value:Int): String = (new NumberSerializer()).serialize(value)
  }

  val s = "2"
  println(s.jsonSerialize)
  val a:Int = 2
  println(a.jsonSerialize)


  
//  object JsonSerializer{
//    def serialize[T](value:T)(implicit jsonSerializer: JsonSerializer[T]):String={
//      jsonSerializer.serialize(value)
//    }
//  }

 //println("42".serialize())

  //println(JsonSerializer.serialize("42")(StringSerializer("42")))




}
