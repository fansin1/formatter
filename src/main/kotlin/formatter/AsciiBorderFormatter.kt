package formatter

class AsciiBorderFormatter : BorderFormatter {

    override fun format(rows: Sequence<List<String>>): String {
        val horizontalSeparator = StringBuilder("+") //+----+----+------+ and etc.

        rows.first().forEach { elem ->
            horizontalSeparator.apply {
                append("-".repeat(elem.length))
                append('+')

            }
        }

        return rows.map {
                row -> row.joinToString("|", "|", "|")
        }.joinToString("\n$horizontalSeparator\n", "$horizontalSeparator\n", "\n$horizontalSeparator")
    }

}