package components

import ch.solity.wol.view.Device
import com.github.mvysny.karibudsl.v10.gridContextMenu
import com.github.mvysny.karibudsl.v10.init
import com.github.mvysny.karibudsl.v10.onLeftClick
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.grid.Grid
import services.WoL


class DeviceGrid : Grid<Device>() {
	private val grid: Grid<Device> = Grid()

	init {
		grid.gridContextMenu {
			addColumn(Device::computername).setHeader("Computername")
			addColumn(Device::ipaddress).setHeader("IP")
			addColumn(Device::macaddress).setHeader("Mac")
			setItems(
					listOf(Device(1, "asdfasdf", "127.0.0.1", "f8:ff:c2:10:27:aa", 5), Device(2, "hfdhdfg", "o", "sda", 5), Device(3, "w353245", "o", "sda", 5), Device(4, "i67ighfjsd", "o", "sda", 5))
			)
			addComponentColumn { device ->
				createWolButton(device, "wake up!")
			}
		}
	}

	private fun createWolButton(device: Device, buttonText: String): Button {
		val button = Button(buttonText)

		button.onLeftClick {
			val wol = WoL()
			wol.sendWoL(device.ipaddress, device.macaddress)
		}

		return button
	}
}
fun HasComponents.createGrid(block: DeviceGrid.() -> Unit = {}): DeviceGrid = init(DeviceGrid(), block)
