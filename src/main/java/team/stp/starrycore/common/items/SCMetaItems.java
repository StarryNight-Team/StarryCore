package team.stp.starrycore.common.items;

import gregtech.api.items.metaitem.MetaItem;

public class SCMetaItems {
    public static MetaItem<?>.MetaValueItem DRAGON_CELL;
    public static MetaItem<?>.MetaValueItem STELLAR_DEBRIS;
    public static MetaItem<?>.MetaValueItem STAR_CONTAINER;
    public static MetaItem<?>.MetaValueItem HIGH_ENERGY_FLOW_CIRCUIT;

    // Hydrogen
    public static MetaItem<?>.MetaValueItem SOLID_HYDROGEN;
    public static MetaItem<?>.MetaValueItem DENSE_HYDROGEN;
    public static MetaItem<?>.MetaValueItem HYPER_DENSE_HYDROGEN;
    public static MetaItem<?>.MetaValueItem ARTIFICIAL_SUN;

    //Panels
    public static MetaItem<?>.MetaValueItem LIGHT_EMITTING_PANEL;
    public static MetaItem<?>.MetaValueItem ADVANCED_LIGHT_EMITTING_PANEL;
    public static MetaItem<?>.MetaValueItem ULTIMATE_LIGHT_EMITTING_PANEL;

    public static void register() {
        SCMetaItem item = new SCMetaItem();
    }

    public static void registerItems() {
        SCMetaItem.registerItems();
    }

}
