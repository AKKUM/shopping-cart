package com.akkum

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers


class ShoppingCartSpec extends AnyFreeSpec with Matchers  {
  "shopping Cart" - {
    val checkout = new Checkout
    "should add a cost of two Apples and one Organges with Apple Offers" in {
      checkout.calculate(Seq("Apple", "Apple", "Orange")) mustBe 0.85
    }
    "should add a cost of three Apples and four Organges with offers" in {
      checkout.calculate(Seq("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange")) mustBe 1.95
    }

    "should add a cost of three Apples and five Organges with offers" in {
      checkout.calculate(Seq("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange")) mustBe 2.20
    }

    "should add a cost of 5 bananas with offers" in {
      checkout.calculate(Seq("Banana","Banana","Banana","Banana","Banana")) mustBe 0.60
    }

    "should add a cost of 3 Apple, 5 Oranges & 5 bananas with offers and cheapest one free" in {
      checkout.calculate(Seq("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Orange", "Banana", "Banana", "Banana", "Banana", "Banana")) mustBe 2.20
    }
    
  }
}

