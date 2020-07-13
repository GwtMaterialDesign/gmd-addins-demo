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
package gmd.addins.demo.client.application.beta.kanban;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.kanban.Kanban;
import gwt.material.design.incubator.client.kanban.js.KanbanBoard;
import gwt.material.design.incubator.client.kanban.js.KanbanItem;
import gwt.material.design.incubator.client.kanban.js.KanbanOptions;

import javax.inject.Inject;
import java.util.Arrays;

public class KanbanView extends ViewImpl implements KanbanPresenter.MyView {

    interface Binder extends UiBinder<Widget, KanbanView> {
    }

    @UiField
    Kanban kanban;

    @Inject
    KanbanView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        KanbanOptions options = KanbanOptions.create();
        options.setDragEl((param1, param2) -> {
            MaterialToast.fireToast("Drag El: " + param1 + " " + param2);
        });
        options.setDragendEl(param1 -> {
            MaterialToast.fireToast("DragendEl: " + param1);
        });
        options.setClick(param1 -> {
            MaterialToast.fireToast("Click: " + param1);
        });

        options.setDropEl((param1, param2, param3, param4) -> {
            MaterialToast.fireToast("DropEl" + param1 + " " + param2 + " " + param3 + " " + param4);
        });

        options.setDragBoard((param1, param2) -> {
            MaterialToast.fireToast("DragBoard" + param1 + " " + param2);
        });

        options.setDragendBoard(param1 -> {
            MaterialToast.fireToast("DragendBoard: " + param1);
        });

        options.setButtonClick((param1, param2) -> {
            MaterialToast.fireToast("ButtonClick: " + param1 + " " + param2);
        });
        kanban.setOptions(options);
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        kanban.clearAllBoards();
        kanban.addBoards(createBoard("Backlog"),
            createBoard("TODO"),
            createBoard("OnGoing"),
            createBoard("Done"));
    }

    public KanbanBoard createBoard(String title) {
        KanbanBoard board = new KanbanBoard();
        board.setId(DOM.createUniqueId());
        board.setTitle(title);
        board.setItems(Arrays.asList(createItem("Item 1"),
            createItem("Item 2")));
        return board;
    }

    private KanbanItem createItem(String title) {
        KanbanItem item = new KanbanItem();
        item.setId(DOM.createUniqueId());
        item.setTitle(title);
        return item;
    }
}
