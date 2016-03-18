package Senpai.YandereForge.Handlers;

import com.darkmagician6.eventapi.EventTarget;
import com.darkmagician6.eventapi.events.KeyEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by anonc on 17.03.2016.
 */

public class Kurumi {
    private final String name = getClass().getAnnotation(index.class).name();
    private final String desc = getClass().getAnnotation(index.class).desc();
    private final Nekos neko = getClass().getAnnotation(index.class).neko();
    private final String tags = getClass().getAnnotation(index.class).tags();
    private final String syntax = getClass().getAnnotation(index.class).syntax();
    private final String help = getClass().getAnnotation(index.class).help();
    private final String ModDep = getClass().getAnnotation(index.class).ModDep();
    private final int keybind = getClass().getAnnotation(index.class).keybind();
    private boolean IsModSetDepLoaded = getClass().getAnnotation(index.class).IsmodSetDepLoaded();
    private boolean enabeld;

    public enum Nekos {
        testing,
        combat;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface index {
        String name();

        String desc();

        Nekos neko();

        String tags() default "";

        String syntax() default "NØN";

        String help() default "NØN";

        // Does the meme require a mod to work at all
        String ModDep() default "";

        // Features for the mod requierd by hacks
        boolean IsmodSetDepLoaded() default false;

        int keybind() default Keyboard.KEY_NONE;
    }

    public void setEnabeld(boolean enabeld) {
        if(this.enabeld != enabeld){
        onToggle();
        }
        this.enabeld = enabeld;
        if(enabeld){
            onEnable();
        } else if(!enabeld){
            onDisable();
        }
    }
    public void onToggle(){

    }
    public void onEnable(){

    }
    public void onDisable(){

    }

    public void InitModDeps(){

    }

    public int getKeybind() {
        return keybind;
    }

    public void toggle(){
        this.setEnabeld(!this.enabeld);
    }
    public Nekos getNeko() {
        return neko;
    }


    public String getDesc() {
        return desc;
    }

    public String getHelp() {
        return help;
    }

    public String getName() {
        return name;
    }

    public String getSyntax() {
        return syntax;
    }

    public String getModDep() {
        return ModDep;
    }

    public String getTags() {
        return tags;
    }




    public boolean GetIsModSetDepLoaded() {
        return IsModSetDepLoaded;
    }

    public void setModSetDepLoaded(boolean modSetDepLoaded) {
        IsModSetDepLoaded = modSetDepLoaded;
    }
}
