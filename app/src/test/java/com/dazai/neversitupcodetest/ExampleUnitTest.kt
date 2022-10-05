package com.dazai.neversitupcodetest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testFibonancci(){
        generateFibonacci()
    }

    @Test
    fun testPrimeNumbers(){
        generatePrimeNumbers()
    }

    @Test
    fun testArrayDiff(){
        filterArray()
    }

    private fun generateFibonacci(){
        val n = 8
        var t1 = 0
        var t2 = 1
        var allItems = mutableListOf(t1)

        for (i in 1..n) {
            val sum = t1 + t2
            t1 = t2
            t2 = sum
            allItems.add(t1)
           // allItems.add(t2)
        }
        print("all numbers ${allItems.joinToString(",")}")
    }

    fun generatePrimeNumbers(){
        val li = mutableListOf<Int>()
        for (num in 2..19) {
            if ((2 until num).none{ num % it == 0 })
                li.add(num)
        }
        print("prime numbers ${li.joinToString(",")}")
    }

    fun filterArray(){
        val firstArray = arrayOf(1,2,3,4,5)
        val secondArray = arrayOf(1,2,3,4,5,6,7,8)
        val result = secondArray.toList().minus(firstArray.toList().toSet())
        print("array elements $result")
    }

}