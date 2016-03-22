package com.google.gwtmockito.lienzo.util;

import com.ait.lienzo.client.core.event.NodeMouseClickEvent;
import com.ait.lienzo.client.core.shape.Node;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;

public class EventUtils {
    
    public static void click(final Node node, final int x, final int y) {
        ClickEvent clickEvent = new ClickEvent(){

            @Override
            public int getRelativeX(Element target) {
                return x;
            }

            @Override
            public int getRelativeY(Element target) {
                return y;
            }

            @Override
            public int getClientX() {
                return x;
            }

            @Override
            public int getClientY() {
                return y;
            }

            @Override
            public boolean isAltKeyDown() {
                return false;
            }

            @Override
            public boolean isControlKeyDown() {
                return false;
            }

            @Override
            public boolean isMetaKeyDown() {
                return false;
            }

            @Override
            public boolean isShiftKeyDown() {
                return false;
            }
        };

        node.fireEvent(new NodeMouseClickEvent(clickEvent));
        
    }
}
