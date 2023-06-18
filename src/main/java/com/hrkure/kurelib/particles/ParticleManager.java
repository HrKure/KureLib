package com.hrkure.kurelib.particles;

import com.hrkure.kurelib.Kurelib;
import com.hrkure.kurelib.Logging;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ParticleManager {
    protected ArrayList<ParticleSpawner> spawners = new ArrayList<>();
    protected AtomicInteger counter = new AtomicInteger();
    protected BukkitTask task;
    protected Logging logging = Kurelib.getLogging();
    public ParticleManager() {
        this.task = startTask();
    }

    public void addSpawner(ParticleSpawner spawner) {
        spawners.add(spawner);
    }

    private BukkitTask startTask() {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(Kurelib.getKureLib(), () -> {
            counter.addAndGet(1);
            logging.Info(counter.toString());
            for (ParticleSpawner spawner: spawners) {
                if(spawner.isSpawning() && counter.intValue() % spawner.getFrequency() == 0) {
                    spawner.spawn();
                    logging.Info("Spawner Spawn");
                }

            }
            if(counter.get() >= 30000) {
                counter.set(0);
            }


        }, 1, 1);
    }
}
