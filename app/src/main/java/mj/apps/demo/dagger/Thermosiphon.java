package mj.apps.demo.dagger;


public class Thermosiphon extends Pump {
   private final Heater heater;

    public Thermosiphon(Heater heater) {
        this.heater = heater;
    }
}
