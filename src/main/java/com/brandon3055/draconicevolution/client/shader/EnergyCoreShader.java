package com.brandon3055.draconicevolution.client.shader;

import codechicken.lib.render.shader.CCShaderInstance;
import codechicken.lib.render.shader.CCUniform;
import com.brandon3055.brandonscore.api.TimeKeeper;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.io.IOException;

import static com.brandon3055.draconicevolution.DraconicEvolution.MODID;

public class EnergyCoreShader extends CCShaderInstance {

    private CCUniform Time;
    private CCUniform Activation;
    private CCUniform EffectColour;
    private CCUniform FrameColour;
    private CCUniform RotTriColour;

    protected EnergyCoreShader(ResourceProvider resourceProvider) throws IOException {
        super(resourceProvider, new ResourceLocation(MODID, "energy_core"), DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP);
    }

    public static EnergyCoreShader create(ResourceProvider provider) {
        try {
            return new EnergyCoreShader(provider);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to initialize shader.", ex);
        }
    }
    
    public void init(){
        this.Time = this.getUniform("Time");
        this.Activation = this.getUniform("Activation");
        this.EffectColour = this.getUniform("EffectColour");
        this.FrameColour = this.getUniform("FrameColour");
        this.RotTriColour = this.getUniform("InnerTriColour");
        this.onApply(this::applyTime);
    }

    public CCUniform getTime() {
        return Time;
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

    private void applyTime(){
        setTime((TimeKeeper.getClientTick() + Minecraft.getInstance().getFrameTime()) / 50F);
    }

    public void setTime(float time) {
        this.Time.glUniform1f(time);
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
