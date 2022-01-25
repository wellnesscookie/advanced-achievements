package com.hm.achievement.listener.statistics;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.serbcraft.bridges.events.PlayerStatsChangedEvent;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerEggThrowEvent;

import com.hm.achievement.category.NormalAchievements;
import com.hm.achievement.config.AchievementMap;
import com.hm.achievement.db.CacheManager;

/**
 * Listener class to deal with ScoreAchieved
 *
 * @author wellnesscookie
 *
 */
@Singleton
public class ScoreAchievedListener extends AbstractListener {

    @Inject
    public ScoreAchievedListener(@Named("main") YamlConfiguration mainConfig, AchievementMap achievementMap,
                        CacheManager cacheManager) {
        super(NormalAchievements.SCOREACHIEVIED, mainConfig, achievementMap, cacheManager);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerScoreChanged(PlayerStatsChangedEvent event) {
        updateStatisticAndAwardAchievementsIfAvailable(event.getIgrac().getPlayer(), event.getStatsToIncrement());
    }
}
