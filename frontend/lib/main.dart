import 'package:flutter/material.dart';
import 'package:frontend/screens/devices.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Solity WakeOnLan',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      initialRoute: '/',
      routes: <String, WidgetBuilder>{
        "/": (BuildContext context) => DeviceScreen('Solity WakeOnLan Web Client')
      }
    );
  }
}

