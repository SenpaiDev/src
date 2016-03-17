package senpai.loli;

import net.minecraftforge.fml.common.Loader;
import org.reflections.Reflections;
import senpai.Kurunmis.HammerNuker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

/**
 * Created by frostbyte on 3/16/16.
 */
public class KurumiManager {
    private final TreeMap<String, Kurunmi> Kurunmis = new TreeMap<String, Kurunmi>(
            new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });

    public KurumiManager() throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("senpai.Kurunmis");
        Set<Class<? extends Kurunmi>> classes = reflections.getSubTypesOf(Kurunmi.class);
        for (Class<? extends Kurunmi> class1 : classes) {
            Kurunmi kurunmi = class1.newInstance();
            if(kurunmi.getModDep().length() < 1){
                if(kurunmi.getModSetDep().length() < 1){
                    System.out.println(kurunmi.getName() + " Has no additional Settings and was fully loaded");
                } else if(Loader.isModLoaded(kurunmi.getModSetDep())){
                    System.out.println(kurunmi.getName() + " Has Additional features for the mod " + kurunmi.getModSetDep() + "they where loaded" );
                    kurunmi.setModSetDepLoaded(true);
                } else {
                    System.out.println(kurunmi.getName() + " Has additional features for the mod " + kurunmi.getModSetDep() + " You need to install this mod to use them");
                }
                System.out.println(kurunmi.getName() +", has no mod dependancys and was loaded");
                System.out.println(kurunmi.GetIsModSetDepLoaded() ? "yes" : "no");
                Kurunmis.put(kurunmi.getName(), kurunmi);
            } else if(Loader.isModLoaded(kurunmi.getModDep())){
                System.out.println(kurunmi.getName() + "'s dependency of " + kurunmi.getModDep() + " was found and loaded");
                Kurunmis.put(kurunmi.getName(), kurunmi);
            } else {
                System.out.println(kurunmi.getName() + " Is dependent on " + kurunmi.getModDep() + " Please install this mod to use this feature");
            }

        }
    }

    public Kurunmi getKurunmiByName(String name){
        return Kurunmis.get(name);
    }
    public Collection<Kurunmi> getAllKurunmis(){
        return Kurunmis.values();
    }
    public int CountKurunmis(){
        return Kurunmis.size();
    }
}
