package com.hm.achievement.listener.statistics;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerBucketFillEvent;

import com.hm.achievement.AdvancedAchievements;
import com.hm.achievement.category.NormalAchievements;
import com.hm.achievement.config.AchievementMap;
import com.hm.achievement.db.CacheManager;

/**
 * Listener class to deal with Milk achievements.
 *
 * @author Pyves
 */
@Singleton
public class MilksListener extends AbstractRateLimitedListener {

	@Inject
	public MilksListener(@Named("main") YamlConfiguration mainConfig, int serverVersion, AchievementMap achievementMap,
			CacheManager cacheManager, AdvancedAchievements advancedAchievements,
			@Named("lang") YamlConfiguration langConfig, Logger logger) {
		super(NormalAchievements.MILKS, mainConfig, serverVersion, achievementMap, cacheManager, advancedAchievements,
				langConfig, logger);
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerBucketFill(PlayerBucketFillEvent event) {
		if (event.getItemStack().getType() == Material.MILK_BUCKET) {
			updateStatisticAndAwardAchievementsIfAvailable(event.getPlayer(), 1);
		}
	}
}
