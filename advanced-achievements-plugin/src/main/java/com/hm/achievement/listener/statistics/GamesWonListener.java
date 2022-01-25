package com.hm.achievement.listener.statistics;

import com.hm.achievement.category.NormalAchievements;
import com.hm.achievement.config.AchievementMap;
import com.hm.achievement.db.CacheManager;
import com.serbcraft.bridges.events.PlayerWonGameEvent;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class GamesWonListener extends AbstractListener {

        @Inject
        public GamesWonListener(@Named("main") YamlConfiguration mainConfig, AchievementMap achievementMap,
                            CacheManager cacheManager) {
            super(NormalAchievements.GAMESWON, mainConfig, achievementMap, cacheManager);
        }

        @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
        public void onPlayerWonGame(PlayerWonGameEvent event) {
            updateStatisticAndAwardAchievementsIfAvailable(event.getIgrac(), 1);
        }
}
