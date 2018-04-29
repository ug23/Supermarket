package me.ug23.supermarket

case class Item(id: Int, unit: Int, isTaxIncluded: Boolean) {
  def price(taxRate: Double): Double = {
    if (isTaxIncluded) unit.toDouble
    else unit * taxRate
  }

  def price(amount: Int)(implicit taxRate: Double): Int = (amount * price(taxRate)).round.toInt
}