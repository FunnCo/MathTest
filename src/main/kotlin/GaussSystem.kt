class GaussSystem(val inputMatrix: List<List<Double>>) {
    fun solve(): List<Double> {
        return backwardSolve(forwardSolve())
    }



    fun forwardSolve(): List<List<Double>> {
        val resultList = mutableListOf<MutableList<Double>>()
        for (row in inputMatrix) {
            resultList.add(row.toMutableList())
        }

        // Внешний цикл, здесь производится повторение всего алгоритма, пома матрица не будет приведена к треугольному виду
        for (externalIndex in 0 until resultList.size - 1) {

            // Внутренний цикл, предназныченный для выполнения 1 цикла алгоритма
            for (internalIndex in externalIndex + 1 until resultList.size) {

                // Определение коэффициента, на который следует домножать элементы нижней строки
                val coefficient = (-resultList[internalIndex][externalIndex] / resultList[externalIndex][externalIndex])

                // Цикл для перебора всех значений в строке
                for (rowPosition in 0 until resultList[internalIndex].size) {
                    resultList[internalIndex][rowPosition] =
                        resultList[externalIndex][rowPosition] * coefficient + resultList[internalIndex][rowPosition]
                }
            }
        }

        // Уборка лишних строк, где все коэффициенты равны 0
        for (rowIndex in 0 until resultList.size) {
            var hasOnlyZero = true
            for (columnIndex in 0 until resultList[rowIndex].size) {
                if (resultList[rowIndex][columnIndex] != 0.0) {
                    hasOnlyZero = false
                    break
                }
            }
            if (hasOnlyZero) {
                resultList.removeAt(rowIndex)
            }
        }
        return resultList
    }

    fun backwardSolve(forwardedMatrix: List<List<Double>>): List<Double> {
        val resultList = mutableListOf<Double>()

        // Заполнение спсика корней нулями
        for (i in forwardedMatrix.indices) {
            resultList.add(0.0)
        }

        // Внешний цикл, определяющий порядок строк, из которых будут выражаться корни
        for (rowIndex in forwardedMatrix.size - 1 downTo 0) {

            // Переменная для хранения корня
            var root = forwardedMatrix[rowIndex][forwardedMatrix[rowIndex].lastIndex]

            // Определение корня из данной строки
            for (columnIndex in 0 until forwardedMatrix[rowIndex].size - 1) {
                if (columnIndex == rowIndex) {
                    continue
                }
                root -= forwardedMatrix[rowIndex][columnIndex] * resultList[columnIndex]
            }
            resultList.set(rowIndex, Math.round(root / forwardedMatrix[rowIndex][rowIndex]*1000000)/1000000.0)

        }

        return resultList
    }
}