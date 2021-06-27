object LoopDemo {

  def main(args: Array[String]): Unit = {
    var it = 0

    for(it<- 1 to 10){
      println(it)
    }

    while(it<20){
      println(it)
      it+=1
    }

    var a =0
    var b =0 ;


    for(a<-1 to 3){
      for(b<- 1 to 3){
        println("a "+a+" b "+b)
      }
    }

    a= 0
    b =0
    for(a<-1 to 3; b<-1 to 3){
      println("a "+a+" b "+b)
    }
  }





}
