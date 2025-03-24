package ru.neroduckale;

import org.bukkit.plugin.java.JavaPlugin;
import ru.neroduckale.command.EnderChestCommand;
import ru.sema1ary.vedrocraftapi.BaseCommons;
import ru.sema1ary.vedrocraftapi.command.LiteCommandBuilder;
import ru.sema1ary.vedrocraftapi.service.ConfigService;
import ru.sema1ary.vedrocraftapi.service.ServiceManager;
import ru.sema1ary.vedrocraftapi.service.impl.ConfigServiceImpl;

public final class EnderChest extends JavaPlugin implements BaseCommons {

    @Override
    public void onEnable() {
        ServiceManager.registerService(ConfigService.class, new ConfigServiceImpl(this));

        LiteCommandBuilder.builder()
                .commands(new EnderChestCommand(
                        getService(ConfigService.class))
                )
                .build();
    }

    @Override
    public void onDisable() {
        ServiceManager.disableServices();
    }
}
