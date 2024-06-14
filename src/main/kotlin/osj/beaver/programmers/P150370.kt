package osj.beaver.programmers

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.StringTokenizer

class P150370 {
    companion object {

        fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
            val termMap = terms.associate { it.substring(0, 1) to it.substring(1).trim().toLong() }.toMap()

            val dateFormat = DateTimeFormatter.ofPattern ("yyyy.MM.dd")
            var stringTokenizer: StringTokenizer
            val expireDay = privacies.map { s ->
                stringTokenizer = StringTokenizer(s)
                val localDate = LocalDate.parse(stringTokenizer.nextToken(), dateFormat)
                val term = stringTokenizer.nextToken()
                localDate.plusMonths(termMap[term] ?: 0)
            }

            val now = LocalDate.parse(today, dateFormat)
            return expireDay.indices.filter {
                now.isAfter(expireDay[it]) || now.equals(expireDay[it])
            }.toIntArray()
        }

        fun solution2(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
            val termMap = terms.map { it.split(" ") }.associate { (key, value) -> key to value.toInt() }.toMap()
            return privacies.indices.filter {
                val (date, term) = privacies[it].split(" ")
                date.split(".").map(String::toInt)
                     .let { (year, month, day) -> (year * 12 * 28) + (month * 28) + day + termMap.getOrDefault(term, 0) * 28 } <=
                         today.split(".").map(String::toInt).let { (year, month, day) -> (year * 12 * 28) + (month * 28) + day }
            }.map { it + 1 }.toIntArray()
        }
    }
}

fun main() {
    val today = listOf("2022.05.19", "2020.01.01")
    val terms = listOf(
        arrayOf("A 6", "B 12", "C 3"),
        arrayOf("Z 3", "D 5"),
    )
    val privacies = listOf(
        arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"),
        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"),
    )

    repeat(2) {
        P150370.solution(today[it], terms[it], privacies[it]).forEach { result -> print("$result, ") }
        P150370.solution2(today[it], terms[it], privacies[it]).forEach { result -> print("$result, ") }
        println()
    }
}