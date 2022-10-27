package xaidee.emcompat;

import com.teamaurora.enhanced_mushrooms.common.block.EMCabinetBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public record Woodset(MaterialColor logColor, MaterialColor woodColor, int lightLevel) {

    // When defining light level for a glowing wood derivative,
    // I suggest giving it a level half of the large mushroom block itself.
    public Woodset(MaterialColor logColor, MaterialColor woodColor, int lightLevel) {
        this.logColor = logColor;
        this.woodColor = woodColor;
        this.lightLevel = lightLevel;
    }

    public Woodset(MaterialColor logColor, MaterialColor woodColor) {
        this(logColor, woodColor, 0);
    }

    private static Boolean never(BlockState arg, BlockGetter arg2, BlockPos arg3, EntityType<?> arg4) {
        return false;
    }

    private RotatedPillarBlock template_log(MaterialColor arg, MaterialColor arg2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (arg3) -> {
            return arg3.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? arg : arg2;
        }).strength(2.0F).sound(SoundType.STEM).lightLevel((light) -> this.lightLevel));
    }

    private RotatedPillarBlock template_wood(MaterialColor arg) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, arg).strength(2.0F).sound(SoundType.STEM).lightLevel((light) -> this.lightLevel));
    }

    public RotatedPillarBlock log() {
        return this.template_log(this.woodColor, this.logColor);
    }

    public RotatedPillarBlock wood() {
        return this.template_wood(this.logColor);
    }

    public RotatedPillarBlock stripped_log() {
        return this.template_log(this.woodColor, this.woodColor);
    }

    public RotatedPillarBlock stripped_wood() {
        return this.template_wood(this.woodColor);
    }

    public Block planks() {
        return new Block(BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD).lightLevel((light) -> this.lightLevel));
    }

    public SlabBlock slab() {
        return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD).lightLevel((light) -> this.lightLevel));
    }

    public StairBlock stairs(Supplier<Block> planks) {
        return new StairBlock(((Block)planks.get()).defaultBlockState(), BlockBehaviour.Properties.copy((BlockBehaviour)planks.get()).lightLevel((light) -> this.lightLevel));
    }

    public PressurePlateBlock pressurePlate() {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).noCollission().strength(0.5F).sound(SoundType.WOOD).lightLevel((light) -> this.lightLevel));
    }

    public ButtonBlock button() {
        return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD).lightLevel((light) -> this.lightLevel));
    }

    public FenceBlock fence() {
        return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD).lightLevel((light) -> this.lightLevel));
    }

    public FenceGateBlock fenceGate() {
        return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).strength(2.0F, 3.0F).sound(SoundType.WOOD).lightLevel((light) -> this.lightLevel));
    }

    public DoorBlock door() {
        return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).strength(3.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((light) -> this.lightLevel));
    }

    public TrapDoorBlock trapdoor() {
        return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, this.woodColor).strength(3.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(Woodset::never).lightLevel((light) -> this.lightLevel));
    }

    public EMCabinetBlock cabinet() {
        return new EMCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL).lightLevel((light) -> this.lightLevel));
    }

    public MaterialColor logColor() {
        return this.logColor;
    }

    public MaterialColor woodColor() {
        return this.woodColor;
    }

    public int lightLevel() { return this.lightLevel; }
}
