package com.hm.achievement.listener.statistics;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import com.hm.achievement.category.NormalAchievements;
import com.hm.achievement.config.AchievementMap;
import com.hm.achievement.db.CacheManager;

/**
 * Listener class to deal with EatenItems achievements.
 *
 * @author Pyves
 *
 */
@Singleton
public class EatenBeefsListener extends AbstractListener {

    @Inject
    public EatenBeefsListener(@Named("main") YamlConfiguration mainConfig, AchievementMap achievementMap,
                              CacheManager cacheManager) {
        super(NormalAchievements.EATENBEEFS, mainConfig, achievementMap, cacheManager);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        Material itemMaterial = event.getItem().getType();
        if (itemMaterial == Material.COOKED_BEEF) {
            updateStatisticAndAwardAchievementsIfAvailable(event.getPlayer(), 1);
        }
    }
}
