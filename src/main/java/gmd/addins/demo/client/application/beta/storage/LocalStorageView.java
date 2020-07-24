/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gmd.addins.demo.client.application.beta.storage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialChip;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.storage.LocalForage;
import gwt.material.design.jquery.client.api.Functions;

import javax.inject.Inject;

public class LocalStorageView extends ViewImpl implements LocalStoragePresenter.MyView {

    interface Binder extends UiBinder<Widget, LocalStorageView> {
    }

    @UiField
    MaterialTextBox setKey, value, getKey, removeKey;

    @UiField
    MaterialPanel valuePanel;

    @Inject
    LocalStorageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        LocalForage.injectResource();
        LocalForage.ready().then((e, param1) -> {
            reloadPanel();
            return true;
        });
    }

    @UiHandler("save")
    void save(ClickEvent e) {
        if (setKey.validate() && value.validate()) {
            LocalForage.ready().then(obj -> {
                LocalForage.setItem(setKey.getValue(), value.getValue()).then((e1, param1) -> {
                    MaterialToast.fireToast("Save to Storage: [key: " + setKey.getValue() + "], [value: " + value.getValue() + "]");
                    reloadPanel();
                    return true;
                });
                return true;
            });
        } else {
            MaterialToast.fireToast("Please provide a valid key and value.");
        }
    }

    @UiHandler("get")
    void queryKey(ClickEvent event) {
        getItem(getKey.getValue(), MaterialToast::fireToast);
    }

    @UiHandler("removeItem")
    void removeItem(ClickEvent event) {
        if (removeKey.validate()) {
            LocalForage.removeItem(removeKey.getValue()).then((e, param1) -> {
                reloadPanel();
                return true;
            }).fail((e, param1) -> {
                MaterialToast.fireToast(param1.toString());
                return true;
            });
        }
    }

    @UiHandler("clear")
    void clear(ClickEvent event) {
        LocalForage.clear().then((object) -> {
            MaterialToast.fireToast("Database is now empty");
            reloadPanel();
            return true;
        });
    }

    @UiHandler("length")
    void length(ClickEvent event) {
        LocalForage.length().then((object) -> {
            MaterialToast.fireToast(object + " Length");
            return true;
        });
    }

    @UiHandler("key")
    void key(ClickEvent event) {
        LocalForage.key(0).then((keyName) -> {
            MaterialToast.fireToast("Key: " + keyName);
            return true;
        });
    }

    @UiHandler("iterate")
    void iterate(ClickEvent event) {
        LocalForage.iterate((value, key, iterationNumber) -> {
            MaterialToast.fireToast(stringifyKeyValuePair(key, value.toString()));
        }).then((e, param1) -> {
            MaterialToast.fireToast("Iteration Complete");
            return true;
        });
    }

    protected void reloadPanel() {
        valuePanel.clear();
        LocalForage.keys().then((object) -> {
            if (object != null && !object.toString().isEmpty()) {
                Object[] keys = (Object[]) object;
                for (Object key : keys) {
                    getItem(key.toString(), value -> {
                        MaterialChip chip = new MaterialChip();
                        chip.setText(stringifyKeyValuePair(key.toString(), value));
                        valuePanel.add(chip);
                    });
                }
            }
            return true;
        });
    }

    protected void getItem(String key, Functions.Func1<String> callback) {
        LocalForage.getItem(key).then(object -> {
            callback.call(object + "");
            return true;
        });
    }

    protected String stringifyKeyValuePair(String key, String value) {
        return "[" + key + ", " + value + "]";
    }
}
