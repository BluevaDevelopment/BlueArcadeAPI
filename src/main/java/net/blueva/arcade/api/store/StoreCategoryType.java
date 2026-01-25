package net.blueva.arcade.api.store;

/**
 * Describes how items inside a store category behave.
 */
public enum StoreCategoryType {
    /**
     * Items are selectable (one active at a time).
     */
    SELECTION,

    /**
     * Items are only purchased/unlocked; no active selection is required.
     */
    PURCHASE_ONLY,

    /**
     * A grouping node that contains subcategories instead of items.
     */
    GROUP
}
