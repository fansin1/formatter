package formatter

import java.io.OutputStream

class BorderlessTableWriter(private val stream: OutputStream) : TableWriter {

    override fun write(rows: List<List<String>>) {
        val columnsCount = rows.map { row -> row.size }.max() ?: 0

        val lengths = IntArray(columnsCount) { index ->
            rows.map { row ->
                if (index < row.size)
                    row[index].length
                else
                    0
            }.max() ?: 0
        }

        val res = rows.asSequence().map {
            row -> row.mapIndexed {
                index, elem -> elem + " ".repeat(lengths[index] - elem.length) + "\t"
            }
        }

        with (stream.bufferedWriter()) {
            res.forEach { row ->
                row.forEach { elem ->
                    write(elem)
                }
                write("\n")
            }
            flush()
            close()
        }

    }

}