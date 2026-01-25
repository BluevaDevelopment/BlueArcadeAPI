package net.blueva.arcade.api.achievements;

/**
 * API for registering and opening achievements.
 */
public interface AchievementsAPI<P> {

    /**
     * Register a module achievements file.
     * The file must live in the module data folder (plugins/BlueArcade/modules/{moduleId}/).
     *
     * @param moduleId Module id
     * @param fileName Achievements file name (e.g., "achievements.yml")
     * @return true if registered successfully
     */
    boolean registerModuleAchievements(String moduleId, String fileName);

    /**
     * Open achievements for a category.
     *
     * @param player Player
     * @param categoryId Category id
     * @param page Page number
     * @return true if a menu opened successfully
     */
    boolean openAchievements(P player, String categoryId, int page);
}
