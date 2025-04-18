@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Repetition")
@file:Order("102")
@file:URL("kotlinLangAndTools/repetition")
@file:ParentTitle("Kotlin language and tools")
package docs.`10_Kotlin_lang_and_tools`

import org.openrndr.dokgen.annotations.*

fun main() {
    @Text
    """
    # Repetition
    
    ## repeat

    `repeat` executes the code the number of requested times.
    We can access the current iteration value with the `it` variable.
    ```kotlin
    repeat(5) {
        println(it)
    }
    ```
    outputs
    ```
    0
    1
    2
    3
    4
    ```

    ## for
    
    By using a [`for`](https://kotlinlang.org/docs/control-flow.html#for-loops) 
    loop we have more control over the start and end values.
    ```kotlin
    for(i in 10 until 20 step 2) {
        println(i)
    }
    ```
    outputs
    ```
    10
    12
    14
    16
    18
    ```

    We can use `..` instead of `until` if we want the maximum value
    to be included. `step` lets us count in steps.
    ```kotlin
    for (i in 10..30 step 2) {
        println(i)
    }
    ```
    outputs
    ```
    10
    12
    14
    16
    18
    20
    ```
    
    ## while
    
    It's also possible to use the [`while`](https://kotlinlang.org/docs/control-flow.html#while-loops) instruction
    to keep a loop going until a condition is no longer
    met. This is useful if we do not know in advance
    how many iterations we want.
    
    """.trimIndent()
}