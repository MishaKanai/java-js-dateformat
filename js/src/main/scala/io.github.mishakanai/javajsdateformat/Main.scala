package `io.github.mishakanai`.javajsdateformat
import scala.scalajs.js.annotation.JSExportAll
import scala.scalajs.js.annotation.JSExportTopLevel
import java.time.ZoneId
import `io.github.mishakanai`.javajsdateformat

/**
  * I would like to do something like "object Formatters extends SharedFormatters", however, I can't get it to export.
  * Otherwise, the 'override defs' below could be 
  */

@JSExportTopLevel("Formatters")
@JSExportAll
object Formatters extends SharedFormatters {
   override def formatLocalDate(
        year: Int,
        month: Int,
        day: Int,
        pattern: String,
        localeStr: String = "en-US"
    ) = super.formatLocalDate(year, month, day, pattern, localeStr)

    override def formatInstant(
        epochMs: Long,
        pattern: String,
        localeStr: String = "en-US",
        zone: String = ZoneId.systemDefault().getId()
    ) = super.formatInstant(epochMs, pattern, localeStr, zone)
}
