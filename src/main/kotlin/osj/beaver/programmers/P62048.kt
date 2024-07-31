package osj.beaver.programmers

class P62048 {
    companion object {
        fun solution(w: Int, h: Int): Long {
            if (w == h) {
                return w.toLong() * h - w
            }

            val gcd = gcd(w.coerceAtLeast(h), w.coerceAtMost(h))
            return w.toLong() * h - (((w / gcd) + (h / gcd) - 1) * gcd)
        }

        private fun gcd(a: Int, b: Int): Int {
            if (b == 0) return a
            return gcd(b, a % b)
        }
    }
}

fun main() {
    println(P62048.solution(8, 12))
}