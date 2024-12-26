package team.stp.starrycore;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import team.stp.starrycore.common.CommonProxy;
import team.stp.starrycore.common.blocks.SCMetaBlocks;
import team.stp.starrycore.common.items.SCMetaItems;
import team.stp.starrycore.common.metatileentities.SCMetaTileEntities;

@Mod(
        modid = Tags.MOD_ID,
        name = Tags.MOD_NAME,
        version = Tags.VERSION
)
public class StarryCore {

    @SidedProxy(clientSide = "team.stp.starrycore.client.ClientProxy", serverSide = "team.stp.starrycore.common.CommonProxy")
    public static CommonProxy proxy;

    public static ResourceLocation of(String path) {
        return new ResourceLocation(Tags.MOD_ID, path);
    }

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {
        proxy.construction();
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        proxy.preInit();

        SCMetaItems.register();
        SCMetaBlocks.register();
        SCMetaTileEntities.register();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void onLoadComplete(FMLLoadCompleteEvent event) {
        proxy.loadComplete();
    }

}
