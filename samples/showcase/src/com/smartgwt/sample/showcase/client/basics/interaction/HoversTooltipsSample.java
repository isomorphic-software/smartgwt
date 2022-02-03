package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class HoversTooltipsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Hover over the button, the image, the \"Interesting Facts\" field of the grid, and the \"Severity\" form label to see various hovers.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            HoversTooltipsSample panel = new HoversTooltipsSample();
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

        Canvas canvas = new Canvas();
        ListGrid grid = new ListGrid();
        grid.setWidth("80%");
        grid.setHeight(84);
        grid.setLeaveScrollbarGap(false);
        grid.setHoverWidth(300);

        ListGridField commonNameField = new ListGridField("commonName", "Animal");
        commonNameField.setHidden(true);

        ListGridField sceintificField = new ListGridField("scientificName", "Scientific Name");
        ListGridField dietField = new ListGridField("diet", "Diet");
        ListGridField informationField = new ListGridField("information", "Interesting Facts");
        informationField.setShowHover(true);

        grid.setFields(commonNameField, sceintificField, dietField, informationField);

        grid.setData(new AnimalRecord[]{
                new AnimalRecord("Platypus", "Ornithorhynchus Anatinus", "Insects and Larvae", "Were thought to be a hoax when first discovered. The male has a venemous spur on his hind legs.  Capable of many vocalizations including sounds like a growling puppy and a brooding hen."),
                new AnimalRecord("Elephant (African)", "Loxodonta africana", "Herbivore", "The African Elephant is the largest of all land animals and also has the biggest brain of any land animal. Both males and females have ivory tusks. Elephants are also wonderful swimmers. Man is the only real enemy of the elephant. Man threatens the elephant by killing it for its tusks and by destroying its habitat."),
                new AnimalRecord("Alligator (American)", "Allligator mississippiensis", "Carnivore", "In the 16th century, Spanish explorers in what is now Florida encountered a large formidable animal which they called \"el largo\" meaning \"the lizard\". The name \"el largo\" gradually became pronounced \"alligator\".")
        });
        canvas.addChild(grid);

        IButton button = new IButton("Close Issue");
        button.setDisabled(true);
        button.setTop(150);
        button.setPrompt("You cannot close this issue - see the owner");
        button.setHoverWidth(150);
        canvas.addChild(button);

        Img img = new Img("other/eyes.jpg", 90, 47);
        img.setLeft(180);
        img.setTop(100);
        img.setPrompt("360px by 188px<BR>25k<BR>JPEG high quality");
        img.setHoverWidth(120);
        img.setHoverOpacity(75);
        img.setHoverStyle("interactImageHover");
        canvas.addChild(img);

        DynamicForm form = new DynamicForm();
        form.setLeft(220);
        form.setTop(190);
        form.setWidth(200);
        form.setItemHoverWidth(200);
        form.setItemHoverStyle("interactFormHover");

        StaticTextItem severityField = new StaticTextItem();
        severityField.setName("severityLevel");
        severityField.setTitle("Severity Level");
        severityField.setWrapTitle(false);
        severityField.setDefaultValue("Severity 2");
        severityField.setPrompt("<b>Severity 1</b> - Critical problem<br>System is unavailable in production or " +
                "is corrupting data, and the error severely impacts the user's operations." +
                "<br><br><b>Severity 2</b> - Major problem<br>An important function of the system " +
                "is not available in production, and the user's operations are restricted." +
                "<br><br><b>Severity 3</b> - Minor problem<br>Inability to use a function of the " +
                "system occurs, but it does not seriously affect the user's operations.");

        form.setFields(severityField);
        canvas.addChild(form);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    class AnimalRecord extends ListGridRecord {

        public AnimalRecord(String commonName, String scientificName, String diet, String information) {
            setCommonName(commonName);
            setScientificName(scientificName);
            setDiet(diet);
            setInformation(information);
        }

        public void setCommonName(String commonName) {
            setAttribute("commonName", commonName);
        }

        public void setScientificName(String scientificName) {
            setAttribute("scientificName", scientificName);
        }

        public void setDiet(String diet) {
            setAttribute("diet", diet);
        }

        public void setInformation(String information) {
            setAttribute("information", information);
        }
    }
}