package com.tfar.rttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import lumien.randomthings.recipes.anvil.AnvilRecipeHandler;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;

@SuppressWarnings("unused")
@ZenRegister
@ZenClass("mods.rt.RandomThingsTweaker")
public class RandomThingsTweaker {

  public static boolean removeAll = false;
  public static ArrayList<IItemStack[]> recipesToAdd = new ArrayList<>();

  @ZenMethod
  public static void addImbuingRecipe(IItemStack output, IItemStack input, IItemStack ingredients, IItemStack center, IItemStack result) {

    IItemStack[] recipe = {output,input,ingredients,center,result};
    recipesToAdd.add(recipe);
  }

  @ZenMethod
  public static void addAnvilRecipe(IItemStack input1, IItemStack input2, IItemStack result, int cost) {
    AnvilRecipeHandler.addAnvilRecipe(CraftTweakerMC.getItemStack(input1), CraftTweakerMC.getItemStack(input2),
            CraftTweakerMC.getItemStack(result), cost);
  }

  @ZenMethod
  public static void removeAllImbuingRecipes() {
    removeAll = true;
  }
}



