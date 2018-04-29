package me.ug23.supermarket

class Cart {

  // TODO: currentItemsを商品番号ごとにまとめる処理が必要かも
  var currentItems: Seq[(Int, Int)] = List.empty[(Int, Int)]

  def unite: Cart = {
    val is: Map[Int, Seq[(Int, Int)]] = currentItems.groupBy(_._1)
    is.map{case (i, is) => (i, is.map(_._2).sum)}
  }

  def add(index: Int, amount: Int): Cart = {
    currentItems +:= (index, amount)
    this
  }

  def add(items: (Int, Int)*): Cart = items.foldLeft(this)((c, i) => c.add(i._1, i._2))

  def subtotal: Int = {
    val actualSubtotal = currentItems.map(is => (Supermarket.toItem(is._1), is._2))
      .foldLeft(0)((s, i) => s + i._1.unit * i._2)
    val appleAmount:Int = currentItems.find(i => i._1 == 1).fold(0)(_._2)
    if (appleAmount >= 3) actualSubtotal - 20 * (appleAmount / 3)
    else actualSubtotal
  }

  def total: Int = {
    implicit val taxRate: Double = Supermarket.taxRate
    currentItems.map(is => (Supermarket.toItem(is._1), is._2)).map { case (i, amount) => i.price(amount) }.sum
  }
}

object Cart {
  def apply(): Cart = new Cart()
}
