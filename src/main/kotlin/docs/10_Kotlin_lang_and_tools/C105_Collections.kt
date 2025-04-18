@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Collections")
@file:Order("105")
@file:ParentTitle("Kotlin language and tools")
@file:URL("kotlinLangAndTools/collections")
package docs.`10_Kotlin_lang_and_tools`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.dokgen.annotations.*
import org.openrndr.extra.noise.Random
import org.openrndr.extra.noise.scatter
import org.openrndr.extra.noise.uniform
import org.openrndr.extra.shapes.regularPolygon
import org.openrndr.shape.Circle
import org.openrndr.shape.Segment

fun main() {
    @Text """
    # Collections
    
    Loops in other languages are often used to
    construct or manipulate collections.
    
    In Kotlin we have many instructions that
    facilitate working with collections and 
    make loops unnecessary.    
    """

    @Media.Image "../media/list-001.png"

    @Application
    @ProduceScreenshot("media/list-001.png")
    @Code
    application {
        @Exclude
        configure {
            width = 770
            height = 400
        }
        program {
            val c = List(20) {
                Circle(drawer.bounds.center, 1.0 + it * it)
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.circles(c)
            }
        }
    }

    @Text
    """
    Here an example of randomly dropping elements from
    a list.
    """.trimIndent()

    @Media.Image "../media/list-002.png"

    @Application
    @ProduceScreenshot("media/list-002.png")
    @Code
    application {
        @Exclude
        configure {
            width = 770
            height = 400
        }
        program {
            val c = List(200) {
                Circle(drawer.bounds.center, 1.0 + it * 2)
            }.filter {
                Random.bool(0.25)
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.circles(c)
            }
        }
    }

    @Text
    """
    ## Mapping
        
    With mapping we can convert a list into a different list
    with the same number of elements.
    """.trimIndent()

    @Code.Block
    run {
        val numbers = List(10) { it }
        val words = numbers.map { "hello" }
        val largerNumbers = numbers.map { it * 3 }
        println(largerNumbers)
    }

    @Text
    """
    Next lets use mapping for something much more meaningful:
    we will obtain a list of random points, and we
    will map those points to pentagons.
    """.trimIndent()

    @Media.Image "../media/list-004.png"

    @Application
    @ProduceScreenshot("media/list-004.png")
    @Code
    application {
        @Exclude
        configure {
            width = 770
            height = 400
        }
        program {
            val points = drawer.bounds.scatter(40.0, distanceToEdge = 50.0)
            val pentagons = points.map {
                regularPolygon(5, it, 30.0, Double.uniform(0.0, 360.0))
            }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.contours(pentagons)
            }
        }
    }

    @Text
    """
    ## Flatten
        
    Sometimes we will map each item in a list to a new list,
    which will give us a list of lists. Methods like
    `drawer.contours` only can take a one-dimensional list
    as an argument, therefore in those case we should apply
    the `flatten()` operation to the list.    
    """.trimIndent()

    @Media.Image "../media/list-005.png"

    @Application
    @ProduceScreenshot("media/list-005.png")
    @Code
    application {
        @Exclude
        configure {
            width = 770
            height = 400
        }
        program {
            val base = List(10) {
                Circle(drawer.bounds.center, Double.uniform(50.0, 350.0)).contour
            }
            val hairs = base.map { circle ->
                List(200) {
                    val t = it / 200.0
                    val point = circle.position(t)
                    val normal = circle.normal(t)
                    Segment(point, point + normal * 30.0).contour
                }
            }.flatten().filter { Random.bool(0.5) }
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.contours(base)
                drawer.contours(hairs)
            }
        }
    }

}