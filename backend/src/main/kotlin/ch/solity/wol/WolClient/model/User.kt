package ch.solity.wol.WolClient.model

//import org.springframework.data.annotation.Id
//import org.springframework.data.mongodb.core.mapping.Document
//
//@Document
data class User(
//		@Id
		val id: Long,

		val name: String,

		val firstName: String,

		val company: String,

		val department: String
)
