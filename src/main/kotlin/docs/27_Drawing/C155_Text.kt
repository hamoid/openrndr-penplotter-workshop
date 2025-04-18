@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Text")
@file:ParentTitle("Drawing")
@file:Order("155")
@file:URL("drawing/text")

package docs.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.dokgen.annotations.*
import org.openrndr.draw.font.loadFace
import org.openrndr.draw.loadFont
import org.openrndr.extra.shapes.rectify.rectified
import org.openrndr.shape.LineSegment

import org.openrndr.shape.Rectangle
import org.openrndr.writer
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    @Text
    """
    # Drawing text
    
    OPENRNDR comes with support for rendering bitmap text, but
    for plotting purposes we are more interested in drawing the contours of fonts.

    ### Working with text contours
    
    To load the vector data of a font file use the `loadFace()` method,
    then call the `.glyphForCharacter()` method to obtain a 
    [Shape](https://guide.openrndr.org/drawing/curvesAndShapes.html#shape) representing
    a character.
    """

    @Media.Image "../media/text-004.jpg"

    @Application
    @ProduceScreenshot("media/text-004.jpg")
    @Code
    application {
        program {
            val face = loadFace("data/fonts/default.otf")
            val shape = face.glyphForCharacter(character = '8').shape(size = 750.0)

            extend {
                drawer.clear(ColorRGBa.WHITE)
                // Center the shape on the screen
                drawer.translate(drawer.bounds.center - shape.bounds.center)

                drawer.fill = null
                drawer.strokeWeight = 2.0

                // Draw each contour found in the character '8' with a different color
                shape.contours.forEachIndexed { i, it ->
                    drawer.stroke = listOf(ColorRGBa.PINK, rgb(0.33), rgb(0.66))[i]
                    drawer.contour(it)
                }
            }
        }
    }

    @Text
    """    
    This example visualizes normal vectors around the contour of
    the character '8', evenly spaced every 10 pixels.
    """

    @Media.Image "../media/text-005.jpg"

    @Application
    @ProduceScreenshot("media/text-005.jpg")
    @Code
    application {
        program {
            val face = loadFace("data/fonts/default.otf")
            val shape = face.glyphForCharacter('8').shape(750.0)

            // Map each contour in the shape to a list of LineSegment,
            // then combine the resulting lists by calling `.flatten()`.
            val normals = shape.contours.map { c ->
                // Work with rectified contours so `t` values are evenly spaced.
                val rc = c.rectified()
                val stepCount = (c.length / 10).toInt()
                List(stepCount) {
                    val t = it / stepCount.toDouble()
                    LineSegment(
                        rc.position(t) + rc.normal(t) * 5.0,
                        rc.position(t) + rc.normal(t) * 20.0
                    )
                }
            }.flatten()
            extend {
                drawer.clear(ColorRGBa.WHITE)
                drawer.translate(drawer.bounds.center - shape.bounds.center)

                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.shape(shape)

                drawer.stroke = ColorRGBa.BLACK
                drawer.strokeWeight = 2.0
                drawer.lineSegments(normals)
            }
        }
    }

}
