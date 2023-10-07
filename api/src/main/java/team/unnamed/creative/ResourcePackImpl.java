/*
 * This file is part of creative, licensed under the MIT license
 *
 * Copyright (c) 2021-2023 Unnamed Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package team.unnamed.creative;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import team.unnamed.creative.base.Writable;
import team.unnamed.creative.metadata.Metadata;
import team.unnamed.creative.metadata.overlays.OverlayEntry;
import team.unnamed.creative.overlay.Overlay;
import team.unnamed.creative.overlay.ResourceContainerImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

final class ResourcePackImpl extends ResourceContainerImpl implements ResourcePack {

    private final Map<String, Overlay> overlays = new HashMap<>();

    private @Nullable Writable icon;
    private Metadata metadata;

    @Override
    public @Nullable Writable icon() {
        return icon;
    }

    @Override
    public void icon(final @Nullable Writable icon) {
        this.icon = icon;
    }

    @Override
    public @NotNull Metadata metadata() {
        return metadata == null ? Metadata.EMPTY : metadata;
    }

    @Override
    public void metadata(final @NotNull Metadata metadata) {
        requireNonNull(metadata, "metadata");
        this.metadata = metadata;
    }

    @Override
    public void overlay(final @NotNull Overlay overlay) {
        requireNonNull(overlay, "overlay");
        overlays.put(overlay.directory(), overlay);
    }

    @Override
    public @Nullable Overlay overlay(final @NotNull @OverlayEntry.Directory String directory) {
        requireNonNull(directory, "directory");
        return overlays.get(directory);
    }

    @Override
    public @NotNull Collection<Overlay> overlays() {
        return overlays.values();
    }

}