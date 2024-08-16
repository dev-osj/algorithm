package osj.beaver.programmers

class P42579 {
    companion object {

        fun solution(genres: Array<String>, plays: IntArray): IntArray {
            val totalMap = hashMapOf<String, Int>()
            val musicList = mutableListOf<Music>()
            genres.forEachIndexed { index, s ->
                totalMap[s] = totalMap.getOrDefault(s, 0) + plays[index]
                musicList.add(Music(index, plays[index], s))
            }

            val sortedGenres = totalMap.entries.sortedByDescending { it.value }.map { it.key }
            val result = mutableListOf<Int>()
            sortedGenres.forEach {genre ->
                val top = musicList.filter { it.genre == genre }.sortedByDescending { it.play }
                val top2 = if (top.size < 2) {
                    top
                } else {
                    top.subList(0, 2)
                }.map { it.index }
                result.addAll(top2)
            }

            return result.toIntArray()
        }

        class Music(
            val index: Int,
            val play: Int,
            val genre: String,
        )

        fun solution1(genres: Array<String>, plays: IntArray): IntArray {
            val totalMap = hashMapOf<String, Int>()
            val array = Array(plays.size) { Pair("", 0) }

            genres.forEachIndexed { index, s ->
                totalMap[s] = totalMap.getOrDefault(s, 0) + plays[index]
                array[index] = Pair(s, plays[index])
            }

            val sortedGenres = totalMap.entries.sortedByDescending { it.value }.map { it.key }
            val result = mutableListOf<Int>()
            sortedGenres.forEach { genre ->
                val top = array.filter { it.first == genre }.sortedByDescending { it.second }
                val top2 = if (top.size < 2) {
                    top
                } else {
                    top.subList(0, 2)
                }

                top2.forEach {
                    result.add(array.indexOf(it))
                }
            }

            return result.toIntArray()
        }
    }
}

fun main() {
    val genres = listOf(
        arrayOf("classic", "pop", "classic", "classic", "pop"),
        arrayOf("classic", "classic", "classic", "pop"),
    )

    val plays = listOf(
        intArrayOf(500, 600, 150, 800, 2500),
        intArrayOf(500, 150, 800, 2500),
    )

    for (i in genres.indices) {
        P42579.solution(genres[i], plays[i]).forEach {
            print("$it ")
        }
        println()
    }
}