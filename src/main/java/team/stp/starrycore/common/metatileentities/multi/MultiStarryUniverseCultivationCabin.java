package team.stp.starrycore.common.metatileentities.multi;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.stp.starrycore.api.recipe.SCRecipeMaps;
import team.stp.starrycore.api.utils.Mods;

import java.util.List;

public class MultiStarryUniverseCultivationCabin extends RecipeMapMultiblockController {

    public MultiStarryUniverseCultivationCabin(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, SCRecipeMaps.SUCC);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("##AAA##", "##BJB##", "##BJB##", "##HHH##")
                .aisle("#AHHHA#", "#B###B#", "#B###B#", "#HAAAH#")
                .aisle("AHHHHHA", "B#####B", "B#####B", "HAIIIAH")
                .aisle("AHHHHHA", "J#####J", "J#####J", "HAIIIAH")
                .aisle("AHHHHHA", "B#####B", "B#####B", "HAIIIAH")
                .aisle("#AHHHA#", "#B###B#", "#B###B#", "#HAAAH#")
                .aisle("##AAA##", "##BCB##", "##BAB##", "##HHH##")
                .where('C', selfPredicate())
                .where('B', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS)))
                .where('A',
                        states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING))
                                .or(autoAbilities(true, true, true, true, true, true, false))
                )
                .where('H', blocks(Mods.AE2.getBlock("fluix_slab")))
                .where('I', blocks(Mods.TA.getBlock("starfield_glass")))
                .where('J', states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.FUSION_CASING_MK3)))
                .where('#', air())
                .build();
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.ATOMIC_CASING;
    }

    @SideOnly(Side.CLIENT)
    @NotNull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.BLAST_FURNACE_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip,
                               boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("voltage_level") + "§rLuV");
        tooltip.add(I18n.format("starry_universe_cultivation_cabin_tooltip_1"));
        tooltip.add(I18n.format("starry_universe_cultivation_cabin_tooltip_2"));
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MultiStarryUniverseCultivationCabin(metaTileEntityId);
    }
}
