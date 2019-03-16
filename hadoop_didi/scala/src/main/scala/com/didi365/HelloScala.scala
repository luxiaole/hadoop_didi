package com.didi365


object HelloScala {
  def main(args: Array[String]): Unit = {
  //元组的遍历
  val tuple1 = (1, 2, 3, "heiheihei")
    //方式1：
    for (elem <- tuple1.productIterator) {
      println(elem)
    }
    println()
    //方式2：
    tuple1.productIterator.foreach(i => println(i))
    //方式3
    tuple1.productIterator.foreach(println(_))

    val names = List("Alice", "Bob", "Nick")
    println(names.map(_.toUpperCase))
    println(names.flatMap(_.toUpperCase()))

    val list = List(1, 2, 3, 4, 5)
    val i1 = list.reduceLeft(_ - _)
    val i2 = list.reduceRight(_ - _)
    println(i1)
    println(i2)
    val list2 = List(1, 9, 2, 8)
    val i4 = list2.fold(5)((sum, y) => sum + y)
    println(i4)
    val i6 = (0 /: list2)(_ - _)
    println(i6)
  //统计一句话中各文字出现的次数
    val sentence = "一首现代诗《笑里藏刀》:哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈刀哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
    //m +  (“一” -> 1, “首” -> 1, “哈” -> 1)
    val i7 = (Map[Char, Int]() /: sentence)((m, c) => m + (c -> (m.getOrElse(c, 0) + 1)))
    println(i7)

    val i8 = (1 to 10).scanLeft(0)(_ + _)
    println(i8)
  //数组拉链操作
    val husband = Array("牛郎","李亚鹏","张杰");
    val wife = Array("织女","王菲","谢娜");
    val both =  husband.zip(wife);
    for(i<-both)println(i);


    val iterator = List(1, 2, 3, 4, 5).iterator
    //while循环遍历迭代器
   /* while (iterator.hasNext) {
      println(iterator.next())
    }*/
    //for循环遍历迭代器
    for(enum <- iterator) {
      println(enum)
    }
//stream流
   /* def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    val tenOrMore = numsForm(10)
    println(tenOrMore)
    println(tenOrMore.tail)
    println(tenOrMore)
    println(numsForm(5).map(x => x * x))*/

    //视图view：我们找到10万以内，所有数字倒序排列还是它本身的数字。
    val viewSquares = (1 to 100000)
      .view
      .map(x => {
        x.toLong
      }).filter(x => {
     // println(x)
      x.toString == x.toString.reverse
    })

    println(viewSquares(3))

    for(x <- viewSquares){
      print(x + "，")
    }

    //模式匹配
    object Names {
      def unapplySeq(str: String): Option[Seq[String]] = {
        if (str.contains(",")) Some(str.split(","))
        else None
      }
    }
    val namesString = "Alice,Bob,Thomas"
    namesString match {
      case Names(first, second, third) => {
        println("the string contains three people's names")
        println(s"$first $second $third")
      }
      case _ => println("nothing matched")
    }

  }
}
