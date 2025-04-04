package topic.designpattern.behavioural.observer;

/**
 * Concrete observer (displays the temperature)
 */
public class TemperatureDisplay implements Observer{
    @Override
    public void update(int temperature) {
        System.out.println("Temperature Display updated: " + temperature + "°C");
    }
}
