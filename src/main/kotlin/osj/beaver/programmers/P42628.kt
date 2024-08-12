package osj.beaver.programmers

import java.util.SortedSet

class P42628 {
    companion object {
        fun solution(operations: Array<String>): IntArray {

            val set: SortedSet<Int> = sortedSetOf()

            for (i in operations.indices) {
                val (operator, value) = operations[i].split(" ")
                if (operator == "I") {
                    set.add(value.toInt())
                } else if (operator == "D") {
                    if (set.isEmpty()) {
                        continue
                    }

                    if (value == "1") {
                        set.remove(set.last())
                    } else if (value == "-1") {
                        set.remove(set.first())
                    }
                }
            }

            return if (set.isEmpty()) {
                intArrayOf(0, 0)
            } else {
                intArrayOf(set.last, set.first)
            }
        }

    }
}

fun main() {
    val operations = listOf(
        arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"),
        arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"),
    )

    for (i in operations.indices) {
        P42628.solution(operations[i]).forEach {
            print("$it ")
        }
        println()
    }
}