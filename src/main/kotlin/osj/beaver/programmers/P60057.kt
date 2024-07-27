package osj.beaver.programmers

import kotlin.math.min

class P60057 {
    companion object {
        fun solution(s: String): Int {
            val half = s.length / 2

            var min = s.length
            for (i in 1 .. half) {
                val result = compression(i, s)
                min = min(min, result)
            }
            return min
        }


        // 더 깔끔하지만 느림
        @Suppress("Unused")
        private fun compression2(size: Int, str: String): Int {
            val compression = mutableListOf<Pair<Int, String>>()

            val chunked = str.chunked(size)
            for (i in chunked.indices) {
                if (compression.isEmpty()) {
                    compression.add(Pair(1, chunked[i]))
                    continue
                }

                val current = compression[compression.lastIndex]
                if (chunked[i] == current.second) {
                    compression[compression.lastIndex] = Pair(current.first + 1, current.second)
                } else {
                    compression.add(Pair(1, chunked[i]))
                }
            }

            val result = compression.joinToString("") {
                val count = it.first

                if (count > 1) {
                    "$count${it.second}"
                } else {
                    it.second
                }
            }

            return result.length
        }

        // 쫌더 깔끔하게 짤수 없을까..?
        private fun compression(size: Int, str: String): Int {
            val stringBuilder = StringBuilder()

            var count = 1
            var index = size

            var current = str.substring(0 , size)
            while(index < str.length) {
                val next = if (index + size < str.length) {
                    str.substring(index, index+size)
                } else {
                    str.substring(index, str.length)
                }

                if (current == next) {
                    count++
                    index += size
                    continue
                }

                if (count > 1) {
                    stringBuilder.append("$count$current")
                } else {
                    stringBuilder.append(current)
                }

                current = next
                index += size
                count = 1
            }

            if (count > 1) {
                stringBuilder.append("$count$current")
            } else {
                stringBuilder.append(current)
            }

            return stringBuilder.toString().length
        }
    }
}

fun main() {
    val s = arrayOf(
        "aabbaccc",
        "ababcdcdababcdcd",
        "abcabcdede",
        "abcabcabcabcdededededede",
        "xababcdcdababcdcd",
    )

    s.forEach {
        println(P60057.solution(it))
    }
}