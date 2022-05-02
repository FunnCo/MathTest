fun main() {
    GaussSystem(
        listOf<List<Double>>(
            listOf<Double>(1.0, 0.0, -2.0, 3.0, -4.0),
            listOf<Double>(3.0, 2.0, 0.0, -5.0, 12.0),
            listOf<Double>(4.0, 3.0, -5.0, 0.0, 5.0),
            listOf<Double>(0.0, 1.0, -3.0, 4.0, -5.0)
        )
    ).getResults()

//    IterationSystem(
//        listOf<List<Double>>(
//            listOf<Double>(3.0, -1.0, -1.0, 4.0),
//            listOf<Double>(1.0, 5.0, -1.0, 2.0),
//            listOf<Double>(2.0, -1.0, -3.0, 5.0)
//        ),
//        listOf<Double>(0.0,0.0,0.0)
//    ).getResults()
}