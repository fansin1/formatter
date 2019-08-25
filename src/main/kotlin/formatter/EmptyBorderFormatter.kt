package formatter

class EmptyBorderFormatter : BorderFormatter {

    override fun format(rows: Sequence<List<String>>): String {
        /*val width = rows.map { row -> row.map { elem -> elem.length }.sum() }.max()
        val res = StringBuilder()*/
        return rows.map { row -> row.joinToString("") }.joinToString("\n")
    }

}