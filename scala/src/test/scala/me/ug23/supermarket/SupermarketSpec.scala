package me.ug23.supermarket

import org.scalatest.{FunSpec, Matchers}

class SupermarketSpec extends FunSpec with Matchers {
  describe("お題1 合計金額") {
    it("りんごを1つ買うと合計は100円になる") {
      val cart = Cart()
      cart.add(1, 1)
      assert(cart.subtotal == 100)
    }

    it("しゃけ弁を1つ買うと合計は400円になる") {
      val cart = Cart()
      cart.add(5, 1)
      assert(cart.subtotal == 400)
    }

    it("たばこを2つライターを1つ買うと合計は940円になる") {
      val cart = Cart()
      cart.add(6, 2)
      cart.add(8, 1)
      assert(cart.subtotal == 940)
    }

    it("たばこを2つライターを1つというのをまとめてわたしても合計は940円") {
      val cart = Cart()
      cart.add((6, 2), (8, 1))
      assert(cart.subtotal == 940)
    }

    it("addをチェーンしても答えは出る（りんごみかんぶどう海苔弁を商品番号と同じ個数買うと2,030円）") {
      val cart = Cart()
      cart.add(1, 1).add(2, 2).add(3, 3).add(4, 4)
      assert(cart.subtotal == 2030)
    }
  }

  describe("お題2 消費税") {
    // このスーパーマーケットでは税込価格が小数になったとき四捨五入することになっている。
    it("メンソールタバコ・コーヒー・お茶を3本ずつ買うと税込1903円") {
      val cart = Cart().add((7, 3), (9, 3), (10, 3))
      assert(cart.total == 1903)
    }
  }

  describe("お題3 タバコの消費税") {
    it("タバコは内税なのでタバコとメンソールタバコを1コずつ買うと860円になる") {
      val cart = Cart().add((6, 1), (7, 1))
      assert(cart.total == 860)
    }
    it("しゃけ弁とコーヒーとタバコを1つずつ買うと960円") {
      val cart = Cart().add((10, 1), (5, 1), (6, 1))
      assert(cart.total == 960)
    }
  }
  describe("お題4 割引") {
    it("リンゴは1個100円だが、3つ買うと280円になる。") {
      val cart = Cart().add(1,3)
      assert(cart.subtotal == 280)
    }

    it("6個買ったら40円引きになる") {
      val cart = Cart().add(1, 6)
      assert(cart.subtotal == 560)
    }

    it("9個買ったら60円引きになる(4個と5個で買う)") {
      val cart = Cart().add(1, 4).add(1, 5)
      assert(cart.subtotal == 840)
    }

  }

}

