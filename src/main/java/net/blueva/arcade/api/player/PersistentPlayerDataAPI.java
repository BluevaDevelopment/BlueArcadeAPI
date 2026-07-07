package net.blueva.arcade.api.player;

/**
 * Module-scoped per-player data access backed by the core user data store.
 *
 * @param <P> platform player type
 * @since 3.4
 */
public interface PersistentPlayerDataAPI<P> {

    <T> T get(P player, String moduleId, String key, Class<T> type, T defaultValue);

    void set(P player, String moduleId, String key, Object value);

    void remove(P player, String moduleId, String key);

    void save(P player);
}
