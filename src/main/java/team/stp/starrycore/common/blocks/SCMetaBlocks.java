package team.stp.starrycore.common.blocks;

import com.google.common.collect.UnmodifiableIterator;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import team.stp.starrycore.Tags;
import team.stp.starrycore.common.CommonProxy;

public class SCMetaBlocks {

    public static SCBlockMetalCasing METAL_CASING;

    public static void register() {
        METAL_CASING = new SCBlockMetalCasing();
        METAL_CASING.setRegistryName(Tags.MOD_ID, "metal_casing");
        METAL_CASING.setCreativeTab(CommonProxy.TAB);
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(METAL_CASING);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@NotNull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }

}