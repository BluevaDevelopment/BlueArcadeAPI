/**
 * Hytale-specific menu and UI definitions.
 * <p>
 * This package contains types for Hytale's custom UI system. Hytale UI
 * is fundamentally different from Minecraft: instead of inventory GUIs,
 * Hytale uses <b>.ui layout files</b> loaded on the client, with the
 * server sending commands to set values and receiving events for user
 * interactions.
 * </p>
 * <h2>Key concepts:</h2>
 * <ul>
 *   <li>{@link HytaleMenuDefinition} – A menu backed by a {@code .ui}
 *       layout file with server-controlled elements and event bindings.</li>
 *   <li>{@link HytaleButtonDefinition} – Describes a clickable element
 *       inside a Hytale UI page.</li>
 *   <li>{@link HytaleUIElement} – Represents a named, value-settable
 *       element in the client layout.</li>
 *   <li>{@link HytaleUIEventBinding} – Binds a UI element to a
 *       server-side action via event types.</li>
 * </ul>
 *
 * @since 3.2
 */
package net.blueva.arcade.api.ui.menu.hytale;
