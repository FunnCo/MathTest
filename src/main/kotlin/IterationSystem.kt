class IterationSystem(private val inputMatrix: List<List<Double>>, private val initRoots: List<Double>) {

    private val EPSILON = 0.000001
    private val ROUND_COEFFICIENT = 100000.0

    var iteration = 1
    private fun printTempResults(tempResults: List<Double>){
        print("($iteration)  \t")
        for(i in tempResults.indices){
            print("${tempResults[i]} ")
        }
        iteration++
        println()
    }

    fun getResults(): List<Double>{
        // Проверка услоия сходимости
        for(i in inputMatrix.indices){
            var rowSum = 0.0
            for(j in 0 until inputMatrix[i].size-1){
                if(i!=j){
                    rowSum+=Math.abs(inputMatrix[i][j])
                }
            }
            if(rowSum > Math.abs(inputMatrix[i][i])){
                throw Exception("Условие сходимости не выполняется")
            }
        }
        return solve(initRoots)
    }

    fun solve(previousRoots: List<Double>): List<Double>{
        val resultRoots = mutableListOf<Double>()

        for(i in previousRoots.indices){
            var root = inputMatrix[i].last()
            for(j in 0 until inputMatrix[i].size-1){
                if(i != j) {
                    root -= inputMatrix[i][j] * previousRoots[j]
                }
            }
            resultRoots.add(Math.round(1/inputMatrix[i][i]*root*ROUND_COEFFICIENT)/ROUND_COEFFICIENT)
        }

        // Тут проверка на точность ответа
        for (i in resultRoots.indices){
            if(Math.abs(resultRoots[i] - previousRoots[i]) > EPSILON){
                printTempResults(resultRoots)
                return solve(resultRoots)
            }
        }
        println("Ответ:")
        printTempResults(resultRoots)
        iteration = 0
        return resultRoots
    }
}