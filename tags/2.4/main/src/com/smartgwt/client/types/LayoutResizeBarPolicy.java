package com.smartgwt.client.types;

/**
 * Policy for whether resize bars are shown on members by default.
 */
public enum LayoutResizeBarPolicy implements ValueEnum {

    /**
     * resize bars are only shown on members marked showResizeBar:true
     */
    MARKED("marked"),

    /**
     * resize bars are shown on all resizable members that are not explicitly marked showResizeBar:false, except the last member.
     * Appropriate for a LayoutPolicy of "fill" (VLayout, HLayout) since the overall space will always be filled.
     */
    MIDDLE("middle"),
    /**
     * resize bars are shown on all resizable members that are not explicitly marked showResizeBar:false, including the
     * last member. Can be appropriate for a LayoutPolicy of "none" (VStack, HStack) since the overall size of the layout
     *  is dictated by it's member's sizes.
     */
    ALL("all"),

    /**
     * resize bars are not shown even if members are marked with showResizeBar:true
     */
    NONE("none");


    private String value;

    LayoutResizeBarPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
