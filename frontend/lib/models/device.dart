import 'dart:html';

import 'package:flutter/material.dart';

class Device {
  final String _computername;
  final String _username;
  final String _mac;
  final String _ipaddress;
  final int _id;

  Device(this._computername, this._username, this._mac, this._ipaddress, this._id);

  int get id => _id;

  String get ipaddress => _ipaddress;

  String get mac => _mac;

  String get username => _username;

  String get computername => _computername;

  List<Text> getDeviceAsTextList(){
    List<Text> result =  new List();

    result.addAll([Text(this.computername, textAlign: TextAlign.center), Text(this.username), Text(this.ipaddress), Text(this.mac)]);

    return result;
  }

}
