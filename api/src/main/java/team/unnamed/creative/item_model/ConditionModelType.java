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
package team.unnamed.creative.item_model;

import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@ApiStatus.NonExtendable
public interface ConditionModelType {

    @Contract("_ -> this")
    @NotNull Property property();

    @Contract("_ -> this")
    @NotNull ItemModel onTrue();

    @Contract("_ -> this")
    @NotNull ItemModel onFalse();

    enum Property {
        USING_ITEM("using_item"), BROKEN("broken"), DAMAGED("damaged"), HAS_COMPONENT("has_component"),
        FISHING_ROD_CAST("fishing_rod/cast"), BUNDLE_HAS_SELECTED_ITEM("bundle/has_selected_item"),
        SELECTED("selected"), CARRIED("carried"), EXTENDED_VIEW("extended_view"),
        KEYBIND_DOWN("keybind_down"), VIEW_ENTITY("view_entity"), CUSTOM_MODEL_DATA("custom_model_data");

        private final Key key;

        Property(@NotNull String key) {
            this.key = Key.key(key);
        }
    }
}
