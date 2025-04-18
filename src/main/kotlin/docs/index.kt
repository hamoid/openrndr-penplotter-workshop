@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Welcome")
@file:Order("0")
@file:URL("/index")
package docs

import org.openrndr.dokgen.annotations.*

fun main() {
    @Text
    """
    # Welcome
        
    Hello everyone! 
    
    ## Introductions 
    
    * What's your name and where do you come from? 
    * Do you use any creative coding framework? 
    * What kind of visuals would you like to create?
    * Have you played with a pen plotter before? 
    
    ## Glossary

    ### AxiDraw
    
    A hardware device created by Evil Mad Scientist (now called Bantam Tools). 
    A pen plotter which moves a pen in 3 dimensions, usually to draw things 
    on paper. Cables: power supply + USB. Can be driven from Linux, Mac 
    and Windows. The easiest way to plot with it is from Inkscape using 
    a control panel written with Python.
    
    ### AxiCLI
    
    A command line tool to talk to the Axidraw in the console / terminal.
    This is an alternative to the Inkscape control panel.
    
    ### OPENRNDR
    
    The creative coding framework we will use in this workshop. 
    It includes many tools to create, query and manipulate lines and curves.
    
    ### Kotlin
    
    The programming language OPENRNDR uses. It’s readable, expressive, typed. 
    It can be used in Java projects, which means one can write Processing
    programs with Kotlin. 
    
    ### Gradle
    
    OPENRNDR is actually a collection of packages (for things like 
    drawing, math, video, shapes). Gradle is the tool that 
    downloads those packages, combines them with your source code
    and runs the result.
    
    ### IntelliJ IDEA
    
    The programming IDE we will use to write and run OPENRNDR programs. 
    Uses Kotlin and Gradle.

    _AxiCLI, OPENRNDR, Kotlin, Gradle and IntelliJ IDEA Community Edition are all free open source_.

    """.trimIndent()
}