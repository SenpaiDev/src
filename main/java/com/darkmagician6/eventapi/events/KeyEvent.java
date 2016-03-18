package com.darkmagician6.eventapi.events;

/**
 * Created by frostbyte on 3/18/16.
 */
public class KeyEvent implements Event{
        int key;
        public KeyEvent (int key){
        this.key = key;
        }

    public int getKey() {
        return key;
    }
}
