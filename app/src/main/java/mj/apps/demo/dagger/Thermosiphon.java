package mj.apps.demo.dagger;

import javax.inject.Inject;

public class Thermosiphon extends Pump {
   private final Heater heater;

   @Inject
    public Thermosiphon(Heater heater) {
        this.heater = heater;
    }
}
