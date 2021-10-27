package team.unnamed.uracle.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import team.unnamed.uracle.event.ResourcePackGenerateEvent;
import team.unnamed.uracle.io.Writeable;
import team.unnamed.uracle.resourcepack.ResourcePackInfo;

public class ResourcePackInfoWriter implements Listener {

    private final ResourcePackInfo packInfo;

    public ResourcePackInfoWriter(ResourcePackInfo packInfo) {
        this.packInfo = packInfo;
    }

    @EventHandler
    public void onGenerate(ResourcePackGenerateEvent event) {

        event.write(
                "pack.mcmeta",
                "{" +
                        "\"pack\": {" +
                        "\"pack_format\": " + packInfo.getFormat() + "," +
                        "\"description\": \"" + packInfo.getDescription() + "\"" +
                        "}" +
                        "}"
        );

        Writeable icon = packInfo.getIcon();
        if (icon != null) {
            event.write("pack.png", icon);
        }
    }

}