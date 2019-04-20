package com.tfar.rttweaker;

import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import lumien.randomthings.recipes.imbuing.ImbuingRecipeHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.Logger;

import static com.tfar.rttweaker.RandomThingsTweaker.recipesToAdd;
import static com.tfar.rttweaker.RandomThingsTweaker.removeAll;

@Mod(modid = RTTweaker.MODID, name = RTTweaker.NAME, version = RTTweaker.VERSION)
public class RTTweaker {
  public static final String MODID = "rttweaker";
  public static final String NAME = "Random Things Tweaker";
  public static final String VERSION = "@VERSION@";

  private static Logger logger;

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent postEvent) {
    if (removeAll) {
      ImbuingRecipeHandler.imbuingRecipes.clear();
    }
    if (recipesToAdd.size() > 0){
      for (IItemStack[] recipe : recipesToAdd)
      ImbuingRecipeHandler.
              addRecipe(CraftTweakerMC.getItemStack(recipe[0]),
                      CraftTweakerMC.getItemStack(recipe[1]),
                      CraftTweakerMC.getItemStack(recipe[2]),
                      CraftTweakerMC.getItemStack(recipe[3]),
                      CraftTweakerMC.getItemStack(recipe[4]));
    }
  }
}
