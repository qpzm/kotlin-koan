import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = addTimeIntervals(timeInterval, 1)

data class RepeatedTimeInterval(
    val type: TimeInterval,
    val amount: Int
)

operator fun MyDate.plus(rt: RepeatedTimeInterval): MyDate =
        addTimeIntervals(rt.type, rt.amount)
operator fun TimeInterval.times(amount: Int) = RepeatedTimeInterval(this, amount)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
