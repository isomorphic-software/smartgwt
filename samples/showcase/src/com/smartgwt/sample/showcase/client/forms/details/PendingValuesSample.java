package com.smartgwt.sample.showcase.client.forms.details;

import java.util.LinkedHashMap;
import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TimeItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Criteria;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class PendingValuesSample extends ShowcasePanel {
    private static final String DESCRIPTION = "FormItems support a pending visual state that can be used to style "+
        "the item differently when the user changes the value from the last-saved value."+
        "<p>"+
        "Select a user to populate the form with the user's favorites. If any field's value is changed from the "+
        "initial value, then the item will be drawn in the \"Pending\" state. The item will switch back to the "+
        "normal visual state if the value is changed back to the initial value."+
        "<p>"+
        "This example also sets a revertValueKey on the form. While an item is focused, pressing the Escape key "+
        "will reset the item's value to whatever value would be shown if DynamicForm.resetValues() were called.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	PendingValuesSample panel = new PendingValuesSample();
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
        DepartmentTreeNode[] children = new DepartmentTreeNode[4];
        children[0] = new DepartmentTreeNode(1000, "Marketing");
        children[0].setChildren(new DepartmentTreeNode[] {
            new DepartmentTreeNode(1001, "Advertising"),
            new DepartmentTreeNode(1002, "Community Relations")
        });
        children[1] = new DepartmentTreeNode(2000, "Sales");
        children[1].setChildren(new DepartmentTreeNode[] {
            new DepartmentTreeNode(2001, "Channel Sales"),
            new DepartmentTreeNode(2002, "Direct Sales")
        });
        children[2] = new DepartmentTreeNode(3000, "Manufacturing");
        children[2].setChildren(new DepartmentTreeNode[] {
            new DepartmentTreeNode(3001, "Design"),
            new DepartmentTreeNode(3002, "Development"),
            new DepartmentTreeNode(3003, "QA")
        });
        children[3] = new DepartmentTreeNode(4000, "Services");
        children[3].setChildren(new DepartmentTreeNode[] {
            new DepartmentTreeNode(4001, "Support"),
            new DepartmentTreeNode(4002, "Consulting")
        });		
        TreeNode rootNode = new TreeNode("root");
        rootNode.setChildren(children);
		
        Tree departmentTree = new Tree();
        departmentTree.setModelType(TreeModelType.CHILDREN);
        departmentTree.setRoot(rootNode);
		
        ListGridRecord records[] = new ListGridRecord[4];
        records[0] = new ListGridRecord();
        records[0].setAttribute("id", 1);
        records[0].setAttribute("name", "Max");
        records[1] = new ListGridRecord();
        records[1].setAttribute("id", 2);
        records[1].setAttribute("name", "Bethany");
        records[2] = new ListGridRecord();
        records[2].setAttribute("id", 3);
        records[2].setAttribute("name", "Zach");
        records[3] = new ListGridRecord();
        records[3].setAttribute("id", 4);
        records[3].setAttribute("name", "Francesca");
		
        DataSource clientOnlyUsersDS = new DataSource();
        clientOnlyUsersDS.setClientOnly(true);
        DataSourceIntegerField id = new DataSourceIntegerField();
        id.setTitle("ID");
        id.setPrimaryKey(true);
        id.setHidden(true);
        DataSourceTextField name = new DataSourceTextField();
        name.setTitle("Name");
		
        clientOnlyUsersDS.setFields(id, name);
        clientOnlyUsersDS.setCacheData(records);
		
        DataSource clientOnlyUserFavoritesDS = new DataSource();
        clientOnlyUserFavoritesDS.setClientOnly(true);
        DataSourceTextField id1 = new DataSourceTextField("id", "ID");
        id1.setPrimaryKey(true);
        id1.setHidden(true);
        DataSourceIntegerField userID = new DataSourceIntegerField("userID", "User ID");
        userID.setForeignKey("clientOnlyUsersDS.id");
        DataSourceTextField favoriteAnimal = new DataSourceTextField("favoriteAnimal", "Favorite Animal");
        DataSourceIntegerField favoriteNumber = new DataSourceIntegerField("favoriteNumber");
        favoriteNumber.setTitle("Favorite Integer (0 - 100)");
        DataSourceBooleanField hasFavoriteColor = new DataSourceBooleanField("hasFavoriteColor");
        hasFavoriteColor.setTitle("Has a Favorite Color?");
        DataSourceField favoriteColor = new DataSourceField();
        favoriteColor.setValueMap("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet");
        favoriteColor.setName("favoriteColor");
        DataSourceDateField favoriteDate = new DataSourceDateField("favoriteDate", "Favorite Date");
		DataSourceDateTimeField favoriteTime = new DataSourceDateTimeField("favoriteTime", "Favorite Time");
        DataSourceField favoriteMusicGenres = new DataSourceField();
        favoriteMusicGenres.setMultiple(true);
        favoriteMusicGenres.setName("favoriteMusicGenres");
        favoriteMusicGenres.setTitle("Favorite Music Genres");
        favoriteMusicGenres.setValueMap("Alternative", "Classical", "Country", "Folk", "Hip Hop", "Jazz", "Pop", 
                                        "R&B", "Rock", "World", "Other");
		
        DataSourceField favoriteVacationDestination = new DataSourceField();
        favoriteVacationDestination.setTitle("Favorite Vacation Destination");
        favoriteVacationDestination.setName("favoriteVacationDestination");
        LinkedHashMap<String,String> valueMap = new LinkedHashMap<String,String>();
        valueMap.put("AS", "Australia");
        valueMap.put("BR", "Brazil");
        valueMap.put("CA", "Canada");
        valueMap.put("CH", "China");
        valueMap.put("FR", "France");
        valueMap.put("GM", "Germany");
        valueMap.put("IN", "India");
        valueMap.put("ID", "Indonesia");
        valueMap.put("IT", "Italy");
        valueMap.put("JA", "Japan");
        valueMap.put("MX", "Mexico");
        valueMap.put("RS", "Russia");
        valueMap.put("KS", "South Korea");
        valueMap.put("SP", "Spain");
        valueMap.put("UK", "United Kingdom");
        valueMap.put("US", "United States");
        favoriteVacationDestination.setValueMap(valueMap);
		
        DataSourceField favoriteCuisines = new DataSourceField();
        favoriteCuisines.setMultiple(true);
        favoriteCuisines.setName("favoriteCuisines");
        favoriteCuisines.setTitle("Favorite Cuisines");
        LinkedHashMap<String,String> cuisinesMap = new LinkedHashMap<String,String>();
        cuisinesMap.put("US", "American");
        cuisinesMap.put("AS", "Australian");
        cuisinesMap.put("BR", "Brazilian");
        cuisinesMap.put("UK", "British");
        cuisinesMap.put("CA", "Canadian");
        cuisinesMap.put("CH", "Chinese");
        cuisinesMap.put("FR", "French");
        cuisinesMap.put("GM", "German");
        cuisinesMap.put("IN", "Indian");
		cuisinesMap.put("ID", "Indonesian");
        cuisinesMap.put("IT", "Italian");
        cuisinesMap.put("JA", "Japanese");
        cuisinesMap.put("KS", "Korean");
        cuisinesMap.put("MX", "Mexican");
        cuisinesMap.put("RS", "Russian");
        cuisinesMap.put("SP", "Spanish");
        favoriteCuisines.setValueMap(cuisinesMap);
		
        DataSourceField favoriteDepartment = new DataSourceField();
        favoriteDepartment.setTitle("Favorite Department");
        favoriteDepartment.setName("favoriteDepartment");
		        		
        clientOnlyUserFavoritesDS.setFields(id1, userID, favoriteAnimal, favoriteNumber, hasFavoriteColor, favoriteColor, 
                    favoriteDate, favoriteTime, favoriteMusicGenres, favoriteVacationDestination, favoriteCuisines,
				    favoriteDepartment);
		
        DateTimeFormat formatDate = DateTimeFormat.getFormat("yyyyMMdd");
        DateTimeFormat formatTime = DateTimeFormat.getFormat("HH:mm");
        UserData record1 = new UserData(1, 1, "Lemur", 90, false, formatDate.parse("20000101"), formatTime.parse("00:00"),
                new String[]{"Classical", "Rock", "World"}, "JA", new String[]{"CA", "CH", "IN", "RS"}, "4002", null);
        UserData record2 = new UserData(2, 2, "Zebra", 12, true, formatDate.parse("20121212"), formatTime.parse("12:12"),
				new String[]{"Alternative", "Hip Hop"}, "US", new String[]{"US", "AS", "BR", "UK"}, "3002", "Orange");
        UserData record3 = new UserData(3, 3, "Elephant", 10, true, formatDate.parse("20101010"), formatTime.parse("10:10"),
				new String[]{"Country", "Folk"}, "MX", new String[]{"GM", "ID", "JA", "MX"}, "1001", "Green");
        UserData record4 = new UserData(4, 4, "Blue Whale", 55, true, formatDate.parse("20050505"), formatTime.parse("12:00"),
				new String[]{"Pop", "R&B", "Other"}, "SP", new String[]{"FR", "IT", "KS", "SP"}, "3001", "Blue");
		
        clientOnlyUserFavoritesDS.setCacheData(record1, record2, record3, record4);
		
        final DynamicForm favoritesForm = new DynamicForm();
        favoritesForm.setAutoFetchData(true);
        Criteria initialCriteria = new Criteria();
        initialCriteria.setAttribute("userID", 1);
        favoritesForm.setInitialCriteria(initialCriteria);
        favoritesForm.setWidth(500);
        favoritesForm.setColWidths(175, "*");
        favoritesForm.setDataSource(clientOnlyUserFavoritesDS);
		
        KeyIdentifier keyIdentifier = new KeyIdentifier();
        keyIdentifier.setKeyName("Escape");
        favoritesForm.setRevertValueKey(keyIdentifier);
		
        SelectItem userIDItem = new SelectItem();
        userIDItem.setTitle("User");
        userIDItem.setName("userID");
        userIDItem.setOptionDataSource(clientOnlyUsersDS);
        userIDItem.setValueField("id");
        userIDItem.setDisplayField("name");
        userIDItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                Criteria criteria = new Criteria();
                criteria.setAttribute("userID", event.getValue());
                favoritesForm.fetchData(criteria, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object data,
                                        DSRequest dsRequest) {
                        boolean hasFavoriteColor = (data != null && dsResponse.getData().length >= 1 &&
                                                    !!dsResponse.getData()[0].getAttributeAsBoolean("hasFavoriteColor"));
                        favoritesForm.getItem("favoriteColor").setDisabled(!hasFavoriteColor);
                    }
                });
            }
        });
        TextItem favoriteAnimalItem = new TextItem();
        favoriteAnimalItem.setShowPending(true);
        favoriteAnimalItem.setName("favoriteAnimal");
		
        SliderItem favoriteNumberItem = new SliderItem();
        favoriteNumberItem.setHeight(30);
        favoriteNumberItem.setMinValue(0);
        favoriteNumberItem.setMaxValue(100);
        favoriteNumberItem.setShowPending(true);
        favoriteNumberItem.setName("favoriteNumber");
		
        CheckboxItem hasFavoriteColorItem = new CheckboxItem();
        hasFavoriteColorItem.setShowPending(true);
        hasFavoriteColorItem.setName("hasFavoriteColor");
        hasFavoriteColorItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                favoritesForm.getItem("favoriteColor").setDisabled(!(Boolean)event.getValue());
            }
        });
		
        RadioGroupItem favoriteColorItem = new RadioGroupItem();
        favoriteColorItem.setDisabled(true);
        favoriteColorItem.setName("favoriteColor");
        favoriteColorItem.setShowPending(true);
		
        DateItem favoriteDateItem = new DateItem();
        favoriteDateItem.setShowPending(true);
        favoriteDateItem.setName("favoriteDate");
		
        TimeItem favoriteTimeItem = new TimeItem();
        favoriteTimeItem.setShowPending(true);
        favoriteTimeItem.setName("favoriteTime");
		
        MultiComboBoxItem favoriteMusicGenresItem = new MultiComboBoxItem();
        favoriteMusicGenresItem.setUseInsertionOrder(false);
        favoriteMusicGenresItem.setName("favoriteMusicGenres");
        favoriteMusicGenresItem.setShowPending(true);
		
        SelectItem favoriteVacationDestinationItem = new SelectItem();
        favoriteVacationDestinationItem.setWrapTitle(false);
        favoriteVacationDestinationItem.setShowPending(true);
        favoriteVacationDestinationItem.setName("favoriteVacationDestination");
        favoriteVacationDestinationItem.setImageURLPrefix("flags/16/");
        favoriteVacationDestinationItem.setImageURLSuffix(".png");
		LinkedHashMap<String, String> valueIcons = new LinkedHashMap<String, String>();  
        valueIcons.put("AS", "AS");
        valueIcons.put("BR", "BR");
        valueIcons.put("CA", "CA");
		valueIcons.put("CH", "CH");
		valueIcons.put("FR", "FR");
		valueIcons.put("GM", "GM");
		valueIcons.put("IN", "IN");
		valueIcons.put("ID", "ID");
		valueIcons.put("IT", "IT");
		valueIcons.put("JA", "JA");
		valueIcons.put("MX", "MX");
		valueIcons.put("RS", "RS");
		valueIcons.put("KS", "KS");
		valueIcons.put("SP", "SP");
		valueIcons.put("UK", "UK");
		valueIcons.put("US", "US");
        favoriteVacationDestinationItem.setValueIcons(valueIcons);
		
        SelectItem favoriteCuisinesItem = new SelectItem();
        favoriteCuisinesItem.setWidth("*");
        favoriteCuisinesItem.setName("favoriteCuisines");
        favoriteCuisinesItem.setShowPending(true);
        favoriteCuisinesItem.setImageURLPrefix("flags/16/");
        favoriteCuisinesItem.setImageURLSuffix(".png");
        favoriteCuisinesItem.setValueIcons(valueIcons);
		
        PickTreeItem favoriteDepartmentItem = new PickTreeItem();
        favoriteDepartmentItem.setWidth(140);
        favoriteDepartmentItem.setDisplayField("name");
        favoriteDepartmentItem.setName("favoriteDepartment");
        favoriteDepartmentItem.setValueField("id");
        favoriteDepartmentItem.setValueTree(departmentTree);
        favoriteDepartmentItem.setShowPending(true);
		
        favoritesForm.setFields(userIDItem, favoriteAnimalItem, favoriteNumberItem, hasFavoriteColorItem, favoriteColorItem, 
                                favoriteDateItem, favoriteTimeItem, favoriteMusicGenresItem, favoriteVacationDestinationItem, 
				                favoriteCuisinesItem, favoriteDepartmentItem);
		
        HStack hStack = new HStack();
        hStack.setWidth100();
        hStack.setMembers(favoritesForm);
		
        return hStack;
    }

    public class UserData extends ListGridRecord {  
    	  
        public UserData(int ID, int userID, String favoriteAnimal, int favoriteNumber, boolean hasFavoriteColor,
                        Date favoriteDate, Date favoriteTime, String[] favoriteMusicGenres, String favoriteVacationDestination, 
                        String[] favoriteCuisines, String favoriteDepartment, String favoriteColor) {  
            setID(ID);  
            setUserID(userID);  
            setFavoriteAnimal(favoriteAnimal);
            setFavoriteNumber(favoriteNumber);  
            setHasFavoriteColor(hasFavoriteColor);  
            setFavoriteDate(favoriteDate);  
            setFavoriteTime(favoriteTime);  
            setFavoriteMusicGenres(favoriteMusicGenres);  
            setFavoriteVacationDestination(favoriteVacationDestination);
            setFavoriteCuisines(favoriteCuisines);  
            setFavoriteDepartment(favoriteDepartment);
            setFavoriteColor(favoriteColor);
        }  
  
        public void setID(int ID) {  
            setAttribute("ID", ID);  
        }  
        public void setUserID(int userID) {  
            setAttribute("userID", userID);  
        }  
        public void setFavoriteAnimal(String favoriteAnimal) {  
            setAttribute("favoriteAnimal", favoriteAnimal);  
        }  
        public void setFavoriteNumber(int favoriteNumber) {  
            setAttribute("favoriteNumber", favoriteNumber);  
        }  
        public void setHasFavoriteColor(boolean hasFavoriteColor) {  
            setAttribute("hasFavoriteColor", hasFavoriteColor);  
        }  
        public void setFavoriteDate(Date favoriteDate) {  
            setAttribute("favoriteDate", favoriteDate);  
        }  
        public void setFavoriteTime(Date favoriteTime) {  
            setAttribute("favoriteTime", favoriteTime);  
        }  
        public void setFavoriteMusicGenres(String[] favoriteMusicGenres) {  
            setAttribute("favoriteMusicGenres", favoriteMusicGenres);  
        }    
        public void setFavoriteVacationDestination(String favoriteVacationDestination) {  
            setAttribute("favoriteVacationDestination", favoriteVacationDestination);  
        }
        public void setFavoriteCuisines(String[] favoriteCuisines) {  
            setAttribute("favoriteCuisines", favoriteCuisines);  
        }    
        public void setFavoriteDepartment(String favoriteDepartment) {  
            setAttribute("favoriteDepartment", favoriteDepartment);  
        }
        public void setFavoriteColor(String favoriteColor) {  
            setAttribute("favoriteColor", favoriteColor);  
        }
    }  
    
    public class DepartmentTreeNode extends TreeNode {  
        public DepartmentTreeNode(int id, String name) {  
            setAttribute("id", id);
            setAttribute("name", name);  
        }  
    } 
    
    public String getIntro() {
        return DESCRIPTION;
    }
}