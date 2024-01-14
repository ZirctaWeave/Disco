package me.zircta.disco.listener;

import me.zircta.disco.utils.APIUtils;
import net.weavemc.loader.api.event.ChatSentEvent;
import net.weavemc.loader.api.event.SubscribeEvent;

public class ChatListener {
    @SubscribeEvent
    public void onChat(ChatSentEvent ev) {
        if (ev.getMessage().startsWith("#")) {
            String message = ev.getMessage().substring(1).trim();
            APIUtils.sendDiscordMessage(message);
        }
    }
}
