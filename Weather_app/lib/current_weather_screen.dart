import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class CurrentWeatherScreen extends StatefulWidget {
  @override
  State<CurrentWeatherScreen> createState() => _CurrentWeatherScreenState();
}

class _CurrentWeatherScreenState extends State<CurrentWeatherScreen> {
  String cityName = "Tampere";
  String currentWeather = "Cloudy";
  double temperature = 0;
  double windSpeed = 0;
  String icon = "01d";

  void fetchWeatherData() async {
    Uri uri = Uri.parse(
        'https://api.openweathermap.org/data/2.5/weather?q=Tampere&units=metric&appid=dd2323aadd445c33c32787ef492f4e02');
    var response = await http.get(uri);
    if (response.statusCode == 200) {
      var weatherData = json.decode(response.body);

      setState(() {
        temperature = weatherData['main']['temp'];
        currentWeather = weatherData['weather'][0]['description'];
        windSpeed = weatherData['wind']['speed'];
        icon = weatherData['weather'][0]['icon'];
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(cityName),
      ),
      body: Center(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Text(currentWeather, style: const TextStyle(fontSize: 40)),
          Text("$temperature C", style: const TextStyle(fontSize: 40)),
          Text("$windSpeed m/s", style: const TextStyle(fontSize: 40)),
          Image.network('http://openweathermap.org/img/wn/' + icon + '@2x.png'),
          ElevatedButton(
            onPressed: () {
              fetchWeatherData();
            },
            child: const Text("Hae säätiedot", style: TextStyle(fontSize: 30)),
          )
        ],
      )),
    );
  }
}
