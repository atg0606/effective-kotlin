package org.atg0606.effectivekotlin.chapter1

import java.io.BufferedReader
import java.io.FileReader


fun main() {

}

class Item9 {


    fun countCharactersInFile1(path: String): Int {
        val reader = BufferedReader(FileReader(path))
        try {
            return reader.lineSequence().sumBy { it.length }
        } finally {
            reader.close()
        }
    }

    fun countCharactersInFile2(path: String): Int {
        val reader = BufferedReader(FileReader(path))
        reader.use { reader ->
            return reader.lines().mapToInt { it.length }.sum()
        }
    }

}