package com.brandon3055.draconicevolution.client.shader;

import net.minecraft.server.packs.resources.ResourceProvider;

public interface IShaderInstance<T> {
    T create(ResourceProvider resourceProvider);
    void init();
}
