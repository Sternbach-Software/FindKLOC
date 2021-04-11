import java.io.File

fun main() {
    var wantsToRepeat = true
    while (wantsToRepeat) {
        print("Enter the pathname to the folder you would like to crawl: ")
        val pathname = readLine()!!
        print("\nEnter the extension for the files you would like to crawl (e.g. txt): ")
        val extension = readLine()!!.toLowerCase()
        println("${findKLOCinFolder(pathname, extension)} lines of code.")
        print("\nWould you like to do another one? Y or N: ")
        val repeat = readLine()!!.toLowerCase()
        if(repeat == "n") wantsToRepeat = false
    }
    println("Thank you for counting.")
}
fun findKLOCinFolder(pathname:String, extension:String):Int{
    var linesOfCode = 0
    File(pathname)
        .walk()
        .toList()
        .filter { it.extension == extension }
        .forEach {
            linesOfCode += it
                .readLines()
                .size
        }
    return linesOfCode
}