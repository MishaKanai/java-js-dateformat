package mishakanai.javajsdateformat
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
import java.time.Instant
import java.time.temporal.TemporalAccessor

trait SharedFormatters {
    def formatLocalDate(
        year: Int,
        month: Int,
        day: Int,
        pattern: String,
        localeStr: String = "en-US"
    ): String = {
        val locale = Locale.forLanguageTag(localeStr);
        val formatter = DateTimeFormatter.ofPattern(pattern).withLocale(locale);
        val date = LocalDate.of(year, month, day)
        return date.format(formatter);
    }
    def formatInstant(
        epochMs: Long,
        pattern: String,
        localeStr: String = "en-US",
        zone: String = ZoneId.systemDefault().getId()
    ): String = {
        val locale = Locale.forLanguageTag(localeStr);
        val formatter = DateTimeFormatter.ofPattern(pattern).withZone(ZoneId.of(zone)).withLocale(locale);
        val instant = Instant.ofEpochMilli(epochMs);
        return formatter.format(instant);
    }
}