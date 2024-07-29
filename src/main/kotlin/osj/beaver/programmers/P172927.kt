package osj.beaver.programmers

class P172927 {
    companion object {
        fun solution(picks: IntArray, minerals: Array<String>): Int {
            val totalCount = picks.sum()
            val totalMineral = totalCount * 5
            val convert = if (totalMineral < minerals.size) {
                minerals.toList().subList(0, totalMineral)
            } else {
                minerals.toList()
            }

            val mineralGroup: MutableList<Mineral> = mutableListOf()
            convert.chunked(5).forEach { chunk ->
                val mineral = Mineral()
                chunk.forEach {
                    when(it) {
                        "diamond" -> mineral.diamond++
                        "iron" -> mineral.iron++
                        "stone" -> mineral.stone++
                    }
                    mineral.setTotal()
                }
                mineralGroup.add(mineral)
            }

            mineralGroup.sort()


            var tired = 0

            var diamondPick = picks[0]
            var ironPick = picks[1]
            var stonePick = picks[2]

            for (i in 0 until totalCount) {
                val current = mineralGroup[i]
                if (diamondPick != 0) {
                    tired += current.diamond + current.iron + current.stone
                    diamondPick--
                } else if (ironPick != 0) {
                    tired += current.diamond * 5 + current.iron + current.stone
                    ironPick--
                } else {
                    tired += current.diamond * 25 + current.iron * 5 + current.stone
                    stonePick--
                }

                if (mineralGroup.size - 1 == i) {
                    break
                }
            }

            return tired
        }


        class Mineral: Comparable<Mineral> {
            var diamond: Int = 0
            var iron: Int = 0
            var stone: Int = 0
            var total: Int = 0

            fun setTotal() {
                total = diamond + iron + stone
            }
            override fun compareTo(other: Mineral): Int {
                return if (diamond != other.diamond) {
                    other.diamond.compareTo(diamond)
                } else if (iron != other.iron) {
                    other.iron.compareTo(iron)
                } else {
                    other.stone.compareTo(stone)
                }
            }
        }
    }
}

fun main() {
    val picks = arrayOf(
        intArrayOf(1,3,2),
        intArrayOf(0,1,1),
        intArrayOf(1,1,0),
        intArrayOf(0,0,1),
    )

    val minerals = arrayOf(
        arrayOf("diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"), // 12
        arrayOf("diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"), // 50
        arrayOf("iron", "iron", "iron", "iron", "iron", "diamond"), // 6
        arrayOf("stone", "stone", "stone", "stone", "stone", "diamond")
    )

    for (i in picks.indices) {
        println(P172927.solution(picks[i], minerals[i]))
    }
}