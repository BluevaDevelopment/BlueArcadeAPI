package net.blueva.arcade.api.stats;

import java.util.Map;

/**
 * Generic stats API exposed to modules.
 */
public interface StatsAPI<P> {

    void registerGlobalStat(StatDefinition definition);

    void registerModuleStat(String moduleId, StatDefinition definition);

    int getGlobalStat(P player, String key);

    int getModuleStat(P player, String moduleId, String key);

    void addGlobalStat(P player, String key, int delta);

    void addModuleStat(P player, String moduleId, String key, int delta);

    /**
     * Get and clear the session deltas accumulated for the player during the last game.
     */
    Map<String, Integer> consumeSessionDeltas(P player, String moduleId);
}
