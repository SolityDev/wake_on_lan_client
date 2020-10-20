package ch.solity.wol.view

import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.ClickEvent
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route(value = "device")
class DeviceView : VerticalLayout() {
    private lateinit var grid: Grid<Device>
    private lateinit var button: Button


    private fun okClicked(d: ClickEvent<Button>) {
        print(d)
    }

    init {
        setSizeFull()
        verticalLayout {
            isSpacing = true

            formLayout {
                textField("Name:") {
                    focus()
                }
                textField("Age:")
            }
            horizontalLayout {
                content { align(right, middle) }
                button("Save") {
                    onLeftClick { d -> okClicked(d) }
                    setPrimary()
                }
            }
        }
    }
}

data class Device(val ip: String, val computername: String, val ipaddress: String, val macaddress: String, val user: Int)