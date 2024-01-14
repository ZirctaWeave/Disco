package me.zircta.disco;

import me.zircta.disco.listener.ChatListener;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.EventBus;

public class Main implements ModInitializer {
    @Override
    public void preInit() {
        System.out.println("preinit");
        EventBus.subscribe(new ChatListener());
    }
}