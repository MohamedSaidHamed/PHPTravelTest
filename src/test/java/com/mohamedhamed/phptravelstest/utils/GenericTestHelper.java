/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohamedhamed.phptravelstest.utils;

/**
 *
 * @author Mohamed
 */
public class GenericTestHelper {
    //Ability to add more attributes as needed.
    private ElementTypes elemType; 
    private String attrXpath; 
    private String value;

    /**
     *
     * @param elemType
     * @param attrXpath
     * @param value
     */
    public GenericTestHelper(ElementTypes elemType, String attrXpath, String value) {
        this.elemType = elemType;
        this.attrXpath = attrXpath;
        this.value = value;
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     *
     * @return
     */
    public String getAttrXpath() {
        return attrXpath;
    }

    /**
     *
     * @param attrXpath
     */
    public void setAttrXpath(String attrXpath) {
        this.attrXpath = attrXpath;
    }

    /**
     *
     * @return
     */
    public ElementTypes getElemType() {
        return elemType;
    }

    /**
     *
     * @param elemType
     */
    public void setElemType(ElementTypes elemType) {
        this.elemType = elemType;
    }
}
