class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var cur = start

            override fun next(): MyDate {
                if(!hasNext()) throw NoSuchElementException()
                val result = cur
                cur = cur.followingDate()
                return result
            }

            override fun hasNext(): Boolean {
                return cur <= end
            }
        }
    }


}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}