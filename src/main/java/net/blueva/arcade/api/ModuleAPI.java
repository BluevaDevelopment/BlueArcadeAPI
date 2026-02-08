package net.blueva.arcade.api;

import net.blueva.arcade.api.config.CoreConfigAPI;
import net.blueva.arcade.api.config.ModuleConfigAPI;
import net.blueva.arcade.api.module.ModuleInfo;
import net.blueva.arcade.api.store.StoreAPI;
import net.blueva.arcade.api.stats.StatsAPI;
import net.blueva.arcade.api.setup.GameSetupAPI;
import net.blueva.arcade.api.ui.ItemAPI;
import net.blueva.arcade.api.ui.MessageAPI;
import net.blueva.arcade.api.ui.MenuAPI;
import net.blueva.arcade.api.ui.VoteMenuAPI;
import net.blueva.arcade.api.achievements.AchievementsAPI;
import net.blueva.arcade.api.utils.PlayerUtil;
import net.blueva.arcade.api.visuals.VisualEffectsAPI;

/**
 * Static API accessor for modules.
 * Provides access to global APIs during onLoad().
 */
public class ModuleAPI {

    private static ModuleAPIProvider provider;

    /**
     * Set the API provider (called by core plugin, DO NOT USE in modules).
     */
    public static void setProvider(ModuleAPIProvider provider) {
        ModuleAPI.provider = provider;
    }

    /**
     * Get ModuleConfigAPI for a specific module.
     * Returns null if module doesn't have config files.
     *
     * @param moduleId Module ID (e.g., "race")
     * @return ModuleConfigAPI or null
     */
    public static ModuleConfigAPI getModuleConfig(String moduleId) {
        return provider != null ? provider.getModuleConfig(moduleId) : null;
    }

    /**
     * Get VoteMenuAPI for registering games in vote menu.
     *
     * @return VoteMenuAPI instance
     */
    public static VoteMenuAPI getVoteMenuAPI() {
        return provider != null ? provider.getVoteMenuAPI() : null;
    }

    /**
     * Get MenuAPI for opening custom menus in Java and Bedrock.
     *
     * @return MenuAPI instance
     */
    public static MenuAPI getMenuAPI() {
        return provider != null ? provider.getMenuAPI() : null;
    }

    /**
     * Get StoreAPI for registering store categories and items.
     *
     * @return StoreAPI instance
     */
    public static StoreAPI getStoreAPI() {
        return provider != null ? provider.getStoreAPI() : null;
    }

    /**
     * Get ItemAPI for item formatting and lobby item registration.
     *
     * @return ItemAPI instance
     */
    public static ItemAPI<?, ?, ?> getItemAPI() {
        return provider != null ? provider.getItemAPI() : null;
    }

    /**
     * Get MessageAPI for sending formatted messages.
     *
     * @return MessageAPI instance
     */
    public static MessageAPI<?> getMessagesAPI() {
        return provider != null ? provider.getMessagesAPI() : null;
    }

    /**
     * Get CoreConfigAPI for accessing core plugin configurations.
     * Provides access to settings.yml, messages.yml, sounds.yml, rewards.yml
     *
     * @return CoreConfigAPI instance
     */
    public static CoreConfigAPI getCoreConfig() {
        return provider != null ? provider.getCoreConfig() : null;
    }

    /**
     * Get ModuleInfo for accessing module metadata from module.yml.
     * This provides a clean way to access module information without
     * having to duplicate it in code.
     *
     * @param moduleId Module ID (e.g., "race")
     * @return ModuleInfo with metadata from module.yml
     */
    public static ModuleInfo getModuleInfo(String moduleId) {
        return provider != null ? provider.getModuleInfo(moduleId) : null;
    }

    /**
     * Get GameSetupAPI for registering game setup commands.
     * Allows modules to register their own /baa game <id> <game> <command> handlers.
     *
     * @return GameSetupAPI instance
     */
    public static GameSetupAPI getSetupAPI() {
        return provider != null ? provider.getSetupAPI() : null;
    }

    /**
     * Get stats API for registering and updating module stats.
     *
     * @return StatsAPI instance
     */
    public static StatsAPI getStatsAPI() {
        return provider != null ? provider.getStatsAPI() : null;
    }

    /**
     * Get achievements API for registering and opening achievements.
     *
     * @return AchievementsAPI instance
     */
    public static AchievementsAPI getAchievementsAPI() {
        return provider != null ? provider.getAchievementsAPI() : null;
    }

    /**
     * Get visual effects API for triggering store-based kill/death effects.
     *
     * @return VisualEffectsAPI instance
     */
    public static VisualEffectsAPI getVisualEffectsAPI() {
        return provider != null ? provider.getVisualEffectsAPI() : null;
    }

    /**
     * Get PlayerUtil for player state checks outside a GameContext.
     *
     * @return PlayerUtil instance
     */
    public static PlayerUtil<?> getPlayerUtil() {
        return provider != null ? provider.getPlayerUtil() : null;
    }

    /**
     * Interface implemented by the core plugin.
     */
    public interface ModuleAPIProvider {
        ModuleConfigAPI getModuleConfig(String moduleId);
        VoteMenuAPI getVoteMenuAPI();
        MenuAPI getMenuAPI();
        StoreAPI getStoreAPI();
        CoreConfigAPI getCoreConfig();
        ModuleInfo getModuleInfo(String moduleId);
        GameSetupAPI getSetupAPI();
        StatsAPI getStatsAPI();
        AchievementsAPI getAchievementsAPI();
        ItemAPI<?, ?, ?> getItemAPI();
        MessageAPI<?> getMessagesAPI();
        VisualEffectsAPI getVisualEffectsAPI();
        PlayerUtil<?> getPlayerUtil();
    }
}
