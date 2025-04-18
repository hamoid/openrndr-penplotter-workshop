@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Introduction to Kotlin")
@file:ParentTitle("Kotlin language and tools")
@file:Order("100")
@file:URL("kotlinLangAndTools/kotlinLanguageIntro")

package docs.`10_Kotlin_lang_and_tools`

import org.openrndr.dokgen.annotations.*

fun main() {
    @Text
    """
    # The Kotlin programming language
    
    Kotlin is a modern, readable and fun language, perfect for
    creative coding.
    
    You can test simple code in the official online editor found at
    [play.kotlinlang.org](https://play.kotlinlang.org/). 
    There we can run text-based programs 
    and study the output without downloading anything.  
        
    If you are already familiar with another programming language
    take a quick look at the 
    [basic syntax](https://kotlinlang.org/docs/basic-syntax.html#program-entry-point).
    
    From the [Official documentation](https://kotlinlang.org/docs/home.html)
    explore the *Basics*, *Concepts* and *Standard Library* sections.
    Data structures like `List`, `Map` and `Set` are explained under the
    *Standard Library* section and they are one of the aspects that make
    working with Kotlin enjoyable. Check them out!
    
    ## Program entry point

    An entry point of a Kotlin application is the `main` function:

    ```kotlin
    fun main() {
        println("Hello world!")
    }
    ```
    
    ## Print to the standard output
    
    `println` prints its argument to the standard output:
    
    ```kotlin
    println("Hello world!")
    println(42)
    ```
    
    ## Variables

    In Kotlin, you declare a variable starting with a keyword, `val` or `var`, 
    followed by the name of the variable.

    Use `val` to declare variables that are assigned a value only once. 
    These are immutable, read-only local variables that can’t be 
    reassigned a different value after initialization:
    
    ```kotlin
    val x: Int = 5
    x = 6 // error
    ```
    
    Use the `var` keyword to declare variables that can be reassigned. 
    These are mutable variables, and you can change their values after 
    initialization:
   
    ```kotlin
    var x: Int = 5
    x = 6 // OK
    ```
    
    Kotlin supports type inference and automatically identifies the 
    data type of a declared variable. When declaring a variable, 
    you can omit the type after the variable name:
    
    ```kotlin
    var x = 5
    ```
    
    ## Comments
    
    Just like most modern languages, Kotlin supports single-line 
    (or end-of-line) and multi-line (block) comments:
    
    ```kotlin
    // This is an end-of-line comment

    /* This is a block comment
       on multiple lines. */
    ```
    
    ## Conditional expressions
    
    ```kotlin
    if(treeCount > 100) {
        println(":-)")
    } else {
        println("More trees please!")
    }
    
    val b = if(a > 5) 100 else 200
    ```
    
    ## When expressions
    
    Similar to `switch` in other languages.
    
    ```kotlin
    val a = when(b) {
        0 -> "zero"
        1 -> "one"
        else -> "so many"
    }
    ```
    
        
    """.trimIndent()

}