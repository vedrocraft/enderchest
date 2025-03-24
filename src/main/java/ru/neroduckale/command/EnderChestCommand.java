package ru.neroduckale.command;

import dev.rollczi.litecommands.annotations.async.Async;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.sema1ary.vedrocraftapi.player.PlayerUtil;
import ru.sema1ary.vedrocraftapi.service.ConfigService;

@RequiredArgsConstructor
@Command(name = "ec", aliases = "enderchest")
public class EnderChestCommand {
    private final ConfigService configService;

    @Async
    @Execute(name = "reload")
    @Permission("enderchest.reload")
    void reload(@Context CommandSender sender) {
        configService.reload();

        PlayerUtil.sendMessage(sender, (String) configService.get("reload-message"));
    }

    @Permission("enderchest.open")
    @Execute
    void openEnderChest(@Context Player sender) {
        sender.openInventory(sender.getEnderChest());
    }
}
