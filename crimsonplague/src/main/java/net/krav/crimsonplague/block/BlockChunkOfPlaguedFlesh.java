
package net.krav.crimsonplague.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.Block;

import net.krav.crimsonplague.item.ItemCrimsonIngot;
import net.krav.crimsonplague.ElementsCrimsonPlague;

@ElementsCrimsonPlague.ModElement.Tag
public class BlockChunkOfPlaguedFlesh extends ElementsCrimsonPlague.ModElement {
	@GameRegistry.ObjectHolder("crimsonplague:chunkofplaguedflesh")
	public static final Block block = null;
	public BlockChunkOfPlaguedFlesh(ElementsCrimsonPlague instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("chunkofplaguedflesh"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("crimsonplague:chunkofplaguedflesh", "inventory"));
	}
	public static class BlockCustom extends BlockFalling {
		public BlockCustom() {
			super(Material.GROUND);
			setUnlocalizedName("chunkofplaguedflesh");
			setSoundType(SoundType.SLIME);
			setHarvestLevel("shovel", 1);
			setHardness(10F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemCrimsonIngot.block, (int) (9)));
		}
	}
}
