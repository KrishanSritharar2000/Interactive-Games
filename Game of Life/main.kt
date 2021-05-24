import kotlin.random.Random.Default.nextBoolean


// Arguments will be:
// Num of columns
// Num of rows
fun main(args: Array<String>) {
    var rows = 10
    var cols = 10

    if (args.size >= 2) {
        cols = args[0].toInt()
        rows = args[1].toInt()
    }


    val grid : Array<Array<Boolean>> = generateGrid(rows, cols)

    }

fun generateGrid(rows: Int, cols: Int): Array<Array<Boolean>> {
    return Array(rows) { Array(cols) { nextBoolean() } }
}

fun printGrid(grid: Array<Array<Boolean>>) {
    var symbol : String
    println()
    for (row in 0 until grid.size) {
        print("|")
        for (col in 0 until grid[row].size) {
            if (grid[row][col]) {
                symbol = "1"
            } else {
                symbol = "0"
            }
            print(" $symbol |")
        }
        println("")
    }
    println()
}
