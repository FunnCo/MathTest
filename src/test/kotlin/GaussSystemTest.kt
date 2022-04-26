import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GaussSystemTest {

    @Test
    fun solve_1() {
        val testingList = listOf<List<Double>>(
            listOf(1.0, 1.0, 1.0, 3.0),
            listOf(2.0, 3.0, 2.0, 7.0),
            listOf(3.0, 1.0, 1.0, 5.0),
            listOf(5.0, -1.0, -1.0, 3.0)
        )
        val expectedResult = listOf<Double>(1.0, 1.0, 1.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_2() {
        val testingList = listOf<List<Double>>(
            listOf(1.0, -1.0, 2.0, 1.0, 2.0),
            listOf(3.0, 2.0, -1.0, -1.0, 1.0),
            listOf(1.0, 1.0, 1.0, 1.0, 2.0),
            listOf(2.0, 2.0, 1.0, 1.0, 5.0)
        )
        val expectedResult = listOf<Double>(-6.0, 9.0, 18.0, -19.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_3() {
        val testingList = listOf<List<Double>>(
            listOf(2.0, -1.0, -1.0, 4.0),
            listOf(3.0, 4.0, -2.0, 11.0),
            listOf(3.0, -2.0, 4.0, 11.0)
        )
        val expectedResult = listOf<Double>(3.0, 1.0, 1.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_4() {
        val testingList = listOf<List<Double>>(
            listOf(2.0, -1.0, 1.0, 2.0),
            listOf(3.0, 2.0, 2.0, -2.0),
            listOf(1.0, -2.0, 1.0, 1.0)
        )
        val expectedResult = listOf<Double>(2.0, -1.0, -3.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_5() {
        val testingList = listOf<List<Double>>(
            listOf(3.0, -2.0, 1.0, 0.0, 5.0),
            listOf(1.0, -1.0, 3.0, 1.0, 5.0),
            listOf(2.0, 1.0, -1.0, -2.0, 2.0),
            listOf(1.0, 0.0, 2.0, 1.0, 5.0)
        )
        val expectedResult = listOf<Double>(2.0, 1.0, 1.0, 1.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_6() {
        val testingList = listOf<List<Double>>(
            listOf(5.0, -5.0, -6.0, 1.0),
            listOf(-13.0, 4.0, 3.0, 1.0),
            listOf(7.0, 1.0, 1.0, 0.0)
        )
        val expectedResult = listOf<Double>(0.0, 1.0, -1.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_7() {
        val testingList = listOf<List<Double>>(
            listOf(1.0, 1.0, 1.0, 6.0),
            listOf(2.0, 1.0, -1.0, 1.0),
            listOf(3.0, 5.0, -3.0, 4.0)
        )
        val expectedResult = listOf<Double>(1.0, 2.0, 3.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }

    @Test
    fun solve_8() {
        val testingList = listOf<List<Double>>(
            listOf(1.0, 1.0, 1.0, 1.0, 0.0),
            listOf(1.0, 2.0, 1.0, 1.0, 2.0),
            listOf(2.0, -2.0, -2.0, -3.0, 3.0),
            listOf(2.0, 1.0, 2.0, -1.0, 1.0)
        )
        val expectedResult = listOf<Double>(0.5, 2.0, -1.5, -1.0)
        assertArrayEquals(expectedResult.toDoubleArray(), GaussSystem(testingList).solve().toDoubleArray())
    }
}