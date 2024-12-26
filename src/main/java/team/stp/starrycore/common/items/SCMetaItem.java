package team.stp.starrycore.common.items;

import gregtech.api.items.metaitem.StandardMetaItem;
import team.stp.starrycore.Tags;
import team.stp.starrycore.common.CommonProxy;

import static team.stp.starrycore.common.items.SCMetaItems.*;

public class SCMetaItem extends StandardMetaItem {

    public SCMetaItem() {
        this.setRegistryName(Tags.MOD_ID, "meta_item");
        this.setCreativeTab(CommonProxy.TAB);
    }

    @Override
    public void registerSubItems() {
        DRAGON_CELL = this.addItem(1, "dragon_cells");
        STELLAR_DEBRIS = this.addItem(2, "debris.stellar");
        STAR_CONTAINER = this.addItem(3, "container.star");
        HIGH_ENERGY_FLOW_CIRCUIT = this.addItem(4, "circuit.high_energy_flow");

        SOLID_HYDROGEN = this.addItem(10, "hydrogen.solid");
        DENSE_HYDROGEN = this.addItem(11, "hydrogen.dense");
        HYPER_DENSE_HYDROGEN = this.addItem(12, "hydrogen.hyper_dense");
        ARTIFICIAL_SUN = this.addItem(13, "artificial_sun");

        LIGHT_EMITTING_PANEL = this.addItem(20, "panel.emitting");
        ADVANCED_LIGHT_EMITTING_PANEL = this.addItem(21, "panel.advanced");
        ULTIMATE_LIGHT_EMITTING_PANEL = this.addItem(22, "panel.ultimate");
    }

}
