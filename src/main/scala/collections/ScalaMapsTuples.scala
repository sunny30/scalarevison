package collections

import java.util.{Calendar, Date}

import org.apache.spark.sql.delta.util.DateTimeUtils

object ScalaMapsTuples {


  case class Key(key:String,id:String,time:Date)
  def main(args: Array[String]): Unit = {
    val calendar = Calendar.getInstance
    val list = List(Key("k","id",calendar.getTime), Key("k1","id1",calendar.getTime))

    val mp = list.map(key=>{
      (key,"v"+key.id)
    }).toMap[Key,String].withDefaultValue("-1")
    println(mp.get(list(1))  )

  }
}
