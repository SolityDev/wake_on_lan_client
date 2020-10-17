import 'package:flutter/material.dart';
import 'package:frontend/components/device_list.dart';
import 'package:frontend/models/device.dart';

class DeviceScreen extends StatelessWidget {
  String _title;
  List<Device> devices = List();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(this._title),
          backgroundColor: Colors.black,
        ),
        body: DeviceList(this.devices)

        // body: GridView.count(
        //   crossAxisCount: 4,
        //   children: List.generate(100, (index) {
        //     return Center(
        //       child: Text(
        //         'Item $index',
        //         style: Theme.of(context).textTheme.headline5,
        //       )
        //     );
        //   })
        // )
        );
  }

  DeviceScreen(String title) {
    this._title = title ?? "WolClient";
    this.devices.add(new Device("ASD", "_username", "_mac", "_ipaddress", 1));
    this.devices.add(new Device("BDS", "_username", "_mac", "_ipaddress", 2));
  }
}
