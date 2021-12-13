/*
 * This file is part of uracle, licensed under the MIT license
 *
 * Copyright (c) 2021 Unnamed Team
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
package team.unnamed.uracle;

import net.kyori.examination.Examinable;
import net.kyori.examination.ExaminableProperty;
import net.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * Class representing the "pack" section of the
 * pack.mcmeta file for Minecraft Resource Packs
 *
 * @since 1.0.0
 */
public class PackInfo implements Element.Part, Examinable {

    /**
     * Pack version. If this number does not match the current
     * required number, the resource pack displays an error and
     * requires additional confirmation to load the pack
     *
     * <p>There are format versions assigned to specific Minecraft
     * client versions, e.g.: 7 for Minecraft 1.17 and 1.17.1, 8
     * for Minecraft 1.18 and 1.18.1</p>
     */
    private final int format;

    /**
     * Pack description. Text shown below the pack name in the resource
     * pack menu. The text is shown on two lines. If the text is too long
     * it is truncated.
     */
    private final String description;

    public PackInfo(
            int format,
            String description
    ) {
        this.format = format;
        this.description = requireNonNull(description, "description");
    }

    /**
     * Gets the resource-pack format number
     *
     * @return The format number
     * @since 1.0.0
     */
    public int format() {
        return format;
    }

    /**
     * Gets the resource-pack description string
     *
     * @return The description
     * @since 1.0.0
     */
    public String description() {
        return description;
    }

    @Override
    public void write(TreeWriter.Context context) {
        context.writeIntField("format", format);
        context.writeStringField("description", description);
    }

    @Override
    public @NotNull Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(
                ExaminableProperty.of("format", format),
                ExaminableProperty.of("description", description)
        );
    }

    @Override
    public String toString() {
        return examine(StringExaminer.simpleEscaping());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackInfo packInfo = (PackInfo) o;
        return format == packInfo.format
                && description.equals(packInfo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format, description);
    }

}
