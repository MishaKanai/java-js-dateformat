package io.github.mishakanai.javajsdateformat
import utest._

object FormattersTest extends TestSuite {
  def tests = Tests {
    test("formatLocalDate") {
      val result = Formatters.formatLocalDate(
        1992,
        2,
        9, "MM dd YYYY"
      );
      assert(result == "02 09 1992")
    }
    test("formatInstant - default arguments") {
      val result = Formatters.formatInstant(
        "697654800000", // US East, noon Feb 9 1992
        "MM dd YYYY",
        // default to american english locale
        // default to system timezone
      );
      assert(result == "02 09 1992")
    }

    test("formatInstant - default timezone") {
      val result = Formatters.formatInstant(
        "697654800000", // US East, noon Feb 9 1992
        "MM dd YYYY",
        // "en-US",
        // default to system timezone
      );
      assert(result == "02 09 1992")
    }

    test("formatInstant - ") {
      val result = Formatters.formatInstant(
        "697615200000", // US East, 01:00am Feb 9 1992
        "MM dd YYYY",
        "en-US",
        "Europe/Berlin"
      );
      assert(result == "02 09 1992")
    }
     test("basic test Instant") {
      val result = Formatters.formatInstant(
        "697615200000", // US East, 01:00am Feb 9 1992
        "MM dd YYYY",
        "en-US",
        "Pacific/Apia"
      );
      assert(result == "02 08 1992")
    }
    test("formatInstant - MMMM") {
      val result = Formatters.formatInstant(
        "697654800000", // US East, noon Feb 9 1992
        "MMMM",
        "en-US"
        // default to system timezone
      );
      assert(result == "February")
    }
    test("formatLocalDate - MMMM") {
      val result = Formatters.formatLocalDate(
        1992, 2, 9,
        "MMMM"
      );
      assert(result == "February")
    }
    test("formatLocalDate - MMMM es") {
      val result = Formatters.formatLocalDate(
        1992, 2, 9,
        "MMMM",
        "es"
      );
      assert(result == "febrero")
    }
    test("formatInstant - MMMM es") {
      val result = Formatters.formatInstant(
        "697615200000",
        "MMMM",
        "es"
      );
      assert(result == "febrero")
    }
  }
}