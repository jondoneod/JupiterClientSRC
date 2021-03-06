package io.github.ytboy.jupiter.modules;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.github.ytboy.jupiter.event.EventPostUpdate;
import io.github.ytboy.jupiter.event.EventPreUpdate;
import io.github.ytboy.jupiter.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketAnimation;

public class Sprint extends Module {
	public Sprint() {
		super("Sprint", "Automatically sprints", Keyboard.KEY_O, Category.MOVEMENT);

	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}

	@EventTarget
	public void onPostUpdate(EventPostUpdate e) {
		if (getMC().gameSettings.keyBindForward.isKeyDown()||
			getMC().gameSettings.keyBindLeft.isKeyDown()   ||
			getMC().gameSettings.keyBindRight.isKeyDown()  ||
		 	getMC().gameSettings.keyBindBack.isKeyDown())  {
			getMC().player.setSprinting(true);
		}
	}
}
