/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.demo.helloworld

import ch.solity.wol.view.Device
import ch.solity.wol.view.DeviceView
import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport.Container(value = [  // repeatable annotations are not supported by Kotlin, please vote for https://youtrack.jetbrains.com/issue/KT-12794
    CssImport("./styles/shared-styles.css"),
    CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
])
class MainView : KComposite() {
    private lateinit var deviceView: DeviceView
    private lateinit var button: Button

    // The main view UI definition
    private val root = ui {

        button = button("wakeUp") {
            onLeftClick {
                Notification.show("Grizi")
            }
        }

        verticalLayout {
            grid<Device> {
                addColumn(Device::computername).setHeader("Computername");
                addColumn(Device::ipaddress).setHeader("IP");
                addColumn(Device::macaddress).setHeader("Mac")
                setItems(
                        listOf(Device("1", "i", "o", "sda", 5), Device("1", "i", "o", "sda", 5), Device("1", "i", "o", "sda", 5), Device("1", "i", "o", "sda", 5))
                )
                addColumn({ "Show" }, ButtonRenderer<Device>({ event -> PersonView.navigateTo(event.item) }))
            }
            val form = nameAgeForm()
            button("Click me") {
                onLeftClick {
                    Notification.show(form.greeting)
                }
            }
        }
    }

    private fun createWolButton(grid: Grid<Device>, device: Device): Button {
        val button = Button("Wake Up")
        button.onLeftClick {
            Notification.show(device.computername)
        }
        return button
    }

    init {

    }
}

class NameAgeForm : FormLayout() {
    private val nameField = textField("Computername:")
    private val ipField = textField("IP:")
    private val macField = textField("MAC:")
    private val userField = textField("User:")

    val greeting: String get() = "Waking up ${nameField.value} with ${ipField.value}"
}

fun HasComponents.nameAgeForm(block: NameAgeForm.() -> Unit = {}): NameAgeForm = init(NameAgeForm(), block)


data class Person(val name: String, val age: Int)
