package com.brandon3055.draconicevolution.client.shader;

import codechicken.lib.render.shader.CCShaderInstance;
import codechicken.lib.render.shader.CCUniform;
import com.brandon3055.brandonscore.api.TimeKeeper;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.io.IOException;

public class ApplyTimeShaderInstance extends CCShaderInstance {
    private CCUniform Time;

    protected ApplyTimeShaderInstance(ResourceProvider resourceProvider, ResourceLocation loc, VertexFormat format) throws IOException {
        super(resourceProvider, loc, format);
    }

    public void init(){
        this.onApply(this::applyTime);
        this.Time = this.getUniform("Time");
    }

    public CCUniform getTime() {
        return Time;
    }
    private void applyTime(){
        setTime((TimeKeeper.getClientTick() + Minecraft.getInstance().getFrameTime()) / 50F);
    }

    public void setTime(float time) {
        this.Time.glUniform1f(time);
    }
}
