
package net.scarletbonds.item;

import net.scarletbonds.ScarletBondsModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@ScarletBondsModElements.ModElement.Tag
public class UniformHumanKokushiboItem extends ScarletBondsModElements.ModElement {
	@ObjectHolder("scarlet_bonds:uniform_human_kokushibo")
	public static final Item block = null;

	public UniformHumanKokushiboItem(ScarletBondsModElements instance) {
		super(instance, 80);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("uniform_human_kokushibo");
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
