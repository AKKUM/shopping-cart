package com.akkum

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers


class ShoppingCartSpec extends AnyFreeSpec with Matchers  {
  "shopping Cart" - {
    val checkout = new Checkout
    "should add a cost of two Apples and one Organges" in {
      checkout.calculate(Seq("Apple", "Apple", "Orange")) mustBe 1.45
    }    
    "should add a cost of three Apples and four Organges" in {
      checkout.calculate(Seq("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange")) mustBe 2.80
    }

  }
}

