package formatter

interface TableWriter {
    fun write(rows: List<List<String>>)
}