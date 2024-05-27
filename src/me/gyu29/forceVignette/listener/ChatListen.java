package me.gyu29.forceVignette.listener

import me.gyu29.forceVignette.Main
import me.gyu29.forceVignette.event.ChatEvent
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import net.weavemc.api.event.SubscribeEvent
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;

int scaledWidth = event.resolution.getScaledWidth();
int scaledHeight = event.resolution.getScaledHeight();

class ChatListener {

    @SubscribeEvent
    fun onChat(e: ChatEvent) {
    if(e.message == "/vignette") {
            applyVignette(scaledWidth, scaledHeight);
}

private void applyVignette(int width, int height) {
    GlStateManager.disableDepth();
    GlStateManager.depthMask(false);
    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
    GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
    GlStateManager.disableAlpha();

    Tessellator tessellator = Tessellator.getInstance();
    WorldRenderer worldrenderer = tessellator.getWorldRenderer();
    worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
    worldrenderer.pos(0.0D, (double)height, -90.0D).color(0, 0, 0, 0).endVertex();
    worldrenderer.pos((double)width, (double)height, -90.0D).color(0, 0, 0, 0).endVertex();
    worldrenderer.pos((double)width, 0.0D, -90.0D).color(0, 0, 0, 255).endVertex();
    worldrenderer.pos(0.0D, 0.0D, -90.0D).color(0, 0, 0, 255).endVertex();
    tessellator.draw();

    GlStateManager.depthMask(true);
    GlStateManager.enableBlend();
    GlStateManager.enableAlpha();
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
}