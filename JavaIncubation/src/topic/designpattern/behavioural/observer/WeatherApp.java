package topic.designpattern.behavioural.observer;

public class WeatherApp implements Observer{
    @Override
    public void update(int temperature) {
        System.out.println("Weather App updated: " + temperature + "°C");
    }
}
