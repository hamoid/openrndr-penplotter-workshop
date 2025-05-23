@file:Suppress("UNUSED_EXPRESSION")
@file:Title("Requirements")
@file:ParentTitle("Welcome")
@file:Order("10")
@file:URL("/requirements")

package docs

import org.openrndr.dokgen.annotations.*

fun main() {
    @Text
    """
                
    OPENRNDR currently supports desktop platforms including macOS, Windows and Linux.
    Additionally there's experimental support for running programs in web browsers via KotlinJS.
    
    ### Operating systems known to work
    
    | macOS | 10.10 up to 13, both Intel and ARM | 
    | Window | 10 and 11 | 
    | Linux | Ubuntu LTS version 18.04, 20.04, 22.04, ArchLinux, Manjaro |

    Other versions and distributions may work, but it is hard for us to verify.
    
    ### OpenGL version
    
    OPENRNDR requires a GPU that supports at least **OpenGL 3.3**. This includes relatively old ones like
    the nVidia 320M (2007) or the Intel HD4000 (2012) but excludes others like the Intel HD3000 (2011).  
    
    ### Programming languages
    
    OPENRNDR is written in [Kotlin](https://en.wikipedia.org/wiki/Kotlin_(programming_language)) 
    and intended to run on the [JVM](https://en.wikipedia.org/wiki/Java_virtual_machine). 
    We believe Kotlin offers a well-balanced programming language that is both expressive and easy to read.
    
    The library can likely be used from Java 8+ as that's one of the promises of Kotlin's Java-interop, however the APIs
    that OPENRNDR provides are making extensive use of Kotlin-specific features that may not translate well to Java.
    
    ### Development environments
    
    OPENRNDR is environment agnostic, however all our tutorial and reference material assumes 
    [Gradle](https://en.wikipedia.org/wiki/Gradle) and 
    [IntelliJ IDEA](https://www.jetbrains.com/idea/) (Community Edition) are used.
    
    ### Long-term support
    
    We have not reached the point at which we can make promises regarding API stability. OPENRNDR is pre-1.0 software, which
    implies we try not to break things, but at times we have to. At times it is better to make incompatible changes than to continue
    with inconsistencies in or incompleteness of the API.
    """
}