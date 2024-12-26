package team.stp.starrycore.api.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@NoArgsConstructor
public class StarryLog {
    @Getter
    public static Logger logger = LogManager.getLogger("StarryCore");
}
