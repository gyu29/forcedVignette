package me.gyu29.forceVignette;

import me.gyu29.forceVignette.event.InitEvent
import me.gyu29.forceVignette.event.ChatListen
import net.weavemc.api.ModInitializer
import net.weavemc.api.event.EventBus

class Main : ModInitializer {
    override fun preInit() {
        EventBus.subscribe(InitEvent::class.java) {
            EventBus.subscribe(ChatListener::class.java){
                init()
            }
        }
    }
}


private fun init() {
    EventBus.subscribe(ChatListen())
}