package net.parker8283.bif;

import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("bowinfinityfix")
public class BowInfinityFix {
    private static final Logger LOGGER = LogManager.getLogger("BowInfinityFix");

    public BowInfinityFix() {
        MinecraftForge.EVENT_BUS.addListener(this::infinityFix);
        LOGGER.info("Fix Registered!");
    }

    private void infinityFix(final ArrowNockEvent event) {
        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, event.getBow()) > 0) {
            event.getPlayer().startUsingItem(event.getHand());
            event.setAction(InteractionResultHolder.success(event.getBow()));
        }
    }
}
