package ch.solity.wol.WolClient.model

//import org.springframework.data.annotation.Id
//import org.springframework.data.mongodb.core.mapping.Document
//
//@Document
data class Device (
//		@Id
		val id: Long,

		val name: String,

		val macAddress: String,

		val ipAddress: String,

		val user: Long
)
