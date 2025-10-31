package ruby.fluffy.helpme.items_displayed.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.items_displayed.block.*;
import ruby.fluffy.helpme.registries.RubysSoundTypes;
import ruby.fluffy.helpme.registries.RubysSounds;

public class DisplayBlocks {

    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(Registries.BLOCK, "items_displayed");

    public static void rubysBlocks() {
        if (ModList.get().isLoaded("ru3yydiscs")) {
           REGISTRY.register("disc_505", () -> new MusicBlock(createBlock("disc_505", RubysSoundTypes.DISC_505)));
           REGISTRY.register("disc_fluorescent_adolescence", () -> new MusicBlock(createBlock("disc_fluorescent_adolescence", RubysSoundTypes.DISC_FLUORESCENT_ADOLESCENCE)));
           REGISTRY.register("disc_secret_door", () -> new MusicBlock(createBlock("disc_secret_door", RubysSoundTypes.DISC_SECRET_DOOR)));
           REGISTRY.register("disc_crying_lightning", () -> new MusicBlock(createBlock("disc_crying_lightning", RubysSoundTypes.DISC_CRYING_LIGHTNING)));
           REGISTRY.register("disc_my_propeller", () -> new MusicBlock(createBlock("disc_my_propeller", RubysSoundTypes.DISC_MY_PROPELLER)));
           REGISTRY.register("disc_do_i_wanna_know", () -> new MusicBlock(createBlock("disc_do_i_wanna_know", RubysSoundTypes.DISC_DO_I_WANNA_KNOW)));
           REGISTRY.register("disc_i_wanna_be_yours", () -> new MusicBlock(createBlock("disc_i_wanna_be_yours", RubysSoundTypes.DISC_I_WANNA_BE_YOURS)));
           REGISTRY.register("disc_snap_out_of_it", () -> new MusicBlock(createBlock("disc_snap_out_of_it", RubysSoundTypes.DISC_SNAP_OUT_OF_IT)));
           REGISTRY.register("disc_when_the_sun_goes_down", () -> new MusicBlock(createBlock("disc_when_the_sun_goes_down", RubysSoundTypes.DISC_WHEN_THE_SUN_GOES_DOWN)));
           REGISTRY.register("disc_baby_im_yours", () -> new MusicBlock(createBlock("disc_baby_im_yours", RubysSoundTypes.DISC_BABY_IM_YOURS)));
           REGISTRY.register("disc_world_caves_in", () -> new MusicBlock(createBlock("disc_world_caves_in", RubysSoundTypes.DISC_AS_THE_WORLD_CAVES_IN)));
        }
    }

    public static void setupBlocks() {
        REGISTRY.register("angler_pottery_sherd", () -> new SherdBlock(createBlock("angler_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("archer_pottery_sherd", () -> new SherdBlock(createBlock("archer_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("arms_up_pottery_sherd", () -> new SherdBlock(createBlock("arms_up_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("blade_pottery_sherd", () -> new SherdBlock(createBlock("blade_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("brewer_pottery_sherd", () -> new SherdBlock(createBlock("brewer_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("burn_pottery_sherd", () -> new SherdBlock(createBlock("burn_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("danger_pottery_sherd", () -> new SherdBlock(createBlock("danger_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("explorer_pottery_sherd", () -> new SherdBlock(createBlock("explorer_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("flow_pottery_sherd", () -> new SherdBlock(createBlock("flow_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("friend_pottery_sherd", () -> new SherdBlock(createBlock("friend_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("guster_pottery_sherd", () -> new SherdBlock(createBlock("guster_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("heart_pottery_sherd", () -> new SherdBlock(createBlock("heart_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("heartbreak_pottery_sherd", () -> new SherdBlock(createBlock("heartbreak_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("howl_pottery_sherd", () -> new SherdBlock(createBlock("howl_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("miner_pottery_sherd", () -> new SherdBlock(createBlock("miner_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("mourner_pottery_sherd", () -> new SherdBlock(createBlock("mourner_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("plenty_pottery_sherd", () -> new SherdBlock(createBlock("plenty_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("prize_pottery_sherd", () -> new SherdBlock(createBlock("prize_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("scrape_pottery_sherd", () -> new SherdBlock(createBlock("scrape_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("sheaf_pottery_sherd", () -> new SherdBlock(createBlock("sheaf_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("shelter_pottery_sherd", () -> new SherdBlock(createBlock("shelter_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("skull_pottery_sherd", () -> new SherdBlock(createBlock("skull_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("snort_pottery_sherd", () -> new SherdBlock(createBlock("snort_pottery_sherd", SoundType.DECORATED_POT)));
        REGISTRY.register("netherite_upgrade", () -> new UpgradeBlock(createBlock("netherite_upgrade", SoundType.NETHERRACK)));
        REGISTRY.register("bolt_armor_trim", () -> new ArmorTrimBlock(createBlock("bolt_armor_trim", SoundType.COPPER)));
        REGISTRY.register("coast_armor_trim", () -> new ArmorTrimBlock(createBlock("coast_armor_trim", SoundType.STONE)));
        REGISTRY.register("dune_armor_trim", () -> new ArmorTrimBlock(createBlock("dune_armor_trim", SoundType.DRIPSTONE_BLOCK)));
        REGISTRY.register("eye_armor_trim", () -> new ArmorTrimBlock(createBlock("eye_armor_trim", SoundType.CALCITE)));
        REGISTRY.register("flow_armor_trim", () -> new ArmorTrimBlock(createBlock("flow_armor_trim", SoundType.STONE)));
        REGISTRY.register("host_armor_trim", () -> new ArmorTrimBlock(createBlock("host_armor_trim", SoundType.GRAVEL)));
        REGISTRY.register("raiser_armor_trim", () -> new ArmorTrimBlock(createBlock("raiser_armor_trim", SoundType.GRAVEL)));
        REGISTRY.register("rib_armor_trim", () -> new ArmorTrimBlock(createBlock("rib_armor_trim", SoundType.NETHER_BRICKS)));
        REGISTRY.register("sentry_armor_trim", () -> new ArmorTrimBlock(createBlock("sentry_armor_trim", SoundType.STONE)));
        REGISTRY.register("shaper_armor_trim", () -> new ArmorTrimBlock(createBlock("shaper_armor_trim", SoundType.GRAVEL)));
        REGISTRY.register("silence_armor_trim", () -> new ArmorTrimBlock(createBlock("silence_armor_trim", SoundType.DEEPSLATE)));
        REGISTRY.register("snout_armor_trim", () -> new ArmorTrimBlock(createBlock("snout_armor_trim", SoundType.POLISHED_DEEPSLATE)));
        REGISTRY.register("spire_armor_trim", () -> new ArmorTrimBlock(createBlock("spire_armor_trim", SoundType.DEEPSLATE_BRICKS)));
        REGISTRY.register("tide_armor_trim", () -> new ArmorTrimBlock(createBlock("tide_armor_trim", SoundType.DEEPSLATE_BRICKS)));
        REGISTRY.register("vex_armor_trim", () -> new ArmorTrimBlock(createBlock("vex_armor_trim", SoundType.STONE)));
        REGISTRY.register("ward_armor_trim", () -> new ArmorTrimBlock(createBlock("ward_armor_trim", SoundType.DEEPSLATE)));
        REGISTRY.register("wayfinder_armor_trim", () -> new ArmorTrimBlock(createBlock("wayfinder_armor_trim", SoundType.GRAVEL)));
        REGISTRY.register("wild_armor_trim", () -> new ArmorTrimBlock(createBlock("wild_armor_trim", SoundType.STONE)));
        REGISTRY.register("brick", () -> new IngotBlock(createBlock("brick", SoundType.DECORATED_POT)));
        REGISTRY.register("nether_brick", () -> new IngotBlock(createBlock("nether_brick", SoundType.NETHER_BRICKS)));
        REGISTRY.register("iron_ingot", () -> new IngotBlock(createBlock("iron_ingot", SoundType.METAL)));
        REGISTRY.register("copper_ingot", () -> new IngotBlock(createBlock("copper_ingot", SoundType.COPPER)));
        REGISTRY.register("gold_ingot", () -> new IngotBlock(createBlock("gold_ingot", SoundType.METAL)));
        REGISTRY.register("netherite_ingot", () -> new IngotBlock(createBlock("netherite_ingot", SoundType.NETHERITE_BLOCK)));
        REGISTRY.register("coal", () -> new GemBlock(createBlock("coal", SoundType.STONE)));
        REGISTRY.register("charcoal", () -> new GemBlock(createBlock("charcoal", SoundType.STONE)));
        REGISTRY.register("amethyst_shard", () -> new GemBlock(createBlock("amethyst_shard", SoundType.AMETHYST)));
        REGISTRY.register("diamond", () -> new GemBlock(createBlock("diamond", SoundType.METAL)));
        REGISTRY.register("emerald", () -> new GemBlock(createBlock("emerald", SoundType.METAL)));
        REGISTRY.register("lapis_lazuli", () -> new GemBlock(createBlock("lapis_lazuli", SoundType.METAL)));
        REGISTRY.register("echo_shard", () -> new GemBlock(createBlock("echo_shard", SoundType.AMETHYST)));
        REGISTRY.register("music_disc_5", () -> new MusicBlock(createBlock("music_disc_5", SoundType.STONE)));
        REGISTRY.register("music_disc_11", () -> new MusicBlock(createBlock("music_disc_11", SoundType.STONE)));
        REGISTRY.register("music_disc_13", () -> new MusicBlock(createBlock("music_disc_13", SoundType.STONE)));
        REGISTRY.register("music_disc_blocks", () -> new MusicBlock(createBlock("music_disc_blocks", SoundType.STONE)));
        REGISTRY.register("music_disc_cat", () -> new MusicBlock(createBlock("music_disc_cat", SoundType.STONE)));
        REGISTRY.register("music_disc_chirp", () -> new MusicBlock(createBlock("music_disc_chirp", SoundType.STONE)));
        REGISTRY.register("music_disc_creator", () -> new MusicBlock(createBlock("music_disc_creator", SoundType.COPPER)));
        REGISTRY.register("music_disc_creator_music_box", () -> new MusicBlock(createBlock("music_disc_creator_music_box", SoundType.COPPER)));
        REGISTRY.register("music_disc_far", () -> new MusicBlock(createBlock("music_disc_far", SoundType.STONE)));
        REGISTRY.register("music_disc_mall", () -> new MusicBlock(createBlock("music_disc_mall", SoundType.STONE)));
        REGISTRY.register("music_disc_mellohi", () -> new MusicBlock(createBlock("music_disc_mellohi", SoundType.STONE)));
        REGISTRY.register("music_disc_otherside", () -> new MusicBlock(createBlock("music_disc_otherside", SoundType.STONE)));
        REGISTRY.register("music_disc_pigstep", () -> new MusicBlock(createBlock("music_disc_pigstep", SoundType.STONE)));
        REGISTRY.register("music_disc_precipice", () -> new MusicBlock(createBlock("music_disc_precipice", SoundType.STONE)));
        REGISTRY.register("music_disc_relic", () -> new MusicBlock(createBlock("music_disc_relic", SoundType.STONE)));
        REGISTRY.register("music_disc_stal", () -> new MusicBlock(createBlock("music_disc_stal", SoundType.STONE)));
        REGISTRY.register("music_disc_strad", () -> new MusicBlock(createBlock("music_disc_strad", SoundType.STONE)));
        REGISTRY.register("music_disc_wait", () -> new MusicBlock(createBlock("music_disc_wait", SoundType.STONE)));
        REGISTRY.register("music_disc_ward", () -> new MusicBlock(createBlock("music_disc_ward", SoundType.STONE)));
        addModdedBlocks();
        rubysBlocks();
    }

    public static void addModdedBlocks() {
        if (ModList.get().isLoaded("alexscaves")) {
            REGISTRY.register("dinosaur_pottery_sherd", () -> new SherdBlock(createBlock("dinosaur_pottery_sherd", SoundType.DECORATED_POT)));
            REGISTRY.register("footprint_pottery_sherd", () -> new SherdBlock(createBlock("footprint_pottery_sherd", SoundType.DECORATED_POT)));
            REGISTRY.register("guardian_pottery_sherd", () -> new SherdBlock(createBlock("guardian_pottery_sherd", SoundType.DECORATED_POT)));
            REGISTRY.register("hero_pottery_sherd", () -> new SherdBlock(createBlock("hero_pottery_sherd", SoundType.DECORATED_POT)));
            REGISTRY.register("polarity_armor_trim", () -> new ArmorTrimBlock(createBlock("polarity_armor_trim", SoundType.STONE)));
            REGISTRY.register("azure_neodymium_ingot", () -> new IngotBlock(createBlock("azure_neodymium_ingot", SoundType.METAL)));
            REGISTRY.register("scarlet_neodymium_ingot", () -> new IngotBlock(createBlock("scarlet_neodymium_ingot", SoundType.METAL)));
            REGISTRY.register("music_disc_fusion", () -> new MusicBlock(createBlock("music_disc_fusion", SoundType.STONE)));
            REGISTRY.register("music_disc_tasty", () -> new MusicBlock(createBlock("music_disc_tasty", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("cloudstorage")) {
            REGISTRY.register("music_disc_drift", () -> new MusicBlock(createBlock("music_disc_drift", SoundType.WOOL)));
        }

        if (ModList.get().isLoaded("create")) {
            REGISTRY.register("brass_ingot", () -> new IngotBlock(createBlock("brass_ingot", SoundType.METAL)));
            REGISTRY.register("zinc_ingot", () -> new IngotBlock(createBlock("zinc_ingot", SoundType.METAL)));
        }

        if (ModList.get().isLoaded("ecologics")) {
            REGISTRY.register("music_disc_coconut", () -> new MusicBlock(createBlock("music_disc_coconut", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("environmental")) {
            REGISTRY.register("music_disc_leaving_home", () -> new MusicBlock(createBlock("music_disc_leaving_home", SoundType.STONE)));
            REGISTRY.register("music_disc_slabrave", () -> new MusicBlock(createBlock("music_disc_slabrave", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("friendsandfoes")) {
            REGISTRY.register("music_disc_around_the_corner", () -> new MusicBlock(createBlock("music_disc_around_the_corner", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("galosphere")) {
            REGISTRY.register("preserved_template", () -> new UpgradeBlock(createBlock("preserved_template", SoundType.STONE)));
            REGISTRY.register("allurite_shard", () -> new GemBlock(createBlock("allurite_shard", SoundType.AMETHYST)));
            REGISTRY.register("lumiere_shard", () -> new GemBlock(createBlock("lumiere_shard", SoundType.AMETHYST)));
        }

        if (ModList.get().isLoaded("kobolds")) {
            REGISTRY.register("kobold_template", () -> new ArmorTrimBlock(createBlock("kobold_template", SoundType.TUFF)));
            REGISTRY.register("music_disc_kobblestone", () -> new MusicBlock(createBlock("music_disc_kobblestone", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("revotedwildfire")) {
            REGISTRY.register("fireproof_upgrade", () -> new UpgradeBlock(createBlock("fireproof_upgrade", SoundType.NETHER_BRICKS)));
        }

        if (ModList.get().isLoaded("spawn")) {
            REGISTRY.register("crown_pottery_sherd", () -> new SherdBlock(createBlock("crown_pottery_sherd", SoundType.DECORATED_POT)));
            REGISTRY.register("spade_pottery_sherd", () -> new SherdBlock(createBlock("spade_pottery_sherd", SoundType.DECORATED_POT)));
            REGISTRY.register("music_disc_rot", () -> new MusicBlock(createBlock("music_disc_rot", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("supplementaries")) {
            REGISTRY.register("ash_brick", () -> new IngotBlock(createBlock("ash_brick", SoundType.DECORATED_POT)));
            REGISTRY.register("music_disc_heave_ho", () -> new MusicBlock(createBlock("music_disc_heave_ho", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("upgrade_aquatic")) {
            REGISTRY.register("music_disc_atlantis", () -> new MusicBlock(createBlock("music_disc_atlantis", SoundType.STONE)));
        }

        if (ModList.get().isLoaded("vanillabackport")) {
            REGISTRY.register("resin_brick", () -> new IngotBlock(createBlock("resin_brick", SoundType.DECORATED_POT)));
            REGISTRY.register("music_disc_tears", () -> new MusicBlock(createBlock("music_disc_tears", SoundType.STONE)));
            REGISTRY.register("music_disc_lava_chicken", () -> new MusicBlock(createBlock("music_disc_lava_chicken", SoundType.STONE)));
        }
    }

    private static Properties createBlock(String name, SoundType sound) {
        return createBaseProps(name).mapColor(MapColor.NONE).sound(sound);
    }

    private static Properties createBaseProps(String name) {
        return Properties.of().noTerrainParticles().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }
}
