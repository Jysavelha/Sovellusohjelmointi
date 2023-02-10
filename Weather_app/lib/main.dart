import 'package:flutter/material.dart';
import 'current_weather_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Weather App",
      theme: ThemeData(
        primarySwatch: Colors.lightBlue,
      ),
      home: CurrentWeatherScreen(),
    );
  }
}
