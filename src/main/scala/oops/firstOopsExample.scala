package oops

object firstOopsExample {

  def main(args: Array[String]): Unit = {
    val person = new Person("Sunny", 34,"xyz")
    println(person.age+" "+person.name)
  }



}

//this val create parameter to field id cannot be accessed by instance
class Person(val name:String, val age: Int,id:String){

}
