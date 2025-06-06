package com.brandon3055.draconicevolution.client.shader;

import codechicken.lib.render.shader.CCUniform;
import com.brandon3055.brandonscore.api.TimeKeeper;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.io.IOException;

import static com.brandon3055.draconicevolution.DraconicEvolution.MODID;

public class EnergyCrystalShaderInstance extends ApplyTimeShaderInstance {

    private CCUniform Colour;
    private CCUniform Mipmap;

    protected EnergyCrystalShaderInstance(ResourceProvider resourceProvider) throws IOException {
        super(resourceProvider, new ResourceLocation(MODID, "energy_crystal"), DefaultVertexFormat.POSITION_TEX);
    }

    public static EnergyCrystalShaderInstance create(ResourceProvider provider) {
        try {
            EnergyCrystalShaderInstance instance = new EnergyCrystalShaderInstance(provider);
            instance.init();
            return instance;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to initialize shader.", ex);
        }
    }

    public void init(){
        this.Colour = this.getUniform("Colour");
        this.Mipmap = this.getUniform("Mipmap");
    }

    public CCUniform getColour() {
        return Colour;
    }

    public CCUniform getMipmap() {
        return this.Mipmap;
    }

    public void setColour(float[] colour) {
        this.Colour.glUniform3f(colour[0], colour[1], colour[2]);
    }
    public void setMipmap(float mipmap) {
        this.Mipmap.glUniform1f(mipmap);
    }
}
