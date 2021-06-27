package collections

object CollectionListSeuence {

  def main(args: Array[String]): Unit = {
    val list  = List(List(1,2),List(3))
    val colors = Seq("red","blue","green")

   // list.flatMap(x=>x).seq.map(println(_))
    list.flatMap(c =>c).map(c=>colors.map(l=>{
      (l+""+c)
    })).seq.map(combination=>print(combination))
  }
}
