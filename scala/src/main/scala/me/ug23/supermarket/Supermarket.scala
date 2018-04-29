package me.ug23.supermarket

object Supermarket {
  implicit val taxRate: Double = 1.08
  val items: Map[Int, Item] = Seq(
    Item(1, 100, isTaxIncluded = false),
    Item(2, 40, isTaxIncluded = false),
    Item(3, 150, isTaxIncluded = false),
    Item(4, 350, isTaxIncluded = false),
    Item(5, 400, isTaxIncluded = false),
    Item(6, 420, isTaxIncluded = true),
    Item(7, 440, isTaxIncluded = true),
    Item(8, 100, isTaxIncluded = false),
    Item(9, 80, isTaxIncluded = false),
    Item(10, 100, isTaxIncluded = false)
  ).map(i => i.id -> i).toMap

  def toItem(id: Int):Item = items.getOrElse(id, sys.error("商品番号リストにない番号を指定しています。"))
}
