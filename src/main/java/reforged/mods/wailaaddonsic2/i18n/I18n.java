package reforged.mods.wailaaddonsic2.i18n;

import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import net.minecraft.util.StatCollector;
import net.minecraft.util.StringTranslate;

public final class I18n {

    private static final String PREFIX = "probe.";

    private static final String[] LANGUAGES = {"en_US"};

    private I18n() {
        throw new UnsupportedOperationException();
    }

    public static void init() {
        for (String lang : LANGUAGES) {
            loadLanguage(lang);
        }
    }

    public static void loadLanguage(String lang) {
        InputStream stream = null;
        InputStreamReader reader = null;
        try {
            stream = I18n.class.getResourceAsStream("/reforged/mods/wailaaddonsic2/i18n/" + lang + ".properties");
            if (stream == null) {
                throw new IOException("Couldn't load language file.");
            }

            reader = new InputStreamReader(stream, "UTF-8");
            Properties props = new Properties();
            props.load(reader);
            for (String key : props.stringPropertyNames()) {
                LanguageRegistry.instance().addStringLocalization(key, lang, props.getProperty(key));
            }

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Throwable ignored) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable ignored) {
                }
            }
        }
    }

    public static String format(boolean b) {
        return format(null, b);
    }

    public static String format(StringTranslate translator, boolean b) {
        return format(translator, b ? "true" : "false");
    }

    public static String format(String key, Object... args) {
        return format(null, key, args);
    }

    public static String format(StringTranslate translator, String key, Object... args) {
        if (translator == null) return StatCollector.translateToLocalFormatted(PREFIX + key, args);
        return translator.translateKeyFormat(PREFIX + key, args);
    }

}
