package defense_system.model;

import defense_system.controller.Observer;

import java.util.Collection;
import java.util.HashMap;

public class Observable {
    HashMap<Integer,Observer> map = new HashMap<>();

    Observer observer = new Observer() {
        @Override
        public void updateAreaSituation(String situation) {

        }

        @Override
        public void findStrength(StrengthLevel strength) {

        }

        @Override
        public void updateMessage(String name, String text) {

        }
    };

    private Observer[] ob = new Observer[0];

    private static Observable instance = null;

    private String name;
    private String massage;
    private String situation;

    private Observable() {}

    public void addComponent(Observer component) {
        System.out.println("Added");
        extendArray();
        ob[ob.length - 1] = component;
    }

    private void extendArray() {
        Observer[] temp = new Observer[ob.length + 1];
        for (int i = 0; i < ob.length; i++) {
            System.out.println(i);
            temp[i] = ob[i];
        }
        ob = temp;
    }

    public static Observable getInstance() {
        if (instance == null) {
            instance = new Observable();
        }
        return instance;
    }

    public void getAreaSituation(String situation) {
        this.situation = situation;
        System.out.println("Controller >> " + situation);
        observer.updateAreaSituation(this.situation);
    }

    public void getMassage(String name, String massage) {
        this.name = name;
        this.massage = massage;
        System.out.println("Controller >> " + name + ": " + massage);
        notifyMassage();
    }

    public void notifyMassage() {
        for (int i = 0; i < ob.length; i++) {
            System.out.println(i);
            ob[i].updateMessage(this.name, this.massage);
        }
    }

    public void sendStrength(double value) {
        StrengthLevel strength = value == 0 ? StrengthLevel.CLOSED : value<=25 ? StrengthLevel.LOW
                : value<=50 ? StrengthLevel.MEDIUM :
                value<=75 ? StrengthLevel.HIGH : StrengthLevel.STRONG;
        Collection<Observer> values = map.values();
        for(Observer ob : values){
            ob.findStrength(strength);
        }
    }
}