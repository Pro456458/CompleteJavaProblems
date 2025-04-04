package topic.designpattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private List<Observer> observers = new ArrayList<>();
    private int temperature;


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(temperature);
        }
    }

    // Method to set temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers(); // Notify all observers when temperature changes
    }
}
