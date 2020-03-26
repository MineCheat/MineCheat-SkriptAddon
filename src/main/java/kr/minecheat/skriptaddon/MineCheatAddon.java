package kr.minecheat.skriptaddon;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.dependency.Dependency;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.Website;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.io.IOException;

@Plugin(name="MineCheat-SkriptAddon", version="1.0")
@Description(value = "Skript addon for using MineCheat services in skript")
@Dependency(value= "Skript")
@Author(value = "syeyoung (cyoung06@naver.com)")
@Website(value = "MineCheat.kr")
public class MineCheatAddon extends JavaPlugin {
    private SkriptAddon addon;
    @Getter
    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void onEnable() {
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("kr.minecheat.skriptaddon","addon");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
