@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Creating contours")
@file:Order("1027")
@file:URL("creatingContours/index")

package docs.`27_Creating_contours`

import org.openrndr.application
import org.openrndr.dialogs.saveFileDialog
import org.openrndr.dokgen.annotations.*
import org.openrndr.extra.composition.composition
import org.openrndr.extra.composition.draw
import org.openrndr.extra.composition.drawComposition
import org.openrndr.extra.gui.GUI
import org.openrndr.extra.noise.uniform
import org.openrndr.extra.parameters.ActionParameter
import org.openrndr.extra.parameters.IntParameter
import org.openrndr.extra.svg.saveToFile
import org.openrndr.namedTimestamp
import java.io.File

fun main() {
    @Text
    """
    # Drawing onto the screen vs into a composition
         
    By default, OPENRNDR draws shapes directly in a window:  
  
    """.trimIndent()

    @Code
    application {
        program {
            extend {
                drawer.circle(drawer.bounds.center, 200.0)
            }
        }
    }

    @Text
    """
    But we are interested in creating designs for a pen plotter.
    Therefore we are going to create something called a `Composition`,
    which can hold many contours and shapes in it, then save the composition to disk.
    
    The previous program modified to produce an SVG file looks like this:
    """.trimIndent()

    @Code
    application {
        program {
            val myDesign = drawComposition {
                circle(drawer.bounds.center, 200.0)
            }
            myDesign.saveToFile(File("data/svg/design.svg"))
        }
    }

    @Text
    """
    This program would save the design, but not display it. Lets fix that and
    make it visible:
    """.trimIndent()

    @Code
    application {
        program {
            val myDesign = drawComposition {
                circle(drawer.bounds.center, 200.0)
            }
            myDesign.saveToFile(File("data/svg/design.svg"))

            // Render the composition on every animation frame
            extend {
                drawer.composition(myDesign)
            }
        }
    }

    @Text
    """
    Now lets add some randomness and repetition, so every time we run the program
    we get a slightly different design:
    """.trimIndent()

    @Code
    application {
        program {
            val myDesign = drawComposition {
                repeat(30) {
                    circle(drawer.bounds.center, Double.uniform(50.0, 250.0))
                }
            }
            myDesign.saveToFile(File("data/svg/design.svg"))

            // Render the composition on every animation frame
            extend {
                drawer.composition(myDesign)
            }
        }
    }

    @Text
    """
    Since we are going to be working with A5 sized papers (148 x 210 mm), lets resize the window to 
    have the correct aspect ratio:
    """.trimIndent()

    @Code
    application {
        configure {
            width = 148 * 5
            height = 210 * 5
        }
        program {
            val myDesign = drawComposition {
                repeat(30) {
                    circle(drawer.bounds.center, Double.uniform(50.0, 250.0))
                }
            }
            myDesign.saveToFile(File("data/svg/design.svg"))

            // Render the composition on every animation frame
            extend {
                drawer.composition(myDesign)
            }
        }
    }

    @Text
    """
    Restarting the program every time is not very convenient, so lets add a simple GUI.
    It will have 
    * a button to clear the design
    * a button to add elements to the design 
    * a slider to specify how many elements to add when pressing the button
    * a button to save the design
    """.trimIndent()

    @Code
    application {
        configure {
            width = 148 * 5
            height = 210 * 5
        }
        program {
            val myDesign = drawComposition {}
            val gui = GUI()
            val settings = object {
                @IntParameter("count", 1, 10)
                var count = 1

                @ActionParameter("clear")
                fun onClear() {
                    myDesign.clear()
                }

                @ActionParameter("add")
                fun onAdd() {
                    myDesign.draw {
                        val radius = Double.uniform(50.0, 250.0)
                        repeat(count) {
                            circle(drawer.bounds.center, radius + Double.uniform(-5.0, 5.0))
                        }
                    }
                }

                @ActionParameter("save")
                fun onSave() {
                    saveFileDialog(
                        suggestedFilename = program.namedTimestamp("svg", "data/svg"),
                        supportedExtensions = listOf("SVG" to listOf("svg"))
                    ) {
                        myDesign.saveToFile(it)
                    }
                }
            }

            gui.add(settings)

            extend(gui)
            extend {
                drawer.composition(myDesign)
            }
        }
    }

    @Text
    """
    With this we have the basic structure to create generative designs for pen plotters!
    
    Now lets take a look at what kind of primitives we can produce.
    """.trimIndent()


}