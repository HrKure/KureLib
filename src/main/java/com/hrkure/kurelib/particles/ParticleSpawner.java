package com.hrkure.kurelib.particles;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ParticleSpawner {
    Location location = null;
    LivingEntity livingEntity = null;
    int frequency = 2;
    int respawns = -1;
    List<ParticlePaper> particles;
    Boolean spawning = false;
    List<Player> blacklist = new ArrayList<>();

    public ParticleSpawner(LivingEntity entity, List<ParticlePaper> particles, int frequency) {
        this.livingEntity = entity;
        this.frequency = frequency;
        this.particles = particles;
    }
    public ParticleSpawner(Location location, List<ParticlePaper> particles, int frequency) {
        this.location = location;
        this.particles = particles;
        this.frequency = frequency;
    }
    public ParticleSpawner(LivingEntity entity, List<ParticlePaper> particles, int frequency, int respawns) {
        this.livingEntity = entity;
        this.frequency = frequency;
        this.particles = particles;
        this.respawns = respawns;
    }
    public ParticleSpawner(Location location, List<ParticlePaper> particles, int frequency, int respawns) {
        this.location = location;
        this.particles = particles;
        this.frequency = frequency;
        this.respawns = respawns;
    }
    public ParticleSpawner stopspawning() {
        spawning = false;
        return this;
    }
    public ParticleSpawner startSpawning() {
        spawning = true;
        return this;
    }
    public void addToBlackList(Player p) {
        blacklist.add(p);
    }
    public void removeFromBlackList(Player p) {
        blacklist.remove(p);
    }
    public boolean isSpawning() {
        return spawning;
    }
    public int getFrequency() {
        return frequency;
    }
    public void spawn() {
        if(livingEntity == null) {
            for (ParticlePaper particle: particles) {
                particle.removeAllReceivers().setRange(particle.getRange()).removeBlackListed(blacklist).spawn();
            }
        } else {
            for (ParticlePaper particle: particles) {
                particle.removeAllReceivers().setLocation(livingEntity.getLocation()).setRange(particle.getRange()).removeBlackListed(blacklist).spawn();
            }
        }
    }
}
