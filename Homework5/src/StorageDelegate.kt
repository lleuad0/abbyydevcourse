package main

import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

class StorageDelegate<T>(private val key: String, private val value: T) {
    private val storage by lazy { Storage() }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = storage.get(key) as T

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T){
        when (value) {
            is String -> storage.put(key, value)
            is Int -> storage.put(key, value)
            is Long -> storage.put(key, value)
            is Char -> storage.put(key, value)
            is Double -> storage.put(key, value)
            else -> throw IllegalArgumentException("Illegal type of value $value")
        }
    }

}

