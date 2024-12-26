package team.stp.starrycore.common.blocks;

import gregtech.api.block.VariantBlock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

public class SCBlockMetalCasing extends VariantBlock<SCBlockMetalCasing.MetalCasingType> {

    public SCBlockMetalCasing() {
        super(Material.IRON);
        this.setTranslationKey("metal_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("wrench", 2);
        this.setDefaultState(this.getState(MetalCasingType.VOID_METAL));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state,
                                    @NotNull IBlockAccess world,
                                    @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }


    @Getter
    @AllArgsConstructor
    public enum MetalCasingType implements IStringSerializable {
        VOID_METAL("void_metal"),
        THAUMIUM("thaumium"),
        EXTREME("extreme");

        private final String name;
    }

}
