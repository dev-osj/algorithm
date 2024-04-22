package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 184ms 20560kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val t = reader.readLine().toInt()

    val stringBuilder = StringBuilder()
    var count: Int
    repeat(t) {
        count = 0
        val str = reader.readLine().toCharArray()

        fun p25501IsPalindrome(str: CharArray, l: Int, r: Int): Int {
            count += 1
            return if (l >= r) 1
            else if (str[l] != str[r]) 0
            else p25501IsPalindrome(str, l + 1, r - 1)
        }

        val isPalindrome = p25501IsPalindrome(str, 0, str.size - 1)
        stringBuilder.appendLine("$isPalindrome $count")
    }
    writer.write(stringBuilder.toString())
    writer.close()
}
