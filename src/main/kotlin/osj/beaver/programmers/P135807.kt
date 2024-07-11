package osj.beaver.programmers

class P135807 {
    companion object {
        fun solution(arrayA: IntArray, arrayB: IntArray): Int {
            if (arrayA.size == 1) {
                return if (arrayA[0] == arrayB[0]) {
                    0
                } else {
                    arrayA[0].coerceAtLeast(arrayB[0])
                }
            }

            arrayA.sortDescending()
            arrayB.sortDescending()

            var gcd1 = arrayA[0]
            var gcd2 = arrayB[0]

            for (i in 1 until arrayA.size) {
                gcd1 = gcd(gcd1, arrayA[i])
                gcd2 = gcd(gcd2, arrayB[i])
            }

            if (!arrayA.all { gcd2 != 1 && it % gcd2 != 0 }) {
                gcd2 = 0
            }
            if (!arrayB.all { gcd1 != 1 && it % gcd1 != 0 }) {
                gcd1 = 0
            }

            return gcd1.coerceAtLeast(gcd2)
        }

        private fun gcd(a: Int, b: Int): Int {
            if (b == 0) return a
            return gcd(b, a%b)
        }
    }
}

fun main() {
    val a = listOf(
        intArrayOf(10, 17),
        intArrayOf(10,20),
        intArrayOf(14, 35, 119),
    )

    val b = listOf(
        intArrayOf(5, 20),
        intArrayOf(5, 17),
        intArrayOf(18, 30, 102),
    )

    for (i in a.indices) {
        println(P135807.solution(a[i], b[i]))
    }
}