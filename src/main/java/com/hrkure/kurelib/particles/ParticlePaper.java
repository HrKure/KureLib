package com.hrkure.kurelib.particles;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ParticlePaper {
    Color color = null;
    ParticleBuilder particleBuilder = null;
    public ParticlePaper(@NotNull Particle type) {
        particleBuilder = new ParticleBuilder(type);
    }
    public ParticlePaper addReceiver(Player p) {
        Objects.requireNonNull(particleBuilder.receivers()).add(p);
        return this;
    }
    public ParticlePaper addReceivers(List<Player> playerList) {
        for(Player p : playerList) {
            Objects.requireNonNull(particleBuilder.receivers()).add(p);
        }
        return this;
    }
    public ParticlePaper setLocation(Location loc) {
        particleBuilder.location(loc);
        return this;
    }
    public ParticlePaper setColor(Color color) {
        particleBuilder.color(color);
        this.color = color;
        return this;
    }
    public ParticlePaper setSize(float size) {
        particleBuilder.color(color, size);
        return this;
    }
    public ParticlePaper setCount(int count) {
        particleBuilder.count(count);
        return this;
    }
    public ParticlePaper setRange(int range) {
        particleBuilder.receivers(range);
        return this;
    }
    public ParticlePaper spawn() {
        particleBuilder.spawn();
        return this;
    }
    public ParticlePaper removeReceiver(Player p) {
        if(Objects.requireNonNull(particleBuilder.receivers()).contains(p)) {
            Objects.requireNonNull(particleBuilder.receivers()).remove(p);
        }
        return this;
    }
    public ParticlePaper removeReceivers(List<Player> players) {
        for (Player p: players) {
            if(Objects.requireNonNull(particleBuilder.receivers()).contains(p)) {
                Objects.requireNonNull(particleBuilder.receivers()).remove(p);
            }
        }
        return this;
    }
    public ParticlePaper setOffset(double x, double y, double z) {
        particleBuilder.offset(x, y, z);
        return this;
    }

}
