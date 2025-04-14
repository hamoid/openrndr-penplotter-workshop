@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Axidraw")
@file:Order("1080")
@file:URL("axidraw/index")
package docs.`80_Axidraw`

import org.openrndr.dokgen.annotations.*

fun main() {
    @Text
    """
    # The Axidraw pen plotter
    
    ![AxiDraw](/media/axidraw01.jpg)

    The Axidraw is a modern pen plotter that allows using many
    kinds of pens and papers.
    
    The device has two stepper motors (one on each end) and
    a servo to move the pen up and down.
    
    There is a USB cable to connect it to the computer, and
    a cable with a power supply.
    
    ![Axidraw close up](/media/axidraw15.jpg)

    It has a pause button on the left side which can be pressed
    if something is not going as it should. Later we can either
    resume (or tell it to bring the pen back home to start again).

    ![AxiDraw power button](/media/axidraw02.jpg)
    
    Some plotters have an improved servo, which is quieter and faster.
    This comes with an attachment that makes it easy to turn the device
    on and off. The horizontally movable parts can only be moved by hand
    if the stepper motors are powered off. They can be powered off via
    software.
    
    ## Software
    
    ![AxiDraw control panel](/media/axidraw50.jpg)
    
    One can send SVG designs to the AxiDraw using an Inkscape
    control panel.
    
    Alternatively, we can also use a command line tool called
    [AxiCLI](https://axidraw.com/doc/cli_api/#introduction).

    """.trimIndent()
}
