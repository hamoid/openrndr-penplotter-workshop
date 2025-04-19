@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Vectors")
@file:ParentTitle("Creating contours")
@file:Order("210")
@file:URL("creatingContours/vectors")

package docs.`27_Creating_contours`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.dokgen.annotations.*
import org.openrndr.extra.composition.composition
import org.openrndr.extra.composition.drawComposition
import org.openrndr.extra.shapes.primitives.regularStar
import org.openrndr.math.Polar


fun main() {
    @Text
    """
    # Vectors
    
    The `Vector2`, `Vector3` and `Vector4` classes are used for 2, 3 and 4 dimensional vector representations. 
    Vector instances are immutable; once a Vector has been instantiated its values cannot be changed.
    
    ```kotlin
    val v2 = Vector2(1.0, 10.0)
    ```
    
    ## Standard vectors
    
    ```kotlin
    Vector2.ZERO    // (0, 0)
    Vector2.UNIT_X  // (1, 0)
    Vector2.UNIT_Y  // (0, 1)    
    ```
    
    ## Vector arithmetic
    The vector classes have operator overloads for the most essential operations.
    
    left operand | operator | right operand | result
    -------------|----------|---------------|---------------------------
    `VectorN`    | `+`      | `VectorN`     | addition of two vectors
    `VectorN`    | `-`      | `VectorN`     | subtraction of two vectors
    `VectorN`    | `/`      | `Double`      | scaled vector
    `VectorN`    | `*`      | `Double`      | scaled vector
    `VectorN`    | `*`      | `VectorN`     | component-wise multiplication (l.x * r.x, l.y * r.y)
    `VectorN`    | `/`      | `VectorN`     | component-wise division (l.x / r.x, l.y / r.y)
    
    Some examples of vector arithmetic in practice
    ```kotlin
    val a = Vector2(2.0, 4.0)
    val b = Vector2(1.0, 3.0)
    val sum = a + b
    val diff = a - b
    val scale = a * 2.0
    val div = a / 2.0
    val cwdiv = a / b
    ```
    
    ## Vector properties
    
    property     | description
    -------------|-------------------------
    `length`     | the length of the vector
    `normalized` | a normalized version of the vector
    
    ## Swizzling and sizing
    
    Vector2 swizzles allow reordering of vector fields, this is a common pattern in GLSL
    
    ```kotlin
    val v3 = Vector2(1.0, 2.0).vector3(z=0.0)
    val v2 = Vector3(1.0, 2.0, 3.0).xy
    ```
    
    ## Let/copy pattern
    
    Here we present two patterns that make working with immutable Vector classes a bit more convenient.
    
    The copy pattern (which comes from Vectors being Kotlin data classes)
    
    ```kotlin
    val v = Vector2(1.0, 2.0)
    val w = v.copy(y=5.0)      // (1.0, 5.0)
    ```
    
    The let/copy pattern, which combines Kotlin's `let` with `copy`
    
    ```kotlin
    val v = someFunctionReturningAVector().let { it.copy(x=it.x + it.y) }
    ```
    
    ## Mixing
    
    Linear interpolation of vectors using `mix()`
    
    ```kotlin
    val m = mix(v0, v1, f)
    ```
    
    which is short-hand for
    ```kotlin
    val m = v0 * (1.0 - f) + v1 * f
    ```
    
    ## Randomness
    
    Generating random vectors
    
    ```kotlin
    val v2 = Vector2.uniform(-1.0, 1.0)
    ```
    
    To generate random distributions of vectors see 
    [orx-noise](https://guide.openrndr.org/ORX/noise.html).
    
    ## Creating a Vector2 using Polar coordinates    
    
    `Polar()` has two arguments: angle in degrees and radius.
    We use `.cartesian` to convert it to a `Vector2`.   
    """

    @Media.Image "../media/polar-001.png"

    @Application
    @ProduceScreenshot("media/polar-001.png")
    @Code
    application {
        configure {
            width = 770
            height = 300
        }
        program {
            val myDesign = drawComposition {
                repeat(200) {
                    val p = Polar(it * 10.0, 50.0 + it * 1.0).cartesian + 200.0
                    contour(regularStar(5, 4.0, 8.0, p, it * 1.0))
                }
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.composition(myDesign)
            }
        }
    }

    @Text
    """
    We can use `Polar.fromVector(v2)` to construct a Polar from an existing cartesian vector.
    """.trimIndent()
}