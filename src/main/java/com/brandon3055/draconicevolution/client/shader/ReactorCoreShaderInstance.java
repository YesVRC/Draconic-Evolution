package com.brandon3055.draconicevolution.client.shader;

import codechicken.lib.render.shader.CCShaderInstance;
import codechicken.lib.render.shader.CCUniform;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.io.IOException;

import static com.brandon3055.draconicevolution.DraconicEvolution.MODID;

public class ReactorCoreShaderInstance extends CCShaderInstance {

    private CCUniform intensity;
    private CCUniform time;

    protected ReactorCoreShaderInstance(ResourceProvider resourceProvider) throws IOException {
        super(resourceProvider, new ResourceLocation(MODID, "reactor"), DefaultVertexFormat.POSITION_TEX);
    }

    public static ReactorCoreShaderInstance create(ResourceProvider provider) {
        try {
            ReactorCoreShaderInstance shader = new ReactorCoreShaderInstance(provider);
            shader.intensity = shader.getUniform("intensity");
            shader.time = shader.getUniform("time");
            return shader;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to initialize shader.", ex);
        }
    }

    public void setIntensity(float intensity) {
        this.intensity.glUniform1f(intensity);
    }
    public void setTime(float time) {
        this.time.glUniform1f(time);
    }
}
