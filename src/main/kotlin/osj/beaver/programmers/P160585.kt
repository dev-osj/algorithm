package osj.beaver.programmers

class P160585 {
    companion object {

        fun solution(board: Array<String>): Int {
            var oCount = 0
            var xCount = 0
            val win = mutableSetOf<Char>()

            for (i in board.indices) {
                for (j in board[i].indices) {
                    val current = board[i][j]
                    var isWin = false
                    if (i == 0 && j == 0){
                        isWin = isWin(board, i, j, "RD")
                    }
                    if (!isWin && i == 0 && j == 2) {
                        isWin = isWin(board, i, j, "LD")
                    }
                    if (!isWin && i == 0) {
                        isWin = isWin(board, i, j, "D")
                    }
                    if (!isWin && j == 0) {
                        isWin = isWin(board, i, j, "R")
                    }

                    if (isWin) {
                        win.add(current)
                    }

                    if (current == 'O') {
                        oCount++
                    } else if (current == 'X') {
                        xCount++
                    }
                }
            }

            if (oCount < xCount) {
                return 0
            }

            if (oCount - xCount > 1) {
                return 0
            }

            if (win.size == 2) {
                return 0
            }

            if (win.isNotEmpty()) {
                if (win.first() == 'O' && oCount - xCount != 1) {
                    return 0
                }

                if (win.first() == 'X' && oCount - xCount != 0) {
                    return 0
                }
            }


            return 1
        }

        private fun isWin(board: Array<String>, i: Int, j: Int, direction: String): Boolean {
            val current = board[i][j]
            if (current == '.') {
                return false
            }

            var newI = i
            var newJ = j

            repeat(2) {
                when (direction) {
                    "D" -> {newI++}
                    "R" -> {newJ++}
                    "RD" -> {
                        newI++
                        newJ++
                    }
                    "LD" -> {
                        newI++
                        newJ--
                    }
                }

                if(current != board[newI][newJ]) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
    val board = listOf(
//        arrayOf("O.X", ".O.", "..X"), // 1
//        arrayOf("OOO", "...", "XXX"), // 0
//        arrayOf("...", ".X.", "..."), // 0
//        arrayOf("...", "...", "..."), // 1
//        arrayOf("OO.", "XXX", "OO."), // 0
//        arrayOf("XXO", "XOX", "OOO"), // 1
//        arrayOf("OXX", "XOX", "OOO"), // 1
//        arrayOf("OXO", "XOX", "OXO"), // 1
//        arrayOf("OOX", "XXO", "OOX"), // 1
//        arrayOf("XXX", ".OO", "O.."), // 1
//        arrayOf("OX.", ".O.", ".XO"), // 1
//        arrayOf("...", "...", ".O."), // 1
//        arrayOf("X.X", "X.O", "O.O"), // 1
//        arrayOf("XO.", "OXO", "XOX"), // 1
//        arrayOf("OOO", "XOX", "XXO"), // 1
//        arrayOf("OOO", "XOX", "X.X"), // 0
//        arrayOf("XXX", "OO.", "OO."), // 0
//        arrayOf(".X.", "...", "..."), // 0
//        arrayOf(".X.", "X..", ".O."), // 0
//        arrayOf("XOX", "OXO", "XOX"), // 0
//        arrayOf("XXX", "XOO", "OOO"), // 0
//        arrayOf("OOX", "OXO", "XOO"), // 0
        arrayOf("OOX", "OXO", "XOX"), // 0
        arrayOf(".OX", "OXO", "XO."), // 0
//        arrayOf("OOO", "XX.", "X.."), // 0
    )

    board.forEach {
        print("${P160585.solution(it)} ")
    }
}