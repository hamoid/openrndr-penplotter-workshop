@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Drawing SVG")
@file:ParentTitle("Drawing")
@file:Order("160")
@file:URL("drawing/drawingSVG")

package docs.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.dokgen.annotations.*
import org.openrndr.math.Vector2
import org.openrndr.shape.*
import org.openrndr.svg.loadSVG
import org.openrndr.svg.saveToFile
import java.io.File

fun main() {
    @Text 
    """
    # Creating SVG files
    
    ## Composition Drawer
    
    OPENRNDR has a convenient interface for creating Compositions. The idea behind this
    interface is that it works in a similar way to `Drawer`.
     
    Note that when issuing drawing operations inside a `drawComposition`, the results are
    being sent to the screen, but to a vector data structure which we can later display
    or save.
    
    """

    @Code.Block
    run {
        val compo = drawComposition {
            fill = ColorRGBa.PINK
            stroke = ColorRGBa.BLACK
            circle(Vector2(100.0, 100.0), 50.0)
        }

        drawer.composition(compo)
    }

    @Text 
    """
    ### Transforms
        
    Transforms work in the same way as in `Drawer`
    """
    @Code.Block
    run {
        val compo = drawComposition {
            fill = ColorRGBa.PINK
            stroke = ColorRGBa.BLACK
            isolated {
                for (i in 0 until 100) {
                    circle(Vector2(0.0, 0.0), 50.0)
                    translate(50.0, 50.0)
                }
            }
        }
    }

    @Text 
    """
    Loading and saving compositions
    
    Compositions can be loaded and saved as SVG as follows:
    """

    @Code.Block
    run {
        // -- load in a composition
        val composition = loadSVG("data/example.svg")
        composition.saveToFile(File("output.svg"))
    }

}