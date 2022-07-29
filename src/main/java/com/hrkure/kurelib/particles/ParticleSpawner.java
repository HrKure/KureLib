package com.hrkure.kurelib.particles;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class ParticleSpawner {
    Location location;
    LivingEntity livingEntity;
    int frequency;
    int respawns;
    List<ParticlePaper> particles;

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
    public ParticleSpawner killDestroyWhateverYouWantToCallItJustDoIt() {
        return this;
    }
    private void startSpawning() {

    }
}
