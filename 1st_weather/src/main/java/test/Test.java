package test

import weathermachine.WeatherData;

public class Test{
    public static void main(string[] args){
        SeedingMachine seedingMachine   = new SeedingMachine();
        ReapingMachine reapingMachine   = new ReapingMachine();
        WateringMachine wateringMachine = new WateringMachine();
        WeatherData weatherData= new WeatherData(seedingMachine, reapingMachine, wateringMachine)
    }
}