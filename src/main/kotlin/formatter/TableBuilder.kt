package formatter

import java.io.OutputStream

class TableBuilder(private val writer: TableWriter) {

    companion object {
        fun create(stream: OutputStream): TableBuilder {
            return TableBuilder(BorderlessTableWriter(stream))
        }
    }

    private val rows = mutableListOf<List<String>>()

    fun<T> add(vararg values: T) {
        rows.add(values.asSequence().map { it.toString() }.toList())
    }

    fun removeAt(index: Int) {
        rows.removeAt(index)
    }

    fun write() {
        writer.write(rows)
    }
}