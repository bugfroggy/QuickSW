/*
 * Copyright (C) 2016 Leonardosnt.
 * QuickSW is licensed under CC BY-NC-SA.
 * Read LICENSE.txt for more info.
 */

package io.github.leonardosnt.quicksw;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@Mod(modid = "QuickSW", version = "1.1", acceptedMinecraftVersions = "[1.8,1.8.9]")
public class QuickSWMod {

  private static final Minecraft MINECRAFT = Minecraft.getMinecraft();
  private boolean isOnHypixel;

  @EventHandler
  public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
    FMLCommonHandler.instance().bus().register(this);
  }

  @SubscribeEvent
  public void onActionChatGui(GuiScreenEvent.ActionPerformedEvent.Post e) {
    if (!isOnHypixel || !(e.gui instanceof GuiChat)){
      return;
    }
    switch (e.button.id) {
      case 0:
        MINECRAFT.thePlayer.sendChatMessage("/play ranked_normal");
        break;

      case 1:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_insane");
        break;

      case 2:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_normal");
        break;

      case 3:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_insane");
        break;

      case 4:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_normal");
        break;

      case 5:
        MINECRAFT.thePlayer.sendChatMessage("/play mega_normal");
        break;

      case 6:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_insane_tnt_madness");
        break;

      case 7:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_insane_rush");
        break;

      case 8:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_insane_blizzard");
        break;

      case 9:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_insane_floor_is_lava");
        break;

      case 10:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_normal_kill_by_color");
        break;

      case 11:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_insane_tnt_madness");
        break;

      case 12:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_insane_rush");
        break;

      case 13:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_insane_blizzard");
        break;

      case 14:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_insane_floor_is_lava");
        break;

      case 15:
        MINECRAFT.thePlayer.sendChatMessage("/play teams_normal_kill_by_color");
        break;

      case 16:
        MINECRAFT.thePlayer.sendChatMessage("/play solo_insane_rush");
        break;

      default:
        break;
    }
  }

  @SubscribeEvent
  public void onRenderChatGui(GuiScreenEvent.DrawScreenEvent.Post e) {
    if (!isOnHypixel || !(e.gui instanceof GuiChat)){
      return;
    }
    e.gui.drawCenteredString(MINECRAFT.fontRendererObj, EnumChatFormatting.YELLOW
            + "QuickSW by Leonardosnt.", e.gui.width - 65, e.gui.height - 35, 0xFF);
    e.gui.drawCenteredString(MINECRAFT.fontRendererObj, EnumChatFormatting.AQUA
            + "Modified by bugfroggy.", e.gui.width - 65, e.gui.height - 25, 0xFF);
    e.gui.drawCenteredString(MINECRAFT.fontRendererObj, EnumChatFormatting.WHITE +
            "Modes", e.gui.width - 40, 7, 0xFF);
    e.gui.drawCenteredString(MINECRAFT.fontRendererObj, EnumChatFormatting.WHITE +
            "Laboratory", e.gui.width - 160, 7, 0xFF);
  }

  @SubscribeEvent
  public void onInitChatGui(GuiScreenEvent.InitGuiEvent.Post e) {
    if (!isOnHypixel || !(e.gui instanceof GuiChat)){
      return;
    }
    int button_height = 20;
    int button_width = 75;
    int button_height_margin = button_height + 2;
    int button_width_margin = button_width + 5;

    int y = button_height;
    int x = e.gui.width - button_width;
    int id = 0; // Button ID
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Ranked"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Solo Insane"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Solo Normal"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Team Insane"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Team Normal"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Mega"));
    // Start next column
    y = button_height;
    x -= button_width_margin;

    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "TNT Solo"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Rush Solo"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Blizzard Solo"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Lava Solo"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Color Solo"));
    // Start next column
    y = button_height;
    x -= button_width_margin;

    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "TNT Team"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Rush Team"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Blizzard Team"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Lava Team"));
    y += button_height_margin;
    e.buttonList.add(new GuiButton(id++, x, y, button_width, button_height, "Color Team"));
  }

  @SubscribeEvent
  public void onConnect(FMLNetworkEvent.ClientConnectedToServerEvent e) {
    final ServerData data = MINECRAFT.getCurrentServerData();
    if (data != null && data.serverIP.contains("hypixel.net")) {
      isOnHypixel = true;
    }
  }

  @SubscribeEvent
  public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
    isOnHypixel = false;
  }
}
