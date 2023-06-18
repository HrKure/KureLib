package com.hrkure.kurelib.particles;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParticlePaper {
    Color color = null;
    ParticleBuilder particleBuilder = null;
    List<Player> whitelisted = new ArrayList<>();
    int range = 5;
    public ParticlePaper(@NotNull Particle type) {
        particleBuilder = new ParticleBuilder(type);
    }
    public ParticlePaper addReceiver(Player p) {
        Objects.requireNonNull(particleBuilder.receivers()).add(p);
        whitelisted.add(p);
        return this;
    }
    public ParticlePaper addReceivers(List<Player> playerList) {
        for(Player p : playerList) {
            Objects.requireNonNull(particleBuilder.receivers()).add(p);
            whitelisted.add(p);
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
        List<Player> close = new ArrayList<>();
        for (Player p: Bukkit.getOnlinePlayers()) {
            if(Objects.requireNonNull(particleBuilder.location()).distance(p.getLocation()) <= range) {
                close.add(p);
            }
        }
        particleBuilder.receivers(close);
        this.range = range;
        return this;
    }
    public ParticlePaper spawn() {
        particleBuilder.spawn();
        return this;
    }
    public ParticlePaper removeReceiver(Player p) {
        if(Objects.requireNonNull(particleBuilder.receivers()).contains(p)) {
            Objects.requireNonNull(particleBuilder.receivers()).remove(p);
            whitelisted.remove(p);
        }
        return this;
    }
    public ParticlePaper removeReceivers(List<Player> players) {
        for (Player p: players) {
            if(Objects.requireNonNull(particleBuilder.receivers()).contains(p)) {
                Objects.requireNonNull(particleBuilder.receivers()).remove(p);
                whitelisted.remove(p);
            }
        }
        return this;
    }
    public ParticlePaper removeAllReceivers() {
        if(particleBuilder.receivers() != null) {
            particleBuilder.receivers().removeIf(p -> Objects.requireNonNull(particleBuilder.receivers()).contains(p) && !whitelisted.contains(p));
        }
        return this;
    }
    public ParticlePaper setOffset(double x, double y, double z) {
        particleBuilder.offset(x, y, z);
        return this;
    }
    public ParticlePaper removeBlackListed(List<Player> blacklist) {
        for (Player p : blacklist) {
            removeReceiver(p);
        }
        return this;
    }
    public int getRange() {
        return range;
    }

}
