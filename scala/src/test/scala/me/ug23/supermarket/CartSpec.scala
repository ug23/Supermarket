package me.ug23.supermarket

import org.scalatest.FunSpec

class CartSpec extends FunSpec {


  describe("商品カート") {
    it("商品カートは最初空っぽ") {
      val cart = Cart()
      assertResult(true)(cart.currentItems.isEmpty)
    }
    it("商品カートに1要素追加するとcurrentItemsの要素数は1増える") {
      val cart = Cart()
      cart.add(1, 1)
      assert(cart.currentItems.length == 1)
    }
    it("商品カートに(1,1), (2,1)を入れるとcurrentItemsにその2つが入っている") {
      val cart = Cart()
      cart.add(1, 1)
      cart.add(2, 1)
      assert(cart.currentItems.length == 2)
      assert(cart.currentItems contains(1, 1))
      assert(cart.currentItems contains(2, 1))
    }
  }
}
