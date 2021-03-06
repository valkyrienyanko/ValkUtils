package com.valkutils.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.valkutils.ValkUtils;

public class Hologram {
	ArmorStand as;
	Location location;
	
	public Hologram(Location loc, String name) {
		this.location = loc;
		as = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		as.setArms(false);
		as.setGravity(true);
		as.setVisible(false);
		as.setCustomName(name);
		as.setCustomNameVisible(false);
	}
	
	public Hologram setVisible(boolean visible) {
		as.setCustomNameVisible(visible);
		return this;
	}
	
	public Hologram move() {
		final Vector to = new Vector(0, 1, 0).multiply(0.01);
		
		new BukkitRunnable() {
			public void run() {
				as.setVelocity(to);
			}
		}.runTaskTimer(ValkUtils.plugin, 0, 1);
		
		return this;
	}
	
	public void destroy() {
		as.remove();
	}
}
