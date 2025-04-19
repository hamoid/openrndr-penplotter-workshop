@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Curves and shapes")
@file:ParentTitle("Creating contours")
@file:Order("150")
@file:URL("creatingContours/curvesAndShapes")

package docs.`27_Creating_contours`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.dokgen.annotations.*
import org.openrndr.draw.loadFont
import org.openrndr.extra.composition.composition
import org.openrndr.extra.composition.drawComposition
import org.openrndr.extra.shapes.hobbycurve.hobbyCurve
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import kotlin.math.sin

fun main() {
    @Text
    """
    # Curves and shapes
    
    OPENRNDR offers a lot of tools for creating and drawing two dimensional shapes.
     
    ## Segment
    
    The basic element for constructing shapes is the `Segment`:
    a Bézier curve with a start point, zero, one or two control points and an end point.
    
    In the previous chapter we learned how to use it for creating straight contours.
    """

    @Media.Image "../media/shapes-segment-001.png"

    @Application
    @ProduceScreenshot("media/shapes-segment-001.png")
    application {
        configure {
            height = 200
        }
        program {
            val font = loadFont("data/fonts/default.otf", 16.0)
            val pts = listOf(
                Vector2(50.0, 55.0),
                Vector2(100.0, height - 40.0),
                Vector2(200.0, 35.0),
                Vector2(280.0, 50.0),
                Vector2(250.0, height - 40.0),
                Vector2(500.0, 35.0),
                Vector2(550.0, height * 0.5),
                Vector2(400.0, height * 0.6),
                Vector2(450.0, height - 40.0)
            )
            val off = Vector2(10.0, 0.0)
            val off2 = Vector2(-20.0, 20.0)
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fontMap = font

                drawer.stroke = null
                drawer.fill = ColorRGBa.fromHex("#ff7990")
                drawer.circles(pts.subList(0, 2), 4.0)
                drawer.fill = ColorRGBa.fromHex("#70e1e1")
                drawer.circles(pts.subList(2, 5), 4.0)
                drawer.fill = ColorRGBa.fromHex("#ff9b41")
                drawer.circles(pts.subList(5, 9), 4.0)


                drawer.fill = ColorRGBa.BLACK
                drawer.text("start", pts[0] + off)
                drawer.text("end", pts[1] + off)
                drawer.text("Linear", pts[1] + off2)

                drawer.text("start", pts[2] + off)
                drawer.text("control point", pts[3] + off)
                drawer.text("end", pts[4] + off)
                drawer.text("Quadratic", pts[4] + off2)

                drawer.text("start", pts[5] + off)
                drawer.text("cp 1", pts[6] + off)
                drawer.text("cp 2", pts[7] + off)
                drawer.text("end", pts[8] + off)
                drawer.text("Cubic", pts[8] + off2)

                drawer.stroke = ColorRGBa.BLACK
                drawer.segment(Segment2D(pts[0], pts[1]))
                drawer.segment(Segment2D(pts[2], pts[3], pts[4]))
                drawer.segment(Segment2D(pts[5], pts[6], pts[7], pts[8]))
            }
        }
    }

    @Text
    """
    ### Constructing segments
    """

    @Code.Block
    run {
        // Linear Segment: start point, end point
        val seg1 = Segment2D(
            Vector2(50.0, 55.0),
            Vector2(100.0, 160.0)
        )

        // Quadratic Segment: start point, control point, end point
        val seg2 = Segment2D(
            Vector2(200.0, 35.0),
            Vector2(280.0, 50.0),
            Vector2(250.0, 160.0)
        )

        // Cubic Segment: start point, control point, control point, end point
        val seg3 = Segment2D(
            Vector2(500.0, 35.0),
            Vector2(550.0, 100.0),
            Vector2(400.0, 120.0),
            Vector2(450.0, 160.0)
        )
    }

    @Text
    """
    ## ShapeContour
        
    A `ShapeContour` is a collection of `Segment` instances in which each
    segment ends where the next one starts. A ShapeContour can be closed like
    the letter O or open like the letter S.
    It can be used to describe simple shapes like a square, or more complex ones.
    """

    @Media.Image "../media/shapes-shapeContour-001.png"
    @Text
    "_Three ShapeContours with 4 segments each. The one on the right is open._"

    @Application
    @ProduceScreenshot("media/shapes-shapeContour-001.png")
    application {
        configure {
            height = 160
        }
        program {
            val font = loadFont("data/fonts/default.otf", 16.0)
            val contours = listOf(
                Circle(100.0, height / 2.0, 50.0).contour,
                Rectangle.fromCenter(Vector2(280.0, height / 2.0), 100.0).contour,
                hobbyCurve(
                    listOf(
                        Vector2(400.0, 50.0),
                        Vector2(450.0, 120.0),
                        Vector2(500.0, 80.0),
                        Vector2(600.0, 130.0),
                        Vector2(550.0, 80.0)
                    )
                )
            )

            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fontMap = font

                drawer.stroke = null
                drawer.fill = ColorRGBa.PINK
                drawer.circles(contours.map { c ->
                    c.segments.map { seg -> seg.start } + c.position(1.0)
                }.flatten(), 5.0)

                drawer.fill = null
                drawer.stroke = ColorRGBa.BLACK
                drawer.contours(contours)
            }
        }
    }


    @Text
    """  
    ### Constructing a ShapeContour from primitives
                  
    `Segment`, `Circle` and `Rectangle` can be easily be converted to contours.
    
    Working with contours is nice because they 
    provide interesting methods to query their properties and to apply transformations,
    which we will discover in next sections. As an appetizer, here we create three
    different contours, place them all in one list, then draw a section of each.
    """

    @Media.Image "../media/shapes-contour-fromPrimitives-001.png"

    @Application
    @ProduceScreenshot("media/shapes-contour-fromPrimitives-001.png")
    @Code
    application {
        @Exclude
        configure {
            width = 770
            height = 250
        }
        program {
            val s = Segment2D(
                drawer.bounds.center - 100.0,
                drawer.bounds.center + 100.0
            ).contour
            val c = Circle(drawer.bounds.center, 100.0).contour
            val r = Rectangle.fromCenter(drawer.bounds.center, 100.0).contour

            val myContours = listOf(s, c, r)

            val myDesign = drawComposition {
                contours(myContours.map {
                    it.sub(0.1, 0.9)
                })
            }

            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.composition(myDesign)
            }
        }
    }

    @Text
    """
    ### Constructing a ShapeContour from points
    
    We can use `.fromPoints()` to connect points with straight segments.
    
    The `hobbyCurve` method, found in `orx-shapes`, can be used to create
    smooth curves.
    """

    @Media.Image "../media/shapes-contour-fromPoints-001.png"

    @Application
    @ProduceScreenshot("media/shapes-contour-fromPoints-001.png")
    @Code
    application {
        @Exclude
        configure {
            width = 770
            height = 200
        }
        program {
            val points = List(20) {
                Vector2(20.0 + it * 32.0, 100.0 + sin(it * 1.0) * it * 3)
            }
            val wavyContour = ShapeContour.fromPoints(points, closed = false)
            val smoothContour = hobbyCurve(points, closed = false)

            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.fill = null
                drawer.strokeWeight = 5.0
                drawer.stroke = ColorRGBa.PINK
                drawer.contour(wavyContour)

                drawer.translate(0.0, 10.0) // displace 10px down
                drawer.stroke = ColorRGBa.BLACK.opacify(0.5)
                drawer.contour(smoothContour)
            }
        }
    }
}