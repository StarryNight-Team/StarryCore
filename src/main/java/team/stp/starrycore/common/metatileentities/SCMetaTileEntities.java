package team.stp.starrycore.common.metatileentities;

import team.stp.starrycore.StarryCore;
import team.stp.starrycore.common.metatileentities.multi.MultiStarryUniverseCultivationCabin;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class SCMetaTileEntities {

    public static MultiStarryUniverseCultivationCabin SUCC;

    public static void register() {
        SUCC = registerMetaTileEntity(18000, new MultiStarryUniverseCultivationCabin(StarryCore.of("succ")));
    }

}
