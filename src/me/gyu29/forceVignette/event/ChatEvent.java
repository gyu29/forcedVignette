package me.gyu29.forceVignette.event

import net.weavemc.api.event.CancellableEvent

class ChatEvent(val message: String) : CancellableEvent()