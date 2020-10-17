import 'package:flutter/material.dart';
import 'package:frontend/models/device.dart';

class DeviceList extends StatelessWidget {
  final List<Device> _devices = List();

  DeviceList(List<Device> devices) {
    this._devices.addAll(devices ?? null);
  }

  @override
  Widget build(BuildContext context) {
    return ListView.separated(
      padding: const EdgeInsets.all(50),
      itemCount: _devices.length,
      itemBuilder: (BuildContext ctx, int index) {
        return Container(
          height: 50,
          color: Theme.of(context).accentColor,
          child: GridView.count(
              padding: const EdgeInsets.all(20.0),
              crossAxisCount: 4,
              children: this._devices[index].getDeviceAsTextList()),
        );
      },
      separatorBuilder: (BuildContext ctx, int index) => const Divider(),
    );
  }
}
