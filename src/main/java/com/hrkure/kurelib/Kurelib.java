package com.hrkure.kurelib;

import com.hrkure.kurelib.particles.ParticleManager;
import com.hrkure.kurelib.particles.ParticlePaper;
import com.hrkure.kurelib.particles.ParticleSpawner;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Kurelib extends JavaPlugin {
    private static Kurelib instance = null;
    private static ParticleManager particleManager = null;
    private static Logging logging = null;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        testShit();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Kurelib getKureLib() {
        return instance;
    }
    public static ParticleManager getParticleManager() {
        if(particleManager == null) {
            particleManager = new ParticleManager();
        }
        return particleManager;
    }
    public static Logging getLogging() {
        if(logging == null) {
            logging = new Logging("KureLib | ");
        }
        return logging;
    }
    public void testShit() {
        Logging logger = getLogging();
        ParticleManager pm = getParticleManager();
        List<ParticlePaper> particles = new ArrayList<>();
        int i1 = 0;
        while (i1 < 50) {
            int i2 = 0;
            while (i2 < 50) {
                int i3 = 0;
                while (i3 < 50) {
                    System.out.println(i3 + "x" + i1 + "y"  + i2 + "z");
                    particles.add(new ParticlePaper(Particle.SNOWBALL).setLocation(new Location(Bukkit.getWorld("world2"), i3, i1, i2)).setRange(20));
                    i3 += 1;
                }
                i2 += 1;
            }
            i1 += 1;
        }
        ParticleSpawner spawner = new ParticleSpawner(new Location(Bukkit.getWorld("world"), 100, 100, 100), particles, 20);
        pm.addSpawner(spawner);
        spawner.startSpawning();
        logger.Info("Spawner started");
    }


}
