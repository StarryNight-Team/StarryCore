package team.stp.starrycore.api.utils;

import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Getter
public enum Mods {
    AE2("appliedenergistics2"),
    TA("thaumicaugmentation");

    public final String ID;

    Mods(String ID) {
        this.ID = ID;
    }

    public Block getBlock(String blockName) {
        Block result = Block.getBlockFromName(ID + ":" + blockName);
        return result == null ? Blocks.AIR : result;
    }

    public Item getItem(String blockName) {
        Item result = Item.getByNameOrId(ID + ":" + blockName);
        return result == null ? Items.AIR : result;
    }

}
