package reforged.mods.blockhelper.addons.integrations.ic2;

import de.thexxturboxx.blockhelper.api.BlockHelperBlockProvider;
import de.thexxturboxx.blockhelper.api.BlockHelperBlockState;
import de.thexxturboxx.blockhelper.api.InfoHolder;
import ic2.core.block.machine.tileentity.TileEntityTeleporter;
import net.minecraft.tileentity.TileEntity;
import reforged.mods.blockhelper.addons.TextColor;

public class TeleporterInfoProvider implements BlockHelperBlockProvider {

    @Override
    public void addInformation(BlockHelperBlockState blockHelperBlockState, InfoHolder infoHolder) {
        TileEntity tile = blockHelperBlockState.te;
        if (tile instanceof TileEntityTeleporter) {
            TileEntityTeleporter tp = (TileEntityTeleporter) tile;
            boolean hasTarget = tp.targetSet;
            infoHolder.add(TextColor.GOLD.format("probe.info.teleporter.target.set", hasTarget ? TextColor.GREEN.format(String.valueOf(true)) : TextColor.RED.format(String.valueOf(false))));
            infoHolder.add(TextColor.WHITE.format("probe.info.teleporter.target", tp.targetX, tp.targetY, tp.targetZ));
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
