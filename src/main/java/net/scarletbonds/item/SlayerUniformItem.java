
package net.scarletbonds.item;

import net.scarletbonds.ScarletBondsModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@ScarletBondsModElements.ModElement.Tag
public class SlayerUniformItem extends ScarletBondsModElements.ModElement {
	@ObjectHolder("scarlet_bonds:slayer_uniform")
	public static final Item block = null;

	public SlayerUniformItem(ScarletBondsModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("slayer_uniform");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
