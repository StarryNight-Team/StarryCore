package team.stp.starrycore.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import team.stp.starrycore.client.utils.TitleUtils;
import team.stp.starrycore.common.CommonProxy;
import team.stp.starrycore.common.blocks.SCMetaBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        SCMetaBlocks.registerItemModels();
    }

    @Override
    public void construction() {
        super.construction();
        TitleUtils.setRandomTitle("*Construction*");
    }

    @Override
    public void preInit() {
        super.preInit();
        TitleUtils.setRandomTitle("*PreInit*");
    }

    @Override
    public void init() {
        super.init();
        TitleUtils.setRandomTitle("*Init*");
    }

    @Override
    public void postInit() {
        super.postInit();
        TitleUtils.setRandomTitle("*PostInit*");
    }

    @Override
    public void loadComplete() {
        super.loadComplete();
        TitleUtils.setRandomTitle();
    }

}
