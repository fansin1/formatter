package formatter

class TableFormatter(private val borderFormatter: BorderFormatter) {

    companion object {
        fun create(): TableFormatter {
            return TableFormatter(EmptyBorderFormatter())
        }
    }

    private val rows = mutableListOf<List<String>>()


    fun<T> addRow(vararg values: T) {
        rows.add(values.asSequence().map { it.toString() }.toList())
    }

    fun removeAt(index: Int) {
        rows.removeAt(index)
    }

    fun format(): String {
        val columnsCount = rows.map { row -> row.size }.max() ?: 0

        val lengths = IntArray(columnsCount) { index ->
            rows.map { row ->
                if (index < row.size)
                    row[index].length
                else
                    0
            }.max() ?: 0
        }

        val res: Sequence<List<String>> = rows.asSequence().map {
            row -> row.mapIndexed {
                index, elem -> elem + " ".repeat(lengths[index] - elem.length) + "\t"
            }
        }

        return borderFormatter.format(res)

    }
}