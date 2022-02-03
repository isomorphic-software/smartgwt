package com.smartgwt.sample.showcase.client.effects.animation;

import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AnimateTreeSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "Click the open/close icon for any folder.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            AnimateTreeSample panel = new AnimateTreeSample();
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
        
        Tree animalTree = new Tree();
        animalTree.setModelType(TreeModelType.CHILDREN);
        animalTree.setNameProperty("Name");
        animalTree.setRoot(new AnimateTreeNode("Zoo",
            new AnimateTreeNode("Aquarium",
                new AnimateTreeNode("Salt Water", 
                    new AnimateTreeNode("Bottlenose Dolphin"),
                    new AnimateTreeNode("Giant Pacific Octopus")
                ),
                new AnimateTreeNode("Fresh Water", 
                    new AnimateTreeNode("Freshwater Stingray")
                )
            ),
            new AnimateTreeNode("Reptile House",
                new AnimateTreeNode("Lizard House", 
                    new AnimateTreeNode("Cuban Ground Iguana"),
                    new AnimateTreeNode("Desert Iguana"),
                    new AnimateTreeNode("Marbled Salamander")
                ),
                new AnimateTreeNode("Snake House", 
                    new AnimateTreeNode("Indian Rock Python")
                ),
                new AnimateTreeNode("Monkey House", 
                    new AnimateTreeNode("Howler Monkey"),
                    new AnimateTreeNode("Orangutan"),
                    new AnimateTreeNode("Guinea Baboon")
                ),
                new AnimateTreeNode("Lion Enclosure",
                    new AnimateTreeNode("Lion")
                )
            )
        ));
        
        TreeGrid animalTreeGrid = new TreeGrid();
        animalTreeGrid.setData(animalTree);
        animalTreeGrid.setWidth(300);
        animalTreeGrid.setHeight(300);
        animalTreeGrid.setAnimateFolders(true);
        animalTreeGrid.setAnimateFolderSpeed(100);     
        
        VLayout layout = new VLayout();
        layout.setMembersMargin(10);
        layout.addChild(animalTreeGrid);
        return layout;
    }

    public static class AnimateTreeNode extends TreeNode  {
        public AnimateTreeNode(String name, AnimateTreeNode...children) {
            setTitle(name);
            setChildren(children);
        }        
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}