package io.github.mishakanai.javajsdateformat

import utest._

object JvmFormattersTest extends TestSuite {
  def tests = Tests {
    test("formatLocalDate - JVM includes locales not in the JS build - fi MMMM") {
      val result = Formatters.formatLocalDate(
        1992,
        2,
        9, "MMMM",
        "fi"
      );
      assert(result == "helmikuuta")
    }
  }
}