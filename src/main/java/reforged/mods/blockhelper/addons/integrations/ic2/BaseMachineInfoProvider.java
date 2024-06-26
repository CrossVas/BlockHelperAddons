package reforged.mods.blockhelper.addons.integrations.ic2;

import de.thexxturboxx.blockhelper.api.BlockHelperBlockProvider;
import de.thexxturboxx.blockhelper.api.BlockHelperBlockState;
import de.thexxturboxx.blockhelper.api.InfoHolder;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;
import net.minecraft.tileentity.TileEntity;
import reforged.mods.blockhelper.addons.TextColor;

public class BaseMachineInfoProvider implements BlockHelperBlockProvider {

    @Override
    public void addInformation(BlockHelperBlockState blockHelperBlockState, InfoHolder infoHolder) {
        TileEntity tile = blockHelperBlockState.te;
        if (tile instanceof TileEntityStandardMachine) {
            TileEntityStandardMachine machine = (TileEntityStandardMachine) tile;
            infoHolder.add(TextColor.WHITE.format("info.eu_reader.usage", machine.energyConsume));

            float progress = machine.getProgress();
            if (progress > 0) {
                infoHolder.add(TextColor.DARK_GREEN.format("info.progress", (int) (progress * 100)) + "%");
            }
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
