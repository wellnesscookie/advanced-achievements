package com.hm.achievement.module;

import java.util.Set;

import com.hm.achievement.advancement.AdvancementManager;
import com.hm.achievement.command.executable.AbstractCommand;
import com.hm.achievement.command.executor.PluginCommandExecutor;
import com.hm.achievement.db.AbstractDatabaseManager;
import com.hm.achievement.gui.CategoryGUI;
import com.hm.achievement.gui.GUIItems;
import com.hm.achievement.gui.MainGUI;
import com.hm.achievement.lifecycle.Reloadable;
import com.hm.achievement.listener.PlayerAdvancedAchievementListener;
import com.hm.achievement.listener.statistics.*;
import com.hm.achievement.runnable.AchieveDistanceRunnable;
import com.hm.achievement.runnable.AchievePlayTimeRunnable;
import com.hm.achievement.utils.StatisticIncreaseHandler;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

@Module
public interface ReloadableModule {

	@Binds
	@ElementsIntoSet
	Set<Reloadable> bindCommands(Set<AbstractCommand> commands);

	@Binds
	@IntoSet
	Reloadable bindAbstractDatabaseManager(AbstractDatabaseManager abstractDatabaseManager);

	@Binds
	@IntoSet
	Reloadable bindAchieveDistanceRunnable(AchieveDistanceRunnable achieveDistanceRunnable);

	@Binds
	@IntoSet
	Reloadable bindAchievePlayTimeRunnable(AchievePlayTimeRunnable achievePlayTimeRunnable);

	@Binds
	@IntoSet
	Reloadable bindAdvancementManager(AdvancementManager advancementManager);

	@Binds
	@IntoSet
	Reloadable bindEatenBeefsListener(EatenBeefsListener eatenBeefsListener);

	@Binds
	@IntoSet
	Reloadable bindAnvilsListener(AnvilsListener anvilsListener);

	@Binds
	@IntoSet
	Reloadable bindArrowsListener(ArrowsListener arrowsListener);

	@Binds
	@IntoSet
	Reloadable bindBedsListener(BedsListener bedsListener);

	@Binds
	@IntoSet
	Reloadable bindBreaksListener(BreaksListener breaksListener);

	@Binds
	@IntoSet
	Reloadable bindBreedingListener(BreedingListener breedingListener);

	@Binds
	@IntoSet
	Reloadable bindBrewingListener(BrewingListener brewingListener);

	@Binds
	@IntoSet
	Reloadable bindCategoryGUI(CategoryGUI categoryGUI);

	@Binds
	@IntoSet
	Reloadable bindConnectionsListener(ConnectionsListener connectionsListener);

	@Binds
	@IntoSet
	Reloadable bindConsumedPotionsListener(ConsumedPotionsListener consumedPotionsListener);

	@Binds
	@IntoSet
	Reloadable bindCraftsListener(CraftsListener craftsListener);

	@Binds
	@IntoSet
	Reloadable bindDeathsListener(DeathsListener deathsListener);

	@Binds
	@IntoSet
	Reloadable bindDropsListener(DropsListener dropsListener);

	@Binds
	@IntoSet
	Reloadable bindEatenItemsListener(EatenItemsListener eatenItemsListener);

	@Binds
	@IntoSet
	Reloadable bindEggsListener(EggsListener eggsListener);

	@Binds
	@IntoSet
	Reloadable bindEnchantmentsListener(EnchantmentsListener enchantmentsListener);

	@Binds
	@IntoSet
	Reloadable bindEnderPearlsListener(EnderPearlsListener enderPearlsListener);

	@Binds
	@IntoSet
	Reloadable bindFertilisingListener(FertilisingListener fertilisingListener);

	@Binds
	@IntoSet
	Reloadable bindFireworksListener(FireworksListener fireworksListener);

	@Binds
	@IntoSet
	Reloadable bindFishListener(FishListener fishListener);

	@Binds
	@IntoSet
	Reloadable bindGUIItems(GUIItems guiItems);

	@Binds
	@IntoSet
	Reloadable bindHoePlowingListener(HoePlowingListener hoePlowingListener);

	@Binds
	@IntoSet
	Reloadable bindItemBreaksListener(ItemBreaksListener itemBreaksListener);

	@Binds
	@IntoSet
	Reloadable bindKillsListener(KillsListener killsListener);

	@Binds
	@IntoSet
	Reloadable bindLavaBucketsListener(LavaBucketsListener lavaBucketsListener);

	@Binds
	@IntoSet
	Reloadable bindLevelsListener(LevelsListener levelsListener);

	@Binds
	@IntoSet
	Reloadable bindMainGUI(MainGUI mainGUI);

	@Binds
	@IntoSet
	Reloadable bindMilksListener(MilksListener milksListener);

	@Binds
	@IntoSet
	Reloadable bindMusicDiscsListener(MusicDiscsListener musicDiscsListener);

	@Binds
	@IntoSet
	Reloadable bindPetMasterGiveListener(PetMasterReceiveListener petMasterReceiveListener);

	@Binds
	@IntoSet
	Reloadable bindPetMasterReceiveListener(PetMasterGiveListener petMasterGiveListener);

	@Binds
	@IntoSet
	Reloadable bindPickupsListener(PickupsListener pickupsListener);

	@Binds
	@IntoSet
	Reloadable bindPlacesListener(PlacesListener placesListener);

	@Binds
	@IntoSet
	Reloadable bindPlayerAdvancedAchievementListener(PlayerAdvancedAchievementListener playerAdvancedAchievementListener);

	@Binds
	@IntoSet
	Reloadable bindPlayerCommandsListener(PlayerCommandsListener playerCommandsListener);

	@Binds
	@IntoSet
	Reloadable bindPluginCommandExecutor(PluginCommandExecutor pluginCommandExecutor);

	@Binds
	@IntoSet
	Reloadable bindShearsListener(ShearsListener shearsListener);

	@Binds
	@IntoSet
	Reloadable bindSmeltingListener(SmeltingListener smeltingListener);

	@Binds
	@IntoSet
	Reloadable bindSnowballsListener(SnowballsListener snowballsListener);

	@Binds
	@IntoSet
	Reloadable bindStatisticIncreaseHandler(StatisticIncreaseHandler statisticIncreaseHandler);

	@Binds
	@IntoSet
	Reloadable bindTamesListener(TamesListener tamesListener);

	@Binds
	@IntoSet
	Reloadable bindTargetsShotListener(TargetsShotListener targetsShotListener);

	@Binds
	@IntoSet
	Reloadable bindTradesListener(TradesListener tradesListener);

	@Binds
	@IntoSet
	Reloadable bindTreasuresListener(TreasuresListener treasuresListener);

	@Binds
	@IntoSet
	Reloadable bindWaterBucketsListener(WaterBucketsListener waterBucketsListener);

	@Binds
	@IntoSet
	Reloadable bindsWinRaidListener(WinRaidListener winRaidListener);

	@Binds
	@IntoSet
	Reloadable bindsRiptidesListener(RiptidesListener riptidesListener);

	@Binds
	@IntoSet
	Reloadable bindAdvancementsCompletedListener(AdvancementsCompletedListener advancementsCompletedListener);

	@Binds
	@IntoSet
	Reloadable bindJobsRebornListener(JobsRebornListener jobsRebornListener);

	@Binds
	@IntoSet
	Reloadable bindBooksEditedListener(BooksEditedListener booksEditedListener);

	@Binds
	@IntoSet
	Reloadable bindEffectsHeldListener(EffectsHeldListener effectsHeldListener);
}
