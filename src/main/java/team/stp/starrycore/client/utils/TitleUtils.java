package team.stp.starrycore.client.utils;

import org.lwjgl.opengl.Display;
import team.stp.starrycore.Tags;
import team.stp.starrycore.api.utils.StarryLog;
import team.stp.starrycore.common.config.StarryCoreConfig;
import team.stp.starrycore.core.StarryPlugin;

import java.lang.reflect.Method;

/**
 * 标题工具类 <br/>
 * 代码从 NovaEngCore 复制 (GPL v3.0) <br/>
 * @author Hikari_Nova
 */
public class TitleUtils {

    /**
     * TODO 喜欢我硬编码吗.jpg
     */
    public static final String DEFAULT_TITLE = String.format("StarryNight Pray %s by tEam StP | Core Ver: %s", StarryCoreConfig.VERSION, Tags.VERSION);
    public static final String VANILLA_TITLE = "Minecraft 1.12.2";

    public static String currentTitle = null;
    public static String lastCurrentTitle = null;
    public static boolean unsupportedPlatform = false;

    public static void setRandomTitle(final String state) {
        lastCurrentTitle = currentTitle;
        currentTitle = buildTitle(state);
        setTitle();
    }

    public static void setRandomTitle() {
        lastCurrentTitle = currentTitle;
        currentTitle = buildTitle(null);
        setTitle();
    }

    public static void setRandomTitleSync() {
        lastCurrentTitle = currentTitle;
        currentTitle = buildTitle(null);
    }

    /**
     * 设置标题，可以在其他线程使用。
     *
     * @param state 当前状态
     */
    public static void setRandomTitleSync(String state) {
        lastCurrentTitle = currentTitle;
        currentTitle = buildTitle(state);
    }

    public static String buildTitle(final String state) {
        if (state == null) {
            return DEFAULT_TITLE;
        }
        return String.format("%s | %s", DEFAULT_TITLE, state);
    }

    public static void checkTitleState() {
        if (currentTitle == null) {
            return;
        }

        String title = Display.getTitle();
        if (!title.equals(currentTitle)) {
            if (!title.equals(TitleUtils.VANILLA_TITLE) && !title.equals(lastCurrentTitle)) {
                StarryLog.logger.debug("Invalid title: {}, Excepted: {}", title, lastCurrentTitle);
//                // 嗯？
//                Minecraft.getMinecraft().shutdown();
//                return;
            }
            setTitle();
        }
    }

    private static void setTitle() {
        if (StarryPlugin.isCleanroomLoader() && !unsupportedPlatform) {
            try {
                Class<?> Display = Class.forName("org.lwjgl.opengl.Display");
                Method getWindow = Display.getDeclaredMethod("getWindow");
                long result = (long) getWindow.invoke(null);
                if (result != 0) {
                    Class<?> GLFW = Class.forName("org.lwjgl3.glfw.GLFW");
                    Method glfwSetWindowTitle = GLFW.getDeclaredMethod("glfwSetWindowTitle", long.class, CharSequence.class);
                    glfwSetWindowTitle.invoke(null, result, currentTitle);
                }
            } catch (Exception e) {
                StarryLog.logger.warn("Failed to set CleanroomLoader title, maybe platform is unsupported.", e);
                unsupportedPlatform = true;
            }
            return;
        }
        Display.setTitle(currentTitle);
    }

}
