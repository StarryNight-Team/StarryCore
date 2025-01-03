package team.stp.starrycore.common;

import gregtech.api.block.VariantItemBlock;
import gregtech.api.util.BaseCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import team.stp.starrycore.Tags;
import team.stp.starrycore.api.utils.StarryLog;
import team.stp.starrycore.common.blocks.SCMetaBlocks;

import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class CommonProxy {

    public static final BaseCreativeTab TAB = new BaseCreativeTab(Tags.MOD_NAME, Items.BOOK::getDefaultInstance, false);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        StarryLog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();

        registry.register(SCMetaBlocks.METAL_CASING);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        StarryLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(createItemBlock(SCMetaBlocks.METAL_CASING, VariantItemBlock::new));
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    public void construction() {
    }

    public void preInit() {
    }

    public void init() {
    }

    public void postInit() {
    }

    public void loadComplete() {
    }
}
