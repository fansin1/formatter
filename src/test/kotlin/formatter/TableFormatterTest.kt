/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package formatter

import org.junit.Test
import kotlin.test.assertEquals

class TableFormatterTest {

    @Test
    fun borderlessTest() {

        val borderLessResult =
        "Test   \ttest\ttestet\t\n" +
                "ter    \tte  \t\n" +
                "123.123\t12.0\ttest  \t123\t"

        val tableFormatter = TableFormatter.create()
        tableFormatter.addRow("Test", "test", "testet")
        tableFormatter.addRow("ter", "te")
        tableFormatter.addRow(123, 13, 123)
        tableFormatter.addRow(123.123, 12.0, "test", 123)
        tableFormatter.removeAt(2)

        assertEquals(tableFormatter.format(), borderLessResult)
    }
}
