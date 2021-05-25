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


    var grid: Array<Array<Boolean>> = generateGrid(rows, cols)

    while (true) {
        print("Press a button to move a generation: ")
        readLine()!!
        println("next generation")
        grid = simulate(grid)
        printGrid(grid)
    }

}

fun simulate(grid: Array<Array<Boolean>>): Array<Array<Boolean>> {
    var liveCells: Int
    var state : Boolean
    val rows = grid.size
    val cols = grid[0].size
    var newGrid = generateGrid(rows, cols)
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            liveCells = countLiveCells(grid, row, col)
            state = grid[row][col]
            if (state && (liveCells < 2 || liveCells > 3)) {
               state = false
            } else if (!state && liveCells == 3) {
                state = true
            }
            newGrid[row][col] = state
            print(state)
        }
    }
    return newGrid
}

fun countLiveCells(grid: Array<Array<Boolean>>, row: Int, col: Int): Int {
    var total = 0
    for (i in -1..1) {
        for (j in -1..1) {
            try {
                total += getSymbol(grid[row + i][col + j])
            } catch (e: ArrayIndexOutOfBoundsException) {}
        }
    }
    total -= getSymbol(grid[row][col])
    return total
}

fun generateGrid(rows: Int, cols: Int): Array<Array<Boolean>> {
    return Array(rows) { Array(cols) { nextBoolean() } }
}

fun getSymbol(symbol: Boolean): Int {
    return (if (symbol) 1 else 0)
}

fun printGrid(grid: Array<Array<Boolean>>) {
    var symbol: String
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
