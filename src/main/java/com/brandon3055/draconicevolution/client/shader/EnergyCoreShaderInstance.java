package com.brandon3055.draconicevolution.client.shader;

import codechicken.lib.render.shader.CCUniform;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.io.IOException;

import static com.brandon3055.draconicevolution.DraconicEvolution.MODID;

public class EnergyCoreShaderInstance extends ApplyTimeShaderInstance {

    public static ResourceProvider provider = null;

    private CCUniform Activation;
    private CCUniform EffectColour;
    private CCUniform FrameColour;
    private CCUniform RotTriColour;

    protected EnergyCoreShaderInstance(ResourceProvider resourceProvider) throws IOException {
        super(resourceProvider, new ResourceLocation(MODID, "energy_core"), DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP);
        provider = resourceProvider;
    }

    public static EnergyCoreShaderInstance create(ResourceProvider provider) {
        try {
            return new EnergyCoreShaderInstance(provider);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to initialize shader.", ex);
        }
    }

    public static EnergyCoreShaderInstance create() {
        try {
            return new EnergyCoreShaderInstance(provider);
        } catch (IOException ex) {
            throw new RuntimeException("(copy) Failed to initialize shader.", ex);
        }
    }
    
    public void init(){
        super.init();
        this.Activation = this.getUniform("Activation");
        this.EffectColour = this.getUniform("EffectColour");
        this.FrameColour = this.getUniform("FrameColour");
        this.RotTriColour = this.getUniform("InnerTriColour");
    }


    public CCUniform getActivation() {
        return Activation;
    }

    public CCUniform getEffectColour() {
        return EffectColour;
    }

    public CCUniform getFrameColour() {
        return FrameColour;
    }

    public CCUniform getRotTriColour() {
        return RotTriColour;
    }


    public void setActivation(float activation) {
        this.Activation.glUniform1f(activation);
    }

    public void setEffectColour(float[] effectColour) {
        this.EffectColour.glUniform3f(effectColour[0], effectColour[1], effectColour[2]);
    }

    public void setFrameColour(float[] frameColour) {
        this.FrameColour.glUniform3f(frameColour[0], frameColour[1], frameColour[2]);
    }

    public void setRotTriColour(float[] rotTriColour) {
        this.RotTriColour.glUniform3f(rotTriColour[0], rotTriColour[1], rotTriColour[2]);

    }

}
