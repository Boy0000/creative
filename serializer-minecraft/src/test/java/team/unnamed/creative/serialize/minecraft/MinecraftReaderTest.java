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
package team.unnamed.creative.serialize.minecraft;

import org.junit.jupiter.api.Test;
import team.unnamed.creative.ResourcePack;
import team.unnamed.creative.serialize.minecraft.fs.FileTreeReader;

import java.io.IOException;
import java.util.zip.ZipInputStream;

public class MinecraftReaderTest {

    @Test
    public void test() throws IOException {
        try (ZipInputStream inputStream = new ZipInputStream(getClass().getResourceAsStream("/resource-packs/icons.zip"))) {
            ResourcePack resourcePack = MinecraftResourcePackReader.minecraft().read(FileTreeReader.zip(inputStream));

            System.out.println("stats:");
            System.out.println("description: " + resourcePack.description());
            System.out.println("pack format: " + resourcePack.format());
            System.out.println(resourcePack.fonts().size());
            System.out.println(resourcePack.textures().size());
            System.out.println(resourcePack.blockStates().size());
            System.out.println(resourcePack.languages().size());
            System.out.println(resourcePack.unknownFiles().size());
        }
    }

}