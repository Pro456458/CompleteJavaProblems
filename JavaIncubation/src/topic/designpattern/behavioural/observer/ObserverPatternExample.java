package topic.designpattern.behavioural.observer;

/**
 * Example: A weather monitoring system <br><br>
 *
 * Let’s say you have a weather monitoring system that provides temperature updates, and multiple displays (observers) need to update whenever the temperature changes.<br><br>
 *
 * Explanation:<br><br>
 *         - The WeatherStation (subject) maintains a list of observers (TemperatureDisplay, WeatherApp).<br>
 *         - Whenever the temperature changes, the WeatherStation calls the notifyObservers() method to update all observers about the new temperature.<br>
 *         - Each observer implements the Observer interface and reacts to changes by updating their state (e.g., the display or app UI).<br>
 */
public class ObserverPatternExample {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // create observer
        Observer display = new TemperatureDisplay();
        Observer app = new WeatherApp();

        // register observers
        weatherStation.addObserver(display);
        weatherStation.addObserver(app);

        //change temperature and notify observers
        weatherStation.setTemperature(25); // Both observer will be notified
        weatherStation.setTemperature(30); // Both observer will be notified

    }
}
