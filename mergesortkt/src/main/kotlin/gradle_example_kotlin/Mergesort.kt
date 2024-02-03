package gradle_example_kotlin

import java.lang.System.arraycopy

class Mergesort {

    companion object {
        @JvmStatic
        fun mergeSort(
            array: IntArray
        ) {
            if (array.size <= 1) {
                return
            }

            // Break the array in two halves
            val mid = array.size / 2
            val leftArray = IntArray(mid)
            val rightArray = IntArray(array.size - mid)
            arraycopy(array, 0, leftArray, 0, mid)
            if (array.size - mid >= 0) arraycopy(
                array, mid, rightArray,
                0, array.size - mid
            )
            mergeSort(leftArray)
            mergeSort(rightArray)
            merge(leftArray, rightArray, array)
        }

        private fun merge(
            leftArray: IntArray,
            rightArray: IntArray,
            array: IntArray
        ) {
            var i = 0
            var j = 0
            var k = 0

            // Effectively sorts left and right array
            while (i < leftArray.size && j < rightArray.size) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k++] = leftArray[i++]
                } else {
                    array[k++] = rightArray[j++]
                }
            }
            while (i < leftArray.size) {
                array[k++] = leftArray[i++]
            }
            while (j < rightArray.size) {
                array[k++] = rightArray[j++]
            }
        }
    }
}
