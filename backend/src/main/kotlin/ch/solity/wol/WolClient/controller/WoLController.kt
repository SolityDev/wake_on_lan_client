package ch.solity.wol.WolClient.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/api")
class WoLController {


	@GetMapping("devices")
	fun getDevices(): ResponseEntity<List<DeviceResponse>> {
		return ResponseEntity.ok(listOf(DeviceResponse(1, "device1", "E8:...", "192.168.1.1", 0)))
	}

	@GetMapping("devices/{id}")
	fun getDevices(@PathVariable id: String): ResponseEntity<DeviceResponse> {
		return ResponseEntity.ok(DeviceResponse(1, "device1", "E8:...", "192.168.1.1", 0))
	}
}

data class DeviceResponse(
		val id: Long,
		val name: String,
		val macAddress: String,
		val ipAddress: String,
		val user: Long
)
