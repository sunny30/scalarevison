package oops

object ScalaCaseClasses {

  def main(args: Array[String]): Unit = {
    val scc = SampleCaseClass("Sunny", "xyz123")

  }

  //constructor parameter are member variable, immutable in nature, toString equals hashcode is already applied
  //case classes has extractor pattern ..good for pattern matching
  case class SampleCaseClass(name: String, id: String)

}
