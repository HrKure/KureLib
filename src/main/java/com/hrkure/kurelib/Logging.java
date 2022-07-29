package com.hrkure.kurelib;

import org.bukkit.Bukkit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
    Logger logger = null;
    String prefix = "";
    public Logging(String prefix) {
        this.prefix = prefix;
        logger = Bukkit.getLogger();
    }
    public void Info(String s) {
        logger.info(prefix + s);
    }
    public void Warn(String s) {
        logger.warning(prefix + s);
    }
    public void Log(String s, Level level) {
        logger.log(level, prefix + s);
    }

}
