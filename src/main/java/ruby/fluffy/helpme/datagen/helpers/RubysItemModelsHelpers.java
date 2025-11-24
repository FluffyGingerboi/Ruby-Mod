package ruby.fluffy.helpme.datagen.helpers;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import ruby.fluffy.helpme.RubyMod;

import java.util.List;

public abstract class RubysItemModelsHelpers extends ItemModelProvider {
    protected static final List<ResourceKey<TrimMaterial>> VANILLA_TRIM_MATERIALS = List.of(TrimMaterials.QUARTZ, TrimMaterials.IRON, TrimMaterials.NETHERITE, TrimMaterials.REDSTONE, TrimMaterials.COPPER, TrimMaterials.GOLD, TrimMaterials.EMERALD, TrimMaterials.DIAMOND, TrimMaterials.LAPIS, TrimMaterials.AMETHYST);

    public RubysItemModelsHelpers(PackOutput output, String id, ExistingFileHelper helper) {
        super(output, id, helper);
    }

    public String blockName(Block block) {
        ResourceLocation location = BuiltInRegistries.BLOCK.getKey(block);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown block: " + block.toString());
        }
    }

    public String itemName(Item item) {
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown item: " + item.toString());
        }
    }

    protected ResourceLocation texture(String name) {
        return this.modLoc("block/" + name);
    }

    protected ResourceLocation texture(String name, String location) {
        return this.modLoc("block/" + location + name);
    }

    public void item(Item item, String location) {
        this.withExistingParent(this.itemName(item), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + location + this.itemName(item)));
    }

    public void handheldItem(Item item, String location) {
        this.withExistingParent(this.itemName(item), this.mcLoc("item/handheld"))
                .texture("layer0", this.modLoc("item/" + location + this.itemName(item)));
    }

    public void helmetItem(Item item, String location, String baseTexture, String overlayTexture) {
        this.dyedArmorItem(item, location, "helmet", baseTexture, overlayTexture);
    }

    public void chestplateItem(Item item, String location, String baseTexture, String overlayTexture) {
        this.dyedArmorItem(item, location, "chestplate", baseTexture, overlayTexture);
    }

    public void leggingsItem(Item item, String location, String baseTexture, String overlayTexture) {
        this.dyedArmorItem(item, location, "leggings", baseTexture, overlayTexture);
    }

    public void bootsItem(Item item, String location, String baseTexture, String overlayTexture) {
        this.dyedArmorItem(item, location, "boots", baseTexture, overlayTexture);
    }

    public void dyedArmorItem(Item item, String location, String type, String baseTexture, String overlayTexture) {
        String itemName = this.itemName(item);

        ItemModelBuilder builder = this.withExistingParent(itemName, this.mcLoc("item/generated"))
                .texture("layer0", this.modLoc("item/" + location + baseTexture))
                .texture("layer1", this.modLoc("item/" + location + overlayTexture));

        double index = 0.1;

        for (ResourceKey<TrimMaterial> trimMaterial : VANILLA_TRIM_MATERIALS) {
            String material = trimMaterial.location().getPath();
            String trimmed = itemName + "_" + material + "_trim";

            this.withExistingParent(trimmed, this.mcLoc("item/generated"))
                    .texture("layer0", this.modLoc("item/" + location + baseTexture))
                    .texture("layer1", this.modLoc("item/" + location + overlayTexture))
                    .texture("layer2", this.mcLoc("trims/items/" + type + "_trim_" + material));

            builder.override()
                    .predicate(ResourceLocation.withDefaultNamespace("trim_type"), (float) index)
                    .model(this.getExistingFile(this.modLoc("item/" + trimmed)))
                    .end();

            index += 0.1;
        }
    }

    public void dyedItem(Item item, String location) {
        this.withExistingParent(this.itemName(item), this.mcLoc("item/generated"))
                .texture("layer0", this.modLoc("item/" + location + this.itemName(item)))
                .texture("layer1", this.modLoc("item/" + location + this.itemName(item) + "_overlay"));
    }

    public void itemBlock(Block block) {
        this.withExistingParent(this.blockName(block), this.texture(this.blockName(block)));
    }

    public void itemBlock(Block block, String suffix) {
        this.withExistingParent(this.blockName(block), this.texture(this.blockName(block) + suffix));
    }
}
