package com.hm.achievement.listener.statistics;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerBucketFillEvent;

import com.hm.achievement.AdvancedAchievements;
import com.hm.achievement.category.NormalAchievements;
import com.hm.achievement.command.executable.ReloadCommand;
import com.hm.achievement.db.CacheManager;
import com.hm.achievement.listener.QuitListener;
import com.hm.achievement.utils.RewardParser;
import com.hm.mcshared.file.CommentedYamlConfiguration;

/**
 * Listener class to deal with Milk, WaterBuckets and LavaBuckets achievements.
 *
 * @author Pyves
 */
@Singleton
public class MilksLavaWaterBucketsListener extends AbstractRateLimitedListener {

	private final Set<String> disabledCategories;

	@Inject
	public MilksLavaWaterBucketsListener(@Named("main") CommentedYamlConfiguration mainConfig, int serverVersion,
			Map<String, List<Long>> sortedThresholds, CacheManager cacheManager, RewardParser rewardParser,
			ReloadCommand reloadCommand, AdvancedAchievements advancedAchievements,
			@Named("lang") CommentedYamlConfiguration langConfig, Logger logger,
			QuitListener quitListener, Set<String> disabledCategories) {
		super(mainConfig, serverVersion, sortedThresholds, cacheManager, rewardParser, reloadCommand, advancedAchievements,
				langConfig, logger, quitListener);
		this.disabledCategories = disabledCategories;
	}

	@Override
	public void cleanPlayerData(UUID uuid) {
		String uuidString = uuid.toString();
		// The cooldown for this class must handle Milk, WaterBuckets and LavaBuckets achievements independently, hence
		// the prefix in the cooldown map.
		cooldownMap.remove(NormalAchievements.MILKS + uuidString);
		cooldownMap.remove(NormalAchievements.LAVABUCKETS + uuidString);
		cooldownMap.remove(NormalAchievements.WATERBUCKETS + uuidString);
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerBucketFill(PlayerBucketFillEvent event) {
		Player player = event.getPlayer();

		Material resultBucket = event.getItemStack().getType();
		NormalAchievements category = getCategory(resultBucket);

		if (disabledCategories.contains(category.toString())) {
			return;
		}

		if (!shouldIncreaseBeTakenIntoAccount(player, category)
				|| isInCooldownPeriod(player, category.toString(), false, category)) {
			return;
		}

		updateStatisticAndAwardAchievementsIfAvailable(player, category, 1);
	}

	private NormalAchievements getCategory(Material resultBucket) {
		switch (resultBucket) {
			case MILK_BUCKET:
				return NormalAchievements.MILKS;
			case LAVA_BUCKET:
				return NormalAchievements.LAVABUCKETS;
			default:
				return NormalAchievements.WATERBUCKETS;
		}
	}
}
