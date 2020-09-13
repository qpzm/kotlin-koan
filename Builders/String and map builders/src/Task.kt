import java.util.HashMap

fun <K, V> buildMap(build: HashMap<K, V>.() -> Unit): HashMap<K, V> {
    val hash = HashMap<K, V>()
    hash.build()
    return hash
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
