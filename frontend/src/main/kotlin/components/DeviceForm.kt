package components

import com.github.mvysny.karibudsl.v10.init
import com.github.mvysny.karibudsl.v10.textField
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.formlayout.FormLayout

class DeviceForm : FormLayout() {
	private val nameField = textField("Computername:")
	private val ipField = textField("IP:")
	private val macField = textField("MAC:")
	private val userField = textField("User:")

	val greeting: String get() = "Waking up ${nameField.value} with ${ipField.value}"
}

fun HasComponents.deviceForm(block: DeviceForm.() -> Unit = {}): DeviceForm = init(DeviceForm(), block)
