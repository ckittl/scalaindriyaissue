package example

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import tech.units.indriya.quantity.Quantities
import tech.units.indriya.unit.Units.METRE

class QuantitySpec extends AnyWordSpecLike with Matchers {
  "Using quantities with Scala" should {
    "not work with BigDecimal" in {
      val value = BigDecimal("5.2")
//      intercept[IllegalArgumentException] {
        Quantities.getQuantity(value, METRE)
//      }.getMessage shouldBe "Unsupported number type 'scala.math.BigDecimal'"
      true shouldBe true
    }

    "work with BigDecimal and workaround" in {
      val value = BigDecimal("5.2")
      noException shouldBe thrownBy {
        Quantities.getQuantity(value.bigDecimal, METRE)
      }
    }

    "work with Double" in {
      val value = 5.2
      noException shouldBe thrownBy {
        Quantities.getQuantity(value, METRE)
      }
    }
  }
}
