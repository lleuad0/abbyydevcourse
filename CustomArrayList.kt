class CustomArrayList<T> {
    private var cursor = 0
    private var elements: Array<Any?>

    constructor() {
        elements = arrayOfNulls(10)
    }

    constructor(initialCapacity: Int) {
        if (initialCapacity < 0) throw IllegalArgumentException("Invalid capacity $initialCapacity")
        elements = arrayOfNulls(initialCapacity)
    }

    private fun extendIfNeeded(needed: Int) {
        if (elements.size < needed) {
            // значения взяты из исходников Java
            elements = elements.copyOf((needed * 3) / 2 + 1)
        }
    }

    fun add(element: T) {
        extendIfNeeded(cursor + 1)
        elements[cursor] = element
        cursor++
    }

    private fun checkPosition(position: Int) {
        if (position < 0 || position > elements.size) {
            throw IndexOutOfBoundsException("Invalid index $position")
        }
    }

    fun insert(element: T, position: Int) {
        checkPosition(position)
        extendIfNeeded(cursor + 1)
        for (i in cursor downTo position + 1) {
            elements[i] = elements[i - 1]
        }
        elements[position] = element
        cursor++
    }

    fun delete(position: Int) {
        checkPosition(position)
        for (i in position until cursor - 1) {
            elements[i] = elements[i + 1]
        }
        elements[--cursor] = null
    }

    operator fun get(position: Int): T {
        checkPosition(position)
        return elements[position] as T
    }

}

