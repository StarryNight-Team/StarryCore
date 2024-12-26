package team.stp.starrycore.client;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;
import team.stp.starrycore.client.utils.TitleUtils;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientEventHandler {

    private long clientTick = 0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) {
            return;
        }
        clientTick++;

        if (clientTick % 5 == 0) {
            TitleUtils.checkTitleState();
        }
    }

    @SubscribeEvent
    public void onServerConnected(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        TitleUtils.setRandomTitleSync(String.format("*%s*", event.getManager().getRemoteAddress()));
    }

    @SubscribeEvent
    public void onServerDisconnected(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        TitleUtils.setRandomTitleSync();
    }

}
