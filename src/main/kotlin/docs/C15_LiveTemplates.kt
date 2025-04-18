@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Live Templates")
@file:Order("15")
@file:ParentTitle("Welcome")
@file:URL("/liveTemplates")
package docs

import org.openrndr.dokgen.annotations.*

fun main() {
    @Text
    """
    # Live Templates
        
    _Live Templates_ is an IntelliJ Idea feature that 
    expands short acronyms into full blocks of code.
        
    To install the live templates:

    1. Right click on [OPENRNDR.xml](https://raw.githubusercontent.com/openrndr/openrndr-intellij-settings/main/templates/OPENRNDR.xml) → Open In New Window
    1. On the new window, select everything except the first and the last lines.
    1. Right click on the selected text → Copy
    1. In IntelliJ Idea, go to File → Settings → Editor → Live Templates
    1. Click on + on the right side of the window to create a Template Group called OPENRNDR.
    1. Click on the new OPENRNDR group to select it.
    1. Press CTRL+V or Command+V to paste the copied XML templates into the OPENRNDR group.
    1. Close the settings window

    Now, 
    
    1. Navigate into `src/main/kotlin` on the left panel
    1. Create a file called (`plotting01.kt` for instance)
    1. type `ora` and press the `TAB` key
    
    It should get expanded into the following:
    
    ```kotlin
    fun main() = application { 
        configure { }
        program {
            extend {
                
            }
        }
    }
    ```
    
    To start writing a new program from scratch, repeat the
    last three steps.

    """.trimIndent()
}