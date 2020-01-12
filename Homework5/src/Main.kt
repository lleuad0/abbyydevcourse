package main

fun main() {

    var int: Int by StorageDelegate("id", 20)
    println(int)
    int=15
    println(int)

    var string: String by StorageDelegate("name", "John")
    println(string)
    string="Jane"
    println(string)

    var char: Char by StorageDelegate("character", 'a')
    println(char)
    char='b'
    println(char)

    var double: Double by StorageDelegate("distance", 132.5)
    println(double)
    double=25.4
    println(double)

    var long: Long by StorageDelegate("longValue", 132L)
    println(long)
    long=25L
    println(long)

}