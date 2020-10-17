package ch.solity.wol.WolClient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WolClientApplication

fun main(args: Array<String>) {
	runApplication<WolClientApplication>(*args)
}
