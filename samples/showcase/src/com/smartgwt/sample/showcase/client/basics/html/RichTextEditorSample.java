package com.smartgwt.sample.showcase.client.basics.html;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class RichTextEditorSample extends ShowcasePanel {
    private static final String DESCRIPTION = "RichTextEditor supports editing of HTML with a configurable set of styling controls.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RichTextEditorSample panel = new RichTextEditorSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {
        String ajaxDefinition =
                "<span style='font-size:22px;'>Ajax</span> " +
                        "<b>A</b>synchronous <b>J</b>avaScript <b>A</b>nd <b>X</b>ML (AJAX) is a " +
                        "Web development technique for creating interactive <b>web applications</b>. " +
                        "The intent is to make web pages feel more responsive by exchanging small " +
                        "amounts of data with the server behind the scenes, so that the entire Web " +
                        "page does not have to be reloaded each time the user makes a change. " +
                        "This is meant to increase the Web page's <b>interactivity</b>, <b>speed</b>, " +
                        "and <b>usability</b>.<br>" +
                        "(Source: <a href='http://www.wikipedia.org' title='Wikipedia' target='_blank'>Wikipedia</a>)";

        VLayout layout = new VLayout();
        layout.setMembersMargin(5);

        final Canvas htmlCanvas = new Canvas();
        htmlCanvas.setHeight(130);
        htmlCanvas.setPadding(2);
        htmlCanvas.setOverflow(Overflow.HIDDEN);
        htmlCanvas.setCanDragResize(true);
        htmlCanvas.setShowEdges(true);
        htmlCanvas.setContents("Click <b>Set Canvas HTML</b> to display edited content.");

        final RichTextEditor richTextEditor = new RichTextEditor();
        richTextEditor.setHeight(155);
        richTextEditor.setOverflow(Overflow.HIDDEN);
        richTextEditor.setCanDragResize(true);
        richTextEditor.setShowEdges(true);

        // Standard control group options include
        // "fontControls", "formatControls", "styleControls" and "colorControls"
        //richTextEditor.setControlGroups(new String[]{"fontControls", "styleControls"});
        richTextEditor.setValue(ajaxDefinition);
        layout.addMember(richTextEditor);

        IButton button = new IButton("Set Canvas HTML");
        button.setWidth(150);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                htmlCanvas.setContents(richTextEditor.getValue());
            }
        });

        layout.addMember(button);
        layout.addMember(htmlCanvas);

        return layout;

    }

    public String getIntro() {
        return DESCRIPTION;
    }
}