package services

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress


class WoL {

	private val port = 9

	fun sendWoL(ipStr: String, macStr: String) {
		val macBytes = getMacBytes(macStr)
		val bytes = ByteArray(6 + 16 * macBytes.size)

		for (i in 0..5) {
			bytes[i] = 0xff.toByte()
		}

		var i = 6
		while (i < bytes.size) {
			System.arraycopy(macBytes, 0, bytes, i, macBytes.size);
			i += macBytes.size
		}

		val address = InetAddress.getByName(ipStr)
		val packet = DatagramPacket(bytes, bytes.size, address, port)
		val socket = DatagramSocket()

		socket.use {
			socket.send(packet)
			socket.close()
			print("send magic packet to $ipStr")
		}
	}

	@Throws(IllegalArgumentException::class)
	private fun getMacBytes(macString: String): ByteArray {
		val result = ByteArray(6)

		val hex: List<String> = macString.split(":")

		if (hex.size != 6) {
			throw IllegalArgumentException("invalid MAC Address!")
		}

		try {
			for (i in 0 until 6) {
				result[i] = Integer.parseInt(hex[i], 16).toByte()
			}
		} catch (e: NumberFormatException) {
			throw IllegalArgumentException("invalid hex digit in MAC address.")
		}

		return result
	}
}
