package defense_system.controller;

import defense_system.model.StrengthLevel;

public interface Observer {
    void updateAreaSituation(String situation);
    void findStrength(StrengthLevel strength);
//    void sendStrength(double level);
    void updateMessage(String name, String text);
}