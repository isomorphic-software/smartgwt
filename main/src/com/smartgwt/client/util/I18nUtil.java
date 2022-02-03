/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.i18n.SmartGwtMessages;

public class I18nUtil {

    private static boolean initialized = false;

    /**
     * Setup SmartGWT i18n.
     */
    public static void init() {
        if(!initialized) {
            SmartGwtMessages messages = GWT.create(SmartGwtMessages.class);
            initMessages(messages);
            initBuiltinTypes();
        }
    }

    private static native void initBuiltinTypes() /*-{
        if($wnd.isc.builtinTypes) {
            $wnd.isc.builtinTypes.localeInt.normalDisplayFormatter = 
            $wnd.isc.builtinTypes.localeInt.shortDisplayFormatter = function (value, field) {
                if (!value) return value;
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                var formattedValueJ = @com.smartgwt.client.util.I18nUtil::formatLocaleInt(Ljava/lang/Object;)(valueJ);
                return $wnd.SmartGWT.convertToPrimitiveType(formattedValueJ);
            };
            
            $wnd.isc.builtinTypes.localeFloat.normalDisplayFormatter = 
            $wnd.isc.builtinTypes.localeFloat.shortDisplayFormatter = function (value, field) {
                if (!value) return value;
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                var precisionJ = $wnd.SmartGWT.convertToJavaType(field.precision);
                var formattedValueJ = @com.smartgwt.client.util.I18nUtil::formatLocaleFloat(Ljava/lang/Object;Ljava/lang/Object;)(valueJ,precisionJ);
                return $wnd.SmartGWT.convertToPrimitiveType(formattedValueJ);
            };
            $wnd.isc.builtinTypes.localeCurrency.normalDisplayFormatter = 
            $wnd.isc.builtinTypes.localeCurrency.shortDisplayFormatter = function (value, field) {
                if (!value) return value;
                var valueJ = $wnd.SmartGWT.convertToJavaType(value);
                var formattedValueJ = @com.smartgwt.client.util.I18nUtil::formatLocaleCurrency(Ljava/lang/Object;)(valueJ);
                return $wnd.SmartGWT.convertToPrimitiveType(formattedValueJ);
            };
        }
        if($wnd.isc.NumberUtil) {
            // Note that neither parseInt() nor parseFloat() below perfectly matches the native
            // browser behavior.  The goal is presumably to use the GWT NumberFormat APIs since
            // they support the locale-specific custom digit separator, decimal marker, etc.
            //
            // For example, NumberFormat's "decimal format" doesn't understand exponential
            // notation, and doesn't just drop trailing text gracefully, so we have:
            //
            // Input String    SGWT NumberUtil.parseFloat()    Native JS parseFloat()
            //   "1e-2"                NaN                             0.01
            //   "4.5foo"              NaN                             4.5
            //
            // Furthermore, the SGWT NumberUtil.parseInt() below works by just truncating the
            // output of our NumberUtil.parseFloat(), so it doesn't pefectly replicate the
            // native JS API either:
            //
            // Input String    SGWT NumberUtil.parseInt()    Native JS parseFloat()
            //   ".56"                 0                             NaN
            //   "7foo"                NaN                           7
            //
            // If digit separators are used, these functions also differ from both the native
            // APIs and the defualt SC Framework NumberUtil methods:
            //
            //   parseInt() Input String    SGWT NumberUtil    SC NumberUtil    Native JS
            //           "5,123"                5123               5123           5
            // parseFloat() Input String    SGWT NumberUtil    SC NumberUtil    Native JS
            //           "5.1,2"                NaN                5.12           5.1

            $wnd.isc.NumberUtil.parseInt = function sgwt_NumberUtil_parseInt_override (string) {
                var result = this.parseFloat(string);
                return Math.floor(result);
            },
            $wnd.isc.NumberUtil.parseFloat = function sgwt_NumberUtil_parseFloat_override (string) {
                var objType = typeof string;
                // pass through any number to output
                if (objType == 'number') return string;

                // otherwise default to NaN
                var formattedValueJ = NaN;
                if (objType == 'string') {
                    var valueJ = $wnd.SmartGWT.convertToJavaType(string);
                    formattedValueJ = @com.smartgwt.client.util.I18nUtil::parseNum(Ljava/lang/String;)(valueJ);
                }
                return $wnd.SmartGWT.convertToPrimitiveType(formattedValueJ);
            };

            var currencySymbol = @com.smartgwt.client.util.I18nUtil::getLocaleCurrencySymbol()();
            if (currencySymbol == "US$") currencySymbol == "$";
            $wnd.isc.NumberUtil.currencySymbol = currencySymbol;
            $wnd.isc.NumberUtil.decimalSymbol = @com.smartgwt.client.util.I18nUtil::getLocaleDecimalSymbol()();
            $wnd.isc.NumberUtil.groupingSymbol = @com.smartgwt.client.util.I18nUtil::getLocaleGroupingSymbol()();
            $wnd.isc.NumberUtil.negativeSymbol = @com.smartgwt.client.util.I18nUtil::getLocaleNegativeSymbol()();
            
        }
    }-*/;
    
    public static String formatLocaleInt(Object value) {
        // since this is a numeric formatter, it is expected to receive a numeric parameter 
        //  - if it's null or an empty string, return an empty string
        //  - if it can be cast to Number, format it with NumberFormat, according to the locale
        //  - otherwise, return the stringified value
        if (value == null || "".equals(value)) return "";
        try {
        return com.google.gwt.i18n.client.NumberFormat.getDecimalFormat().format((Number)value);
    }
        catch (ClassCastException e) {
            return value.toString();
        }
    }
    
    public static String formatLocaleFloat(Object value, Object precision) {
        // since this is a numeric formatter, it is expected to receive a numeric parameter 
        //  - if it's null or an empty string, return an empty string
        //  - if it can be cast to Number, format it with NumberFormat, according to the locale
        //  - otherwise, return the stringified value
        if (value == null || "".equals(value)) return "";
        try {
        return com.google.gwt.i18n.client.NumberFormat.getDecimalFormat().format((Number)value);
    }
        catch (ClassCastException e) {
            return value.toString();
        }
    }
    
    public static String formatLocaleCurrency(Object value) {
        // since this is a numeric formatter, it is expected to receive a numeric parameter 
        //  - if it's null or an empty string, return an empty string
        //  - if it can be cast to Number, format it with NumberFormat, according to the locale
        //  - otherwise, return the stringified value
        if (value == null || "".equals(value)) return "";
        try {
        return com.google.gwt.i18n.client.NumberFormat.getCurrencyFormat().format((Number)value);
    }
        catch (ClassCastException e) {
            return value.toString();
        }
    }
    
    public static String getLocaleCurrencySymbol() {
        String rtn = com.google.gwt.i18n.client.NumberFormat.getFormat("\u00A4").format(0);
        return rtn.substring(rtn.length()-2,rtn.length()-1);
    }
    
    public static String getLocaleDecimalSymbol() {
        return com.google.gwt.i18n.client.NumberFormat.getFormat("0.00").format(0).substring(1,2);
    }
    
    public static String getLocaleGroupingSymbol() {
        return com.google.gwt.i18n.client.NumberFormat.getFormat("0,000").format(1234).substring(1,2);
    }
    
    public static String getLocaleNegativeSymbol() {
        return com.google.gwt.i18n.client.NumberFormat.getFormat("0").format(-1).substring(0,1);
    }
    
    public static double parseNum(String string) {
        // first try currency format
        try {
            return com.google.gwt.i18n.client.NumberFormat.getCurrencyFormat().parse(string);   
        } catch (NumberFormatException ex) {}

        // next try decimal format
        try {
            return com.google.gwt.i18n.client.NumberFormat.getDecimalFormat().parse(string);

        } catch (NumberFormatException ex) {
            return Float.NaN;
        }
    }

    /**
     * Initialize Smart GWT with i18n translations.
     *
     * @param messages the SmartGWT messages
     */
    public static native void initMessages(SmartGwtMessages messages) /*-{
//>localeGenerator -- SC locale parser will process whatever's inside these tags
        if($wnd.isc.Dialog) {
            $wnd.isc.Dialog.addClassProperties({OK_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_OkButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({APPLY_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_ApplyButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({YES_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_YesButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({NO_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_NoButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({CANCEL_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_CancelButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({DONE_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_DoneButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({CONFIRM_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_ConfirmTitle()()});
            $wnd.isc.Dialog.addClassProperties({SAY_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_SayTitle()()});
            $wnd.isc.Dialog.addClassProperties({WARN_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_WarnTitle()()});
            $wnd.isc.Dialog.addClassProperties({ASK_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_AskTitle()()});
            $wnd.isc.Dialog.addClassProperties({ASK_FOR_VALUE_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_AskForValueTitle()()});
            $wnd.isc.Dialog.addClassProperties({LOGIN_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_LoginTitle()()});
            $wnd.isc.Dialog.addClassProperties({USERNAME_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_UserNameTitle()()});
            $wnd.isc.Dialog.addClassProperties({PASSWORD_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_PasswordTitle()()});
            $wnd.isc.Dialog.addClassProperties({LOGIN_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_LoginButtonTitle()()});
            $wnd.isc.Dialog.addClassProperties({LOGIN_ERROR_MESSAGE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_LoginErrorMessage()()});
        }

        if($wnd.isc.BatchUploader) {
            $wnd.isc.BatchUploader.addProperties({uploadButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_uploadButtonTitle()()});
            $wnd.isc.BatchUploader.addProperties({uploadFileLabel: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_uploadFileLabel()()});
            $wnd.isc.BatchUploader.addProperties({commitConfirmationMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_commitConfirmationMessage()()});
            $wnd.isc.BatchUploader.addProperties({discardedColumnsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_discardedColumnsMessage()()).replace(/(\$discardedColumns)/g, '${discardedColumns}')});
            
            $wnd.isc.BatchUploader.addProperties({allRecordsInErrorMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_allRecordsInErrorMessage()()});
            $wnd.isc.BatchUploader.addProperties({partialCommitConfirmationMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_partialCommitConfirmationMessage()()});
            $wnd.isc.BatchUploader.addProperties({updatesRolledBackMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_updatesRolledBackMessage()()});
            $wnd.isc.BatchUploader.addProperties({partialCommitPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_partialCommitPrompt()()});
            $wnd.isc.BatchUploader.addProperties({partialCommitError: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_partialCommitError()()});
            $wnd.isc.BatchUploader.addProperties({cancelConfirmMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_cancelConfirmMessage()()});
            
            $wnd.isc.BatchUploader.addProperties({commitButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_commitButtonTitle()()});
            $wnd.isc.BatchUploader.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_cancelButtonTitle()()});
            
            $wnd.isc.BatchUploader.addProperties({errorMessageFileIsBlank: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageFileIsBlank()()});
            $wnd.isc.BatchUploader.addProperties({errorMessageUnterminatedQuote: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageUnterminatedQuote()()).replace(/(\$errorOffset)/g, '${errorOffset}')});
            $wnd.isc.BatchUploader.addProperties({errorMessageDelimiterOrEndOfLine: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageDelimiterOrEndOfLine()()).replace(/(\$errorOffset)/g, '${errorOffset}')});
            $wnd.isc.BatchUploader.addProperties({errorMessageInputType: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageInputType()()});
            $wnd.isc.BatchUploader.addProperties({errorMessageUndeterminedDelimiter: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageUndeterminedDelimiter()()});
            $wnd.isc.BatchUploader.addProperties({errorMessageExcelFileDetected: messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageExcelFileDetected()()});
        }

        if($wnd.isc.ValidatorEditor) {
            $wnd.isc.ValidatorEditor.addProperties({applyWhenTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorEditor_applyWhenTitle()()});
            $wnd.isc.ValidatorEditor.addProperties({applyWhenPlaceholder: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorEditor_applyWhenPlaceholder()()});
            $wnd.isc.ValidatorEditor.addProperties({validatorTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorEditor_validatorTitle()()});
            $wnd.isc.ValidatorEditor.addProperties({errorMessageTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorEditor_errorMessageTitle()()});
            $wnd.isc.ValidatorEditor.addProperties({errorMessageHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorEditor_errorMessageHint()()});
            $wnd.isc.ValidatorEditor.addProperties({defaultEditorTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorEditor_defaultEditorTitle()()});
        }
        
        if($wnd.isc.LoginDialog) {
            $wnd.isc.LoginDialog.addClassProperties({LOGIN_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_LoginTitle()()});
            $wnd.isc.LoginDialog.addClassProperties({USERNAME_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_UserNameTitle()()});
            $wnd.isc.LoginDialog.addClassProperties({PASSWORD_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_PasswordTitle()()});
            $wnd.isc.LoginDialog.addClassProperties({LOGIN_BUTTON_TITLE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_LoginButtonTitle()()});
            $wnd.isc.LoginDialog.addClassProperties({LOGIN_ERROR_MESSAGE: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dialog_LoginErrorMessage()()});
        }

        if($wnd.isc.RPCManager) {
            $wnd.isc.RPCManager.addClassProperties({defaultPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_defaultPrompt()()});
            $wnd.isc.RPCManager.addClassProperties({timeoutErrorMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_timeoutErrorMessage()()});
            $wnd.isc.RPCManager.addClassProperties({removeDataPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_removeDataPrompt()()});
            $wnd.isc.RPCManager.addClassProperties({saveDataPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_saveDataPrompt()()});
            $wnd.isc.RPCManager.addClassProperties({validateDataPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_validateDataPrompt()()});
            $wnd.isc.RPCManager.addClassProperties({fetchDataPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::rpcManager_fetchDataPrompt()()});
        }

        if($wnd.isc.Operators){
            $wnd.isc.Operators.addClassProperties({equalsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_equalsTitle()()});
            $wnd.isc.Operators.addClassProperties({notEqualTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notEqualTitle()()});
            $wnd.isc.Operators.addClassProperties({iEqualsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iEqualsTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotEqualTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotEqualTitle()()});
            $wnd.isc.Operators.addClassProperties({greaterThanTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_greaterThanTitle()()});
            $wnd.isc.Operators.addClassProperties({lessThanTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_lessThanTitle()()});
            $wnd.isc.Operators.addClassProperties({greaterOrEqualTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_greaterOrEqualTitle()()});
            $wnd.isc.Operators.addClassProperties({lessOrEqualTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_lessOrEqualTitle()()});
            $wnd.isc.Operators.addClassProperties({betweenTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_betweenTitle()()});
            $wnd.isc.Operators.addClassProperties({iBetweenTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iBetweenTitle()()});
            $wnd.isc.Operators.addClassProperties({betweenInclusiveTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_betweenInclusiveTitle()()});
            $wnd.isc.Operators.addClassProperties({iBetweenInclusiveTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iBetweenInclusiveTitle()()});
            $wnd.isc.Operators.addClassProperties({iContainsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iContainsTitle()()});
            $wnd.isc.Operators.addClassProperties({iStartsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iStartsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({iEndsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iEndsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({containsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_containsTitle()()});
            $wnd.isc.Operators.addClassProperties({startsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_startsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({endsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_endsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotContainsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotContainsTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotStartsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotStartsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotEndsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotEndsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({notContainsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notContainsTitle()()});
            $wnd.isc.Operators.addClassProperties({notStartsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notStartsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({notEndsWithTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notEndsWithTitle()()});
            $wnd.isc.Operators.addClassProperties({isNullTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_isNullTitle()()});
            $wnd.isc.Operators.addClassProperties({notNullTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notNullTitle()()});
            $wnd.isc.Operators.addClassProperties({isBlankTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_isBlankTitle()()});
            $wnd.isc.Operators.addClassProperties({notBlankTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notBlankTitle()()});
            $wnd.isc.Operators.addClassProperties({regexpTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_regexpTitle()()});
            $wnd.isc.Operators.addClassProperties({iregexpTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iregexpTitle()()});
            $wnd.isc.Operators.addClassProperties({matchesPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_matchesPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({iMatchesPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iMatchesPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({inSetTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_inSetTitle()()});
            $wnd.isc.Operators.addClassProperties({notInSetTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notInSetTitle()()});
            $wnd.isc.Operators.addClassProperties({equalsFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_equalsFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({notEqualFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notEqualFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({greaterThanFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_greaterThanFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({lessThanFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_lessThanFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({greaterOrEqualFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_greaterOrEqualFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({lessOrEqualFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_lessOrEqualFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({containsFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_containsFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({startsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_startsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({endsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_endsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({andTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_andTitle()()});
            $wnd.isc.Operators.addClassProperties({notTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notTitle()()});
            $wnd.isc.Operators.addClassProperties({orTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_orTitle()()});

            $wnd.isc.Operators.addClassProperties({iEqualsFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iEqualsFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotEqualFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotEqualFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iContainsFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iContainsFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iStartsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iStartsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iEndsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iEndsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({notContainsFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notContainsFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({notStartsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notStartsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({notEndsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_notEndsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotContainsFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotContainsFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotStartsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotStartsWithFieldTitle()()});
            $wnd.isc.Operators.addClassProperties({iNotEndsWithFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iNotEndsWithFieldTitle()()});

            $wnd.isc.Operators.addClassProperties({containsPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_containsPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({iContainsPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iContainsPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({startsWithPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_startsWithPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({iStartsWithPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iStartsWithPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({endsWithPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_endsWithPatternTitle()()});
            $wnd.isc.Operators.addClassProperties({iEndsWithPatternTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_iEndsWithPatternTitle()()});
            
        }

        if($wnd.isc.GroupingMessages) {
            $wnd.isc.GroupingMessages.addClassProperties({upcomingBeforeTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingBeforeTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingTodayTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingTodayTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingTomorrowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingTomorrowTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingThisWeekTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingThisWeekTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingNextWeekTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingNextWeekTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingThisMonthTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingThisMonthTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingNextMonthTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingNextMonthTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingThisYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingThisYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingNextYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingNextYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({upcomingLaterTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_upcomingLaterTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byDayTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byDayTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byWeekTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byWeekTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byMonthTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byMonthTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byQuarterTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byQuarterTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byDayOfMonthTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byDayOfMonthTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byDateTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byDateTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byWeekAndYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byWeekAndYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byMonthAndYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byMonthAndYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byQuarterAndYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byQuarterAndYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byDayOfWeekAndYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byDayOfWeekAndYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byDayOfMonthAndYearTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byDayOfMonthAndYearTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byUpcomingTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byUpcomingTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byHoursTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byHoursTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byMinutesTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byMinutesTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({bySecondsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_bySecondsTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({byMillisecondsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_byMillisecondsTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({weekNumberTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_weekNumberTitle()()});
            $wnd.isc.GroupingMessages.addClassProperties({timezoneMinutesSuffix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_timezoneMinutesSuffix()()});
            $wnd.isc.GroupingMessages.addClassProperties({timezoneSecondsSuffix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::grouping_timezoneSecondsSuffix()()});
        }

        if($wnd.isc.Validator) {
            $wnd.isc.Validator.addClassProperties({notABoolean: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notABoolean()()});
            $wnd.isc.Validator.addClassProperties({notAnInteger: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notAnInteger()()});
            $wnd.isc.Validator.addClassProperties({notADecimal: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notADecimal()()});
            $wnd.isc.Validator.addClassProperties({notADate: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notADate()()});
            $wnd.isc.Validator.addClassProperties({notATime: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notATime()()});
            $wnd.isc.Validator.addClassProperties({notAnIdentifier: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notAnIdentifier()()});
            $wnd.isc.Validator.addClassProperties({notARegex: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notARegex()()});
            $wnd.isc.Validator.addClassProperties({notAColor: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notAColor()()});
            $wnd.isc.Validator.addClassProperties({mustBeLessThan: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeLessThan()()).replace(/(\$max)/g, '${max}')});
            $wnd.isc.Validator.addClassProperties({mustBeGreaterThan: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeGreaterThan()()).replace(/(\$min)/g, '${min}')});
            $wnd.isc.Validator.addClassProperties({mustBeLaterThan: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeLaterThan()()).replace(/(\$min)/g, '${min.toShortDate()}')});
            $wnd.isc.Validator.addClassProperties({mustBeEarlierThan: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeEarlierThan()()).replace(/(\$max)/g, '${max.toShortDate()}')});
            $wnd.isc.Validator.addClassProperties({mustBeShorterThan: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeShorterThan()()).replace(/(\$max)/g, '${max}')});
            $wnd.isc.Validator.addClassProperties({mustBeLongerThan: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeLongerThan()()).replace(/(\$min)/g, '${min}')});
            $wnd.isc.Validator.addClassProperties({mustBeExactLength: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeExactLength()()).replace(/(\$max)/g, '${max}')});
            $wnd.isc.Validator.addClassProperties({mustBeUnique: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeUnique()()});
            $wnd.isc.Validator.addClassProperties({requiredField: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_requiredField()()});
            $wnd.isc.Validator.addClassProperties({requiredFile: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_requiredFile()()});
            $wnd.isc.Validator.addClassProperties({notOneOf: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notOneOf()()});
            $wnd.isc.Validator.addClassProperties({notAFunction: messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notAFunction()()});

            $wnd.isc.Validator.addClassProperties({mustBeLaterThanTime: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeLaterThanTime()()).replace(/(\$min)/g, '${isc.Time.toShortTime(min)}')});
            $wnd.isc.Validator.addClassProperties({mustBeEarlierThanTime: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_mustBeEarlierThanTime()()).replace(/(\$max)/g, '${isc.Time.toShortTime(max)}')});
            $wnd.isc.Validator.addClassProperties({maxFileSizeExceeded: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_maxFileSizeExceeded()()).replace(/(\$uploadedFileSize)/g, '${isc.NumberUtil.toMiBString(uploadedFileSize, maxFileSize)} MiB').replace(/(\$maxFileSize)/g, '${isc.NumberUtil.toMiBString(maxFileSize, uploadedFileSize)} MiB').replace(/(\$uploadedFileName)/g, '${uploadedFileName}')});
        }

        if($wnd.isc.Time) {
            $wnd.isc.Time.addClassProperties({AMIndicator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::time_AMIndicator()()});
            $wnd.isc.Time.addClassProperties({PMIndicator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::time_PMIndicator()()});
            $wnd.isc.Time.addClassProperties({defaultTimeSeparator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::time_defaultTimeSeparator()()});
            $wnd.isc.Time.addClassProperties({defaultMillisecondSeparator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::time_defaultMillisecondSeparator()()});
        }
 
        if($wnd.isc.Window) {
            $wnd.isc.Window.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::window_title()()});
        }

        if($wnd.isc.DateChooser) {
            $wnd.isc.DateChooser.addProperties({todayButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_todayButtonTitle()()});
            $wnd.isc.DateChooser.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_cancelButtonTitle()()});
            $wnd.isc.DateChooser.addProperties({applyButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_applyButtonTitle()()});
            $wnd.isc.DateChooser.addProperties({firstDayOfWeek: Number(messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_firstDayOfWeek()())});
            $wnd.isc.DateChooser.addProperties({fiscalYearFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_fiscalYearFieldTitle()()});
            $wnd.isc.DateChooser.addProperties({weekFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_weekFieldTitle()()});
            $wnd.isc.DateChooser.addProperties({timeItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_timeItemTitle()()});
        }

        if($wnd.isc.DynamicForm) {
            $wnd.isc.DynamicForm.addProperties({formSubmitFailedWarning: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dynamicForm_formSubmitFailedWarning()()});
            $wnd.isc.DynamicForm.addProperties({originalValueMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dynamicForm_originalValueMessage()()});
        }

        if($wnd.isc.FormItem) {
            $wnd.isc.FormItem.addProperties({loadingDisplayValue: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formItem_loadingDisplayValue()()});
            $wnd.isc.FormItem.addProperties({nullOriginalValueText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formItem_nullOriginalValueText()()});
        }

        if($wnd.isc.SelectItem) {
            $wnd.isc.SelectItem.addProperties({otherTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::selectOtherItem_otherTitle()()});
            $wnd.isc.SelectItem.addProperties({selectOtherPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::selectOtherItem_selectOtherPrompt()() + ' ${item.getTitle()} :'});
        }

        if($wnd.isc.CheckboxItem) {
            $wnd.isc.CheckboxItem.addProperties({checkedDescription: messages.@com.smartgwt.client.i18n.SmartGwtMessages::checkboxItem_checkedDescription()()});
            $wnd.isc.CheckboxItem.addProperties({uncheckedDescription: messages.@com.smartgwt.client.i18n.SmartGwtMessages::checkboxItem_uncheckedDescription()()});
            $wnd.isc.CheckboxItem.addProperties({partialSelectedDescription: messages.@com.smartgwt.client.i18n.SmartGwtMessages::checkboxItem_partialSelectedDescription()()});
            $wnd.isc.CheckboxItem.addProperties({unsetDescription: messages.@com.smartgwt.client.i18n.SmartGwtMessages::checkboxItem_unsetDescription()()});
        }

        if($wnd.isc.DateItem) {
            $wnd.isc.DateItem.addProperties({invalidDateStringMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateItem_invalidDateStringMessage()()});
            $wnd.isc.DateItem.addProperties({pickerIconPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateItem_pickerIconPrompt()()});
            $wnd.isc.DateItem.changeDefaults("daySelectorDefaults", {prompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateItem_daySelectorPrompt()()});
            $wnd.isc.DateItem.changeDefaults("monthSelectorDefaults", {prompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateItem_monthSelectorPrompt()()});
            $wnd.isc.DateItem.changeDefaults("yearSelectorDefaults", {prompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateItem_yearSelectorPrompt()()});
            var selectorFormat = messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateItem_selectorFormat()();
            if(selectorFormat != null && selectorFormat != 'null') $wnd.isc.DateItem.addProperties({selectorFormat: selectorFormat});
        }

        if($wnd.isc.TimeItem) {
            $wnd.isc.TimeItem.addProperties({hourItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_hourItemTitle()()});
            $wnd.isc.TimeItem.addProperties({hourItemPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_hourItemPrompt()()});
            $wnd.isc.TimeItem.addProperties({minuteItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_minuteItemTitle()()});
            $wnd.isc.TimeItem.addProperties({minuteItemPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_minuteItemPrompt()()});
            $wnd.isc.TimeItem.addProperties({secondItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_secondItemTitle()()});
            $wnd.isc.TimeItem.addProperties({secondItemPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_secondItemPrompt()()});
            $wnd.isc.TimeItem.addProperties({millisecondItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_millisecondItemTitle()()});
            $wnd.isc.TimeItem.addProperties({millisecondItemPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_millisecondItemPrompt()()});
            $wnd.isc.TimeItem.addProperties({ampmItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_ampmItemTitle()()});
            $wnd.isc.TimeItem.addProperties({ampmItemPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_ampmItemPrompt()()});

            $wnd.isc.TimeItem.addProperties({invalidTimeStringMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::timeItem_invalidTimeStringMessage()()});
        }

        if($wnd.isc.ColorItem) {
            $wnd.isc.ColorItem.addProperties({pickerIconPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorItem_pickerIconPrompt()()});
        }

        if($wnd.isc.ColorPicker) {
            $wnd.isc.ColorPicker.addProperties({basicColorLabel: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_basicColorLabel()()});
            $wnd.isc.ColorPicker.addProperties({blueFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_blueFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({blueFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_blueFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_cancelButtonTitle()()});
            $wnd.isc.ColorPicker.addProperties({greenFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_greenFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({greenFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_greenFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({htmlFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_htmlFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({htmlFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_htmlFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({hueFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_hueFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({hueFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_hueFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({lessButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_lessButtonTitle()()});
            $wnd.isc.ColorPicker.addProperties({lumFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_lumFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({lumFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_lumFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({moreButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_moreButtonTitle()()});
            $wnd.isc.ColorPicker.addProperties({okButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_okButtonTitle()()});
            $wnd.isc.ColorPicker.addProperties({opacitySliderLabel: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_opacitySliderLabel()()});
            $wnd.isc.ColorPicker.addProperties({redFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_redFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({redFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_redFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({satFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_satFieldPrompt()()});
            $wnd.isc.ColorPicker.addProperties({satFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_satFieldTitle()()});
            $wnd.isc.ColorPicker.addProperties({selectTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_selectTitle()()});
            $wnd.isc.ColorPicker.addProperties({selectedColorLabel: messages.@com.smartgwt.client.i18n.SmartGwtMessages::colorPicker_selectedColorLabel()()});
        }

        if($wnd.isc.MultiComboBoxItem) {
            $wnd.isc.MultiComboBoxItem.addClassProperties({defaultHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiComboBoxItem_defaultHint()()});
        }

        if($wnd.isc.MultiFilePicker) {
            $wnd.isc.MultiFilePicker.addProperties({emptyMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFilePicker_emptyMessage()()});
            $wnd.isc.MultiFilePicker.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFilePicker_title()()});
        }

        if($wnd.isc.RichTextEditor) {
            $wnd.isc.RichTextEditor.addProperties({boldSelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_boldSelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({italicSelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_italicSelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({underlineSelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_underlineSelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({copySelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_copySelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({cutSelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_cutSelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({pasteSelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_pasteSelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({alignLeftPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_alignLeftPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({alignRightPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_alignRightPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({alignCenterPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_alignCenterPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({justifyPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_justifyPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({indentPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_indentPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({outdentPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_outdentPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({backgroundColorPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_backgroundColorPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({fontSelectorPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_fontSelectorPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({fontSizeSelectorPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_fontSizeSelectorPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({linkUrlTitle:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_linkUrlTitle()()});
            $wnd.isc.RichTextEditor.addProperties({strikethroughSelectionPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_strikethroughSelectionPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({orderedListPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_orderedListPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({unorderedListPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_unorderedListPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({listPropertiesPrompt:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_listPropertiesPrompt()()});
            $wnd.isc.RichTextEditor.addProperties({listPropertiesWarningText:messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_listPropertiesWarningText()()});
        }

        if($wnd.isc.Selection) {
            $wnd.isc.Selection.addProperties({selectionRangeNotLoadedMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::selection_selectionRangeNotLoadedMessage()()});
        }

        if($wnd.isc.ListPropertiesDialog) {
            $wnd.isc.ListPropertiesDialog.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listPropertiesDialog_title()()});
            $wnd.isc.ListPropertiesDialog.addProperties({applyButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listPropertiesDialog_applyButtonTitle()()});
            $wnd.isc.ListPropertiesDialog.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listPropertiesDialog_cancelButtonTitle()()});
        }
        if($wnd.isc.ListPropertiesPane) {
            $wnd.isc.ListPropertiesPane.addProperties({startNumberFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listPropertiesPane_startNumberFieldTitle()()});
        }

        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({emptyMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_emptyMessage()()});
            $wnd.isc.ListGrid.addProperties({removeFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_removeFieldTitle()()});
            $wnd.isc.ListGrid.addProperties({discardEditsSaveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_discardEditsSaveButtonTitle()()});
            $wnd.isc.ListGrid.addProperties({newRecordRowMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_newRecordRowMessage()()});
            $wnd.isc.ListGrid.addProperties({openRecordEditorContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_openRecordEditorContextMenuItemTitle()()});
            $wnd.isc.ListGrid.addProperties({dismissEmbeddedComponentContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_dismissEmbeddedComponentContextMenuItemTitle()()});
            $wnd.isc.ListGrid.addProperties({deleteRecordContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_deleteRecordContextMenuItemTitle()()});
            $wnd.isc.ListGrid.addProperties({recordEditorSaveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_recordEditorSaveButtonTitle()()});
            $wnd.isc.ListGrid.addProperties({recordEditorCancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_recordEditorCancelButtonTitle()()});
            $wnd.isc.ListGrid.addProperties({maxExpandedRecordsPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_maxExpandedRecordsPrompt()()).replace(/(\$count)/g, '${count}')});
            $wnd.isc.ListGrid.addProperties({freezeOnRightText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_freezeOnRightText()()});
            $wnd.isc.ListGrid.addProperties({freezeOnLeftText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_freezeOnLeftText()()});
            $wnd.isc.ListGrid.addProperties({sortFieldAscendingText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_sortFieldAscendingText()()});
            $wnd.isc.ListGrid.addProperties({sortFieldDescendingText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_sortFieldDescendingText()()});
            $wnd.isc.ListGrid.addProperties({clearSortFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_clearSortFieldText()()});
            $wnd.isc.ListGrid.addProperties({clearAllSortingText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_clearAllSortingText()()});
            $wnd.isc.ListGrid.addProperties({clearFilterText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_clearFilterText()()});
            $wnd.isc.ListGrid.addProperties({filterUsingText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_filterUsingText()()});
            $wnd.isc.ListGrid.addProperties({defaultFilterOperatorSuffix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_defaultFilterOperatorSuffix()()});
            $wnd.isc.ListGrid.addProperties({configureSortText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_configureSortText()()});
            $wnd.isc.ListGrid.addProperties({configureGroupingText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_configureGroupingText()()});
            $wnd.isc.ListGrid.addProperties({autoFitFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_autoFitFieldText()()});
            $wnd.isc.ListGrid.addProperties({autoFitAllText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_autoFitAllText()()});
            $wnd.isc.ListGrid.addProperties({fieldVisibilitySubmenuTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_fieldVisibilitySubmenuTitle()()});
            $wnd.isc.ListGrid.addProperties({freezeFieldText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_freezeFieldText()()).replace(/(\$title)/g, '${title}')});
            $wnd.isc.ListGrid.addProperties({unfreezeFieldText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_unfreezeFieldText()()).replace(/(\$title)/g, '${title}')});
            $wnd.isc.ListGrid.addProperties({groupByText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_groupByText()()).replace(/(\$title)/g, '${title}')});
            $wnd.isc.ListGrid.addProperties({ungroupText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_ungroupText()()});
            
            $wnd.isc.ListGrid.addProperties({hiliteReplaceValueFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_hiliteReplaceValueFieldTitle()()});
            $wnd.isc.ListGrid.addProperties({filterButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_filterButtonPrompt()()});
            $wnd.isc.ListGrid.addProperties({loadingMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_loadingMessage()()});
            $wnd.isc.ListGrid.addProperties({warnOnRemovalMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_warnOnRemovalMessage()()});
            $wnd.isc.ListGrid.addProperties({sorterButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_sorterButtonTitle()()});
            $wnd.isc.ListGrid.addProperties({expansionEditorSaveDialogPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_expansionEditorSaveDialogPrompt()()});
            $wnd.isc.ListGrid.addProperties({expansionEditorSaveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_expansionEditorSaveButtonTitle()()});
            $wnd.isc.ListGrid.addProperties({formulaBuilderSpanTitleSeparator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_formulaBuilderSpanTitleSeparator()()});
            $wnd.isc.ListGrid.addProperties({sortEditorSpanTitleSeparator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_sortEditorSpanTitleSeparator()()});
            $wnd.isc.ListGrid.addProperties({hiliteEditorSpanTitleSeparator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_hiliteEditorSpanTitleSeparator()()});
        }

        $wnd.isc.Canvas.addProperties({fieldEditorWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_fieldEditorWindowTitle()()).replace(/(\$builderType)/g, '${builderType}').replace(/(\$fieldTitle)/g, '${fieldTitle}')});
        $wnd.isc.Canvas.addProperties({addFormulaFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_addFormulaFieldText()()});
        $wnd.isc.Canvas.addProperties({editFormulaFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_editFormulaFieldText()()});
        $wnd.isc.Canvas.addProperties({addSummaryFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_addSummaryFieldText()()});
        $wnd.isc.Canvas.addProperties({editSummaryFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_editSummaryFieldText()()});
        $wnd.isc.Canvas.addProperties({requiredFieldMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_requiredFieldMessage()()});
        $wnd.isc.Canvas.addProperties({removeFormulaFieldText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_removeFormulaFieldText()()});
        $wnd.isc.Canvas.addProperties({duplicateDragMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_duplicateDragMessage()()});
        $wnd.isc.Canvas.addProperties({unknownErrorMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_unknownErrorMessage()()});
        $wnd.isc.Canvas.addProperties({noErrorDetailsMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_noErrorDetailsMessage()()});
        $wnd.isc.Canvas.addProperties({offlineMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_offlineMessage()()});
        $wnd.isc.Canvas.addProperties({editHilitesDialogTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_editHilitesDialogTitle()()});

        $wnd.isc.Canvas.addProperties({offlineSaveMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_offlineSaveMessage()()});
        $wnd.isc.Canvas.addProperties({emptyExportMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_emptyExportMessage()()});
        $wnd.isc.Canvas.addProperties({editHilitesText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_editHilitesText()()});

        if($wnd.isc.DataSource) {
            $wnd.isc.DataSource.addClassProperties({offlineMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataSource_offlineMessage()()});
            $wnd.isc.DataSource.addClassProperties({maxFileSizeExceededMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataSource_maxFileSizeExceededMessage()()).replace(/(\$uploadedFileName)/g, '${uploadedFileName}').replace(/(\$uploadedFileSize)/g, '${uploadedFileSize}').replace(/(\$maxFileSize)/g, '${maxFileSize}')});
            $wnd.isc.DataSource.addClassProperties({requiredCriterionMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataSource_requiredCriterionMessage()()).replace(/(\$requiredCriterion)/g, '${requiredCriterion}')});
        }

        if($wnd.isc.DetailViewer) {
            $wnd.isc.DetailViewer.addProperties({configureFieldsText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::detailViewer_configureFieldsText()()});
        }

        if($wnd.isc.FacetChart) {
            $wnd.isc.FacetChart.addClassProperties({regressionLinesContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_regressionLinesContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({hideRegressionLinesContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_hideRegressionLinesContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({linearRegressionLinesContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_linearRegressionLinesContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({polynomialRegressionLinesContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_polynomialRegressionLinesContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({polynomialDegreeRegressionLinesContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_polynomialDegreeRegressionLinesContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({polynomialDegreePrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_polynomialDegreePrompt()()});
            $wnd.isc.FacetChart.addClassProperties({invalidPolynomialDegreeMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_invalidPolynomialDegreeMessage()()});
            $wnd.isc.FacetChart.addClassProperties({proportionalContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_proportionalContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({fillContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_fillContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({fillFilledContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_fillFilledContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({fillUnfilledContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_fillUnfilledContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({fillAutoContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_fillAutoContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({stackContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_stackContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({stackStackedContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_stackStackedContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({stackUnstackedContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_stackUnstackedContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({stackAutoContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_stackAutoContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({swapFacetsContextMenuItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_swapFacetsContextMenuItemTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeAreaTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeAreaTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeColumnTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeColumnTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeBarTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeBarTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeLineTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeLineTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeRadarTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeRadarTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypePieTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypePieTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeDoughnutTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeDoughnutTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeScatterTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeScatterTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeBubbleTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeBubbleTitle()()});
            $wnd.isc.FacetChart.addClassProperties({chartTypeHistogramTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_chartTypeHistogramTitle()()});
       }
        
        if($wnd.isc.TileGrid) {
            $wnd.isc.TileGrid.addProperties({emptyMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::tileGrid_emptyMessage()()});
        }
        
        if($wnd.isc.TreeGrid) {
            $wnd.isc.TreeGrid.addProperties({parentAlreadyContainsChildMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::treeGrid_parentAlreadyContainsChildMessage()()});
            $wnd.isc.TreeGrid.addProperties({cantDragIntoSelfMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::treeGrid_cantDragIntoSelfMessage()()});
            $wnd.isc.TreeGrid.addProperties({cantDragIntoChildMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::treeGrid_cantDragIntoChildMessage()()});
            $wnd.isc.TreeGrid.addProperties({offlineNodeMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::treeGrid_offlineNodeMessage()()});
        }

        if($wnd.isc.ColumnTree) {
            $wnd.isc.ColumnTree.addProperties({backButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::columnTree_backButtonTitle()()});
        }
        
        if($wnd.isc.FormulaBuilder) {
            $wnd.isc.FormulaBuilder.addProperties({autoHideCheckBoxLabel: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_autoHideCheckBoxLabel()()});
            $wnd.isc.FormulaBuilder.addProperties({instructionsTextStart: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_instructionsTextStart()()).replace(/(\$builderType)/g, '${builderType}')});
            $wnd.isc.FormulaBuilder.addProperties({samplePrompt: '<nobr>' + messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_samplePromptForRecord()() + ' ${title}</nobr><br><nobr>' + messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_samplePromptOutput()() + ' ${output}</nobr>'});
            $wnd.isc.FormulaBuilder.addProperties({builderTypeText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_builderTypeText()()});
            $wnd.isc.FormulaBuilder.addProperties({invalidBuilderPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_invalidBuilderPrompt()()).replace(/(\$builderType)/g, '${builderType}').replace(/(\$errorText)/g, '${errorText}')});
            $wnd.isc.FormulaBuilder.addProperties({invalidBlankPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_invalidBlankPrompt()()).replace(/(\$builderType)/g, '${builderType}')});
            $wnd.isc.FormulaBuilder.addProperties({validBuilderPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_validBuilderPrompt()()).replace(/(\$builderType)/g, '${builderType}')});
            $wnd.isc.FormulaBuilder.addProperties({helpWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_helpWindowTitle()()).replace(/(\$builderType)/g, '${builderType}')});
            $wnd.isc.FormulaBuilder.addProperties({saveConfirmationPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_saveConfirmationPrompt()()).replace(/(\$builderType)/g, '${builderType}')});
            $wnd.isc.FormulaBuilder.addProperties({invalidGeneratedFunctionPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_invalidGeneratedFunctionPrompt()()).replace(/(\$builderType)/g, '${builderType}')});
            $wnd.isc.FormulaBuilder.addProperties({titleFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_titleFieldTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({defaultNewFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_defaultNewFieldTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({keyColumnTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_keyColumnTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({sourceFieldColumnTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_sourceFieldColumnTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_cancelButtonTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({saveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_saveButtonTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({sampleHeaderTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_sampleHeaderTitle()()});
            $wnd.isc.FormulaBuilder.addProperties({testButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_testButtonTitle()()});
            
            $wnd.isc.FormulaBuilder.addProperties({defaultErrorText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_defaultErrorText()()});
            $wnd.isc.FormulaBuilder.addProperties({warnDuplicateTitlesMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_warnDuplicateTitlesMessage()()});
            
            $wnd.isc.FormulaBuilder.addProperties({sourceDSColumnTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_sourceDSColumnTitle()()});
        }

        if($wnd.isc.SummaryBuilder) {
            $wnd.isc.SummaryBuilder.addProperties({autoHideCheckBoxLabel: messages.@com.smartgwt.client.i18n.SmartGwtMessages::summaryBuilder_autoHideCheckBoxLabel()()});
            $wnd.isc.SummaryBuilder.addProperties({helpTextIntro: messages.@com.smartgwt.client.i18n.SmartGwtMessages::summaryBuilder_helpTextIntro()()});
            $wnd.isc.SummaryBuilder.addProperties({builderTypeText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::summaryBuilder_builderTypeText()()});
        }

        if($wnd.isc.PrintWindow) {
            $wnd.isc.PrintWindow.addProperties({printButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::printWindow_printButtonTitle()()});
            $wnd.isc.PrintWindow.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::printWindow_title()()});
        }

        if($wnd.isc.PickTreeItem) { 
            $wnd.isc.PickTreeItem.addProperties({emptyMenuMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::pickTreeItem_emptyMenuMessage()()});
        }

        if($wnd.isc.MultiFileItem) { 
            $wnd.isc.MultiFileItem.addProperties({emptyMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_emptyMessage()()});

            $wnd.isc.MultiFileItem.addProperties({editButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_editButtonPrompt()()});
            $wnd.isc.MultiFileItem.addProperties({removeButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_removeButtonPrompt()()});
            $wnd.isc.MultiFileItem.addProperties({pickerUploadButtonInitialTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_pickerUploadButtonInitialTitle()()});
            $wnd.isc.MultiFileItem.addProperties({pickerUploadButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_pickerUploadButtonTitle()()});
            $wnd.isc.MultiFileItem.addProperties({pickerCancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_pickerCancelButtonTitle()()});
            $wnd.isc.MultiFileItem.addProperties({pickerAddAnotherFileButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_pickerAddAnotherFileButtonTitle()()});
            $wnd.isc.MultiFileItem.addProperties({pickerUploadProgressLabel: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiFileItem_pickerUploadProgressLabel()()).replace(/(\$fileName)/g, '${fileName}').replace(/(\$formattedFileSize)/g, '${formattedFileSize}')});
        }

        if($wnd.isc.MenuButton) { 
            $wnd.isc.MenuButton.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::menuButton_title()()});
        }

        if($wnd.isc.TreeMenuButton) { 
            $wnd.isc.TreeMenuButton.addProperties({unselectedTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::treeMenuButton_unselectedTitle()()});
        }

        if($wnd.isc.Calendar) {
            $wnd.isc.Calendar.addProperties({invalidDateMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_invalidDateMessage()()});
            $wnd.isc.Calendar.addProperties({addEventButtonHoverText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_addEventButtonHoverText()()});
            $wnd.isc.Calendar.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_cancelButtonTitle()()});
            $wnd.isc.Calendar.addProperties({datePickerHoverText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_datePickerHoverText()()});
            $wnd.isc.Calendar.addProperties({dayViewTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_dayViewTitle()()});
            $wnd.isc.Calendar.addProperties({detailsButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_detailsButtonTitle()()});
            $wnd.isc.Calendar.addProperties({eventNameFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventNameFieldTitle()()});
            $wnd.isc.Calendar.addProperties({eventDescriptionFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventDescriptionFieldTitle()()});
            $wnd.isc.Calendar.addProperties({eventStartDateFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventStartDateFieldTitle()()});
            $wnd.isc.Calendar.addProperties({eventEndDateFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventEndDateFieldTitle()()});
            $wnd.isc.Calendar.addProperties({eventLaneFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventLaneFieldTitle()()});
            $wnd.isc.Calendar.addProperties({monthViewTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_monthViewTitle()()});
            $wnd.isc.Calendar.addProperties({nextButtonHoverText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_nextButtonHoverText()()});
            $wnd.isc.Calendar.addProperties({previousButtonHoverText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_previousButtonHoverText()()});
            $wnd.isc.Calendar.addProperties({removeButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_removeButtonTitle()()});
            $wnd.isc.Calendar.addProperties({saveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_saveButtonTitle()()});
            $wnd.isc.Calendar.addProperties({timelineViewTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_timelineViewTitle()()});
            $wnd.isc.Calendar.addProperties({weekViewTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_weekViewTitle()()});
            $wnd.isc.Calendar.addProperties({weekPrefix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_weekPrefix()()});
            $wnd.isc.Calendar.addProperties({monthButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_monthButtonTitle()()).replace(/(\$monthName)/g, '${monthName}')});
            $wnd.isc.Calendar.addProperties({backButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_backButtonTitle()()});
            $wnd.isc.Calendar.addProperties({eventSublaneFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventSublaneFieldTitle()()});
            $wnd.isc.Calendar.addProperties({eventDurationFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventDurationFieldTitle()()});
            $wnd.isc.Calendar.addProperties({eventDurationUnitFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_eventDurationUnitFieldTitle()()});
            $wnd.isc.Calendar.addProperties({monthMoreEventsLinkTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_monthMoreEventsLinkTitle()()).replace(/(\$eventCount)/g, '${eventCount}')});
        }
        
        if($wnd.isc.FilterBuilder) {
            $wnd.isc.FilterBuilder.addProperties({addButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_addButtonPrompt()()});
            $wnd.isc.FilterBuilder.addProperties({rangeSeparator: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_rangeSeparator()()});
            $wnd.isc.FilterBuilder.addProperties({removeButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_removeButtonPrompt()()});
            $wnd.isc.FilterBuilder.addProperties({lastClausePrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_lastClausePrompt()()});
            $wnd.isc.FilterBuilder.addProperties({subClauseButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_subClauseButtonPrompt()()});
            $wnd.isc.FilterBuilder.addProperties({subClauseButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_subClauseButtonPrompt()()});
            $wnd.isc.FilterBuilder.addProperties({missingFieldPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_missingFieldPrompt()()});
            $wnd.isc.FilterBuilder.addProperties({matchAllTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_matchAllTitle()()});
            $wnd.isc.FilterBuilder.addProperties({matchNoneTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_matchNoneTitle()()});
            $wnd.isc.FilterBuilder.addProperties({matchAnyTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_matchAnyTitle()()});
            $wnd.isc.FilterBuilder.addProperties({subClauseButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_subClauseButtonTitle()()});

            $wnd.isc.FilterBuilder.addProperties({operatorPickerTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_operatorPickerTitle()()});
            $wnd.isc.FilterBuilder.addProperties({fieldPickerTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_fieldPickerTitle()()});
            $wnd.isc.FilterBuilder.addProperties({radioOperatorTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_radioOperatorTitle()()});
            $wnd.isc.FilterBuilder.addProperties({topOperatorTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_topOperatorTitle()()});
            $wnd.isc.FilterBuilder.addProperties({inlineAndTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::FilterBuilder_inlineAndTitle()()});
            $wnd.isc.FilterBuilder.addProperties({inlineOrTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::FilterBuilder_inlineOrTitle()()});
            $wnd.isc.FilterBuilder.addProperties({inlineAndNotTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::FilterBuilder_inlineAndNotTitle()()});
            $wnd.isc.FilterBuilder.addProperties({modeSwitcherAdvancedMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::FilterBuilder_modeSwitcherAdvancedMessage()()});
            $wnd.isc.FilterBuilder.addProperties({modeSwitcherSimpleMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::FilterBuilder_modeSwitcherSimpleMessage()()});
            $wnd.isc.FilterBuilder.addProperties({modeSwitcherFlattenWarningMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::FilterBuilder_modeSwitcherFlattenWarningMessage()()});
        }
        if($wnd.isc.FilterClause) {
            $wnd.isc.FilterClause.addProperties({removeButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_removeButtonPrompt()()});
            $wnd.isc.FilterClause.addProperties({fieldPickerTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_fieldPickerTitle()()});
            $wnd.isc.FilterClause.addProperties({valueItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_valueItemTitle()()});
            $wnd.isc.FilterClause.addProperties({operatorPickerTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_operatorPickerTitle()()});
            $wnd.isc.FilterClause.addProperties({valueSetHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_valueSetHint()()});
            $wnd.isc.FilterClause.addProperties({valueItemTextHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_valueItemTextHint()()});
        }

        if($wnd.isc.FieldPickerField) {
            $wnd.isc.FieldPickerField.addClassProperties({frozenTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerField_frozenTitle()()});
            $wnd.isc.FieldPickerField.addClassProperties({precisionTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerField_precisionTitle()()});
            $wnd.isc.FieldPickerField.addClassProperties({decimalPrecisionTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerField_decimalPrecisionTitle()()});
            $wnd.isc.FieldPickerField.addClassProperties({decimalPadTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerField_decimalPadTitle()()});
            $wnd.isc.FieldPickerField.addClassProperties({alignTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerField_alignTitle()()});
            $wnd.isc.FieldPickerField.addClassProperties({cellAlignTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerField_cellAlignTitle()()});
        }

        if($wnd.isc.FieldPicker) {
            $wnd.isc.FieldPicker.addProperties({hilitesText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_hilitesText()()});
            $wnd.isc.FieldPicker.addProperties({availableFieldsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_availableFieldsTitle()()});
            $wnd.isc.FieldPicker.addProperties({currentFieldsTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_currentFieldsTitle()()});
            $wnd.isc.FieldPicker.addProperties({confirmText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_confirmText()()});
            $wnd.isc.FieldPicker.addProperties({removeText: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_removeText()()});
            $wnd.isc.FieldPicker.addProperties({instructions: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_instructions()()});
            $wnd.isc.FieldPicker.addProperties({saveAndExitButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_saveAndExitButtonTitle()()});
            $wnd.isc.FieldPicker.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_cancelButtonTitle()()});
            $wnd.isc.FieldPicker.addProperties({addCustomFieldsButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_addCustomFieldsButtonTitle()()});
            $wnd.isc.FieldPicker.addProperties({availableTitleTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_availableTitleTitle()()});
            $wnd.isc.FieldPicker.addProperties({currentTitleTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_currentTitleTitle()()});
            $wnd.isc.FieldPicker.addProperties({sampleValueTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_sampleValueTitle()()});
            $wnd.isc.FieldPicker.addProperties({removeItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_removeItemTitle()()});
            $wnd.isc.FieldPicker.addProperties({emptyTitleHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPicker_emptyTitleHint()()});
        }

        if($wnd.isc.FieldPickerWindow) {
            $wnd.isc.FieldPickerWindow.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldPickerWindow_title()()});
        }
        
        if($wnd.isc.MultiSortDialog) {
            $wnd.isc.MultiSortPanel.addProperties({addLevelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_addLevelButtonTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({deleteLevelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_deleteLevelButtonTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({copyLevelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_copyLevelButtonTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({invalidListPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_invalidListPrompt()()).replace(/(\$title)/g, '${title}')});
            $wnd.isc.MultiSortPanel.addProperties({propertyFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_propertyFieldTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({directionFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_directionFieldTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({ascendingTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_ascendingTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({descendingTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_descendingTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({firstSortLevelTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_firstSortLevelTitle()()});
            $wnd.isc.MultiSortPanel.addProperties({otherSortLevelTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_otherSortLevelTitle()()});  

            $wnd.isc.MultiSortDialog.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_title()()});
            $wnd.isc.MultiSortDialog.addProperties({applyButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_applyButtonTitle()()});
            $wnd.isc.MultiSortDialog.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_cancelButtonTitle()()});
            $wnd.isc.MultiSortDialog.addProperties({levelUpButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_levelUpPrompt()()});
            $wnd.isc.MultiSortDialog.addProperties({levelDownButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiSortDialog_levelDownPrompt()()});
        }
        
        if($wnd.isc.MultiGroupDialog) {
            $wnd.isc.MultiGroupPanel.addProperties({addLevelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_addLevelButtonTitle()()});
            $wnd.isc.MultiGroupPanel.addProperties({deleteLevelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_deleteLevelButtonTitle()()});
            $wnd.isc.MultiGroupPanel.addProperties({copyLevelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_copyLevelButtonTitle()()});
            $wnd.isc.MultiGroupPanel.addProperties({invalidListPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_invalidListPrompt()()).replace(/(\$title)/g, '${title}')});
            $wnd.isc.MultiGroupPanel.addProperties({groupingFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_groupingFieldTitle()()});
            $wnd.isc.MultiGroupPanel.addProperties({propertyFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_propertyFieldTitle()()});
            $wnd.isc.MultiGroupPanel.addProperties({firstGroupLevelTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_firstGroupLevelTitle()()});
            $wnd.isc.MultiGroupPanel.addProperties({otherGroupLevelTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_otherGroupLevelTitle()()});  

            $wnd.isc.MultiGroupDialog.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_title()()});
            $wnd.isc.MultiGroupDialog.addProperties({applyButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_applyButtonTitle()()});
            $wnd.isc.MultiGroupDialog.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_cancelButtonTitle()()});
            $wnd.isc.MultiGroupDialog.addProperties({levelUpButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_levelUpPrompt()()});
            $wnd.isc.MultiGroupDialog.addProperties({levelDownButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiGroupDialog_levelDownPrompt()()});
        }

        if($wnd.isc.HiliteRule) {
            $wnd.isc.HiliteRule.addProperties({removeButtonPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteRule_removeButtonPrompt()()});
            $wnd.isc.HiliteRule.addProperties({colorFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteRule_colorFieldTitle()()});
            $wnd.isc.HiliteRule.addProperties({iconFieldTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteRule_iconFieldTitle()()});
            $wnd.isc.HiliteRule.addProperties({foregroundColorTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteRule_foregroundColorTitle()()});
            $wnd.isc.HiliteRule.addProperties({backgroundColorTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteRule_backgroundColorTitle()()});
        }
        if($wnd.isc.HiliteEditor) {
            $wnd.isc.HiliteEditor.addProperties({addAdvancedRuleButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteEditor_addAdvancedRuleButtonTitle()()});
            $wnd.isc.HiliteEditor.addProperties({saveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteEditor_saveButtonTitle()()});
            $wnd.isc.HiliteEditor.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteEditor_cancelButtonTitle()()});
            $wnd.isc.HiliteEditor.addProperties({availableFieldsColumnTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::hiliteEditor_availableFieldsColumnTitle()()});
        }
        if($wnd.isc.AdvancedHiliteEditor) {
            $wnd.isc.AdvancedHiliteEditor.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_title()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({saveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_saveButtonTitle()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_cancelButtonTitle()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({invalidHilitePrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_invalidHilitePrompt()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({filterGroupTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_filterGroupTitle()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({appearanceGroupTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_appearanceGroupTitle()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({targetFieldsItemTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_targetFieldsItemTitle()()});
            $wnd.isc.AdvancedHiliteEditor.addProperties({invalidCriteriaPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::advancedHiliteEditor_invalidCriteriaPrompt()()});
        }
        
        var shortDateFormat = messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDateFormat()();
        if (shortDateFormat != null) $wnd.isc.DateUtil.setShortDisplayFormat(shortDateFormat);
        var shortDatetimeFormat = messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDatetimeFormat()();
        if (shortDatetimeFormat != null) $wnd.isc.DateUtil.setShortDatetimeDisplayFormat(shortDatetimeFormat);
        var dateSeparator = messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dateSeparator()();
        if (dateSeparator != null) $wnd.isc.DateUtil.setDefaultDateSeparator(dateSeparator);
        
        var normalDateFormat = messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_normalDateFormat()();
        if (normalDateFormat != null) $wnd.isc.DateUtil.setNormalDateDisplayFormat(normalDateFormat);
        var normalDatetimeFormat = messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_normalDatetimeFormat()();
        if (normalDatetimeFormat != null) $wnd.isc.DateUtil.setNormalDatetimeDisplayFormat(normalDatetimeFormat);
        var inputFormat = messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_inputFormat()();
        if (inputFormat != null) $wnd.isc.DateUtil.setInputFormat(inputFormat);

        if($wnd.isc.DateRangeItem) {
            $wnd.isc.DateRangeItem.addProperties({fromTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeItem_fromTitle()()});
            $wnd.isc.DateRangeItem.addProperties({toTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeItem_toTitle()()});
            $wnd.isc.DateRangeItem.addProperties({invalidRangeErrorMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeItem_invalidRangeErrorMessage()()});

            $wnd.isc.DateRangeDialog.addProperties({headerTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeDialog_headerTitle()()});
            $wnd.isc.DateRangeDialog.addProperties({clearButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeDialog_clearButtonTitle()()});
            $wnd.isc.DateRangeDialog.addProperties({okButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeDialog_okButtonTitle()()});
            $wnd.isc.DateRangeDialog.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateRangeDialog_cancelButtonTitle()()});
            $wnd.isc.MiniDateRangeItem.addProperties({pickerIconPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::miniDateRangeItem_pickerIconPrompt()()});
            $wnd.isc.MiniDateRangeItem.addProperties({fromDateOnlyPrefix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::miniDateRangeItem_fromDateOnlyPrefix()()});
            $wnd.isc.MiniDateRangeItem.addProperties({toDateOnlyPrefix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::miniDateRangeItem_toDateOnlyPrefix()()});
            $wnd.isc.RelativeDateItem.addProperties({todayTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_todayTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({millisecondsAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_millisecondsAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({secondsAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_secondsAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({minutesAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_minutesAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({hoursAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_hoursAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({daysAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_daysAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({weeksAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_weeksAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({monthsAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_monthsAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({quartersAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_quartersAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({yearsAgoTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_yearsAgoTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({millisecondsFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_millisecondsFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({secondsFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_secondsFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({minutesFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_minutesFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({hoursFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_hoursFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({daysFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_daysFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({weeksFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_weeksFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({monthsFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_monthsFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({quartersFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_quartersFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({yearsFromNowTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_yearsFromNowTitle()()});
            $wnd.isc.RelativeDateItem.addProperties({pickerIconPrompt: messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_pickerIconPrompt()()});
            $wnd.isc.RelativeDateItem.addProperties({presetOptions: {"$today" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_today()(), "$yesterday" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_yesterday()(), "$tomorrow" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_tomorrow()(), "$weekAgo" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_minus_1w()(), "$weekFromNow" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_plus_1w()(), "$monthAgo" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_minus_1m()(), "$monthFromNow" : messages.@com.smartgwt.client.i18n.SmartGwtMessages::relativeDateItem_presetOptions_plus_1m()()}});
        }
        if($wnd.isc.PickList) {
            $wnd.isc.PickList.addInterfaceProperties({emptyPickListMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::pickList_emptyPickListMessage()()});
        }
        if($wnd.isc.SelectItem) {
            $wnd.isc.SelectItem.addProperties({emptyPickListMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::selectItem_emptyPickListMessage()()});
            $wnd.isc.SelectItem.addProperties({pickerExitButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::selectItem_pickerExitButtonTitle()()});
            $wnd.isc.SelectItem.addProperties({pickerClearButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::selectItem_pickerClearButtonTitle()()});
        }
        if($wnd.isc.ComboBoxItem) {
            $wnd.isc.ComboBoxItem.addProperties({emptyPickListMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_emptyPickListMessage()()});
            $wnd.isc.ComboBoxItem.addProperties({pickerSearchFieldHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_pickerSearchFieldHint()()});
            $wnd.isc.ComboBoxItem.addProperties({pickerExitButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_pickerExitButtonTitle()()});
            $wnd.isc.ComboBoxItem.addProperties({pickerSaveButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_pickerSaveButtonTitle()()});
            $wnd.isc.ComboBoxItem.addProperties({pickerClearButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_pickerClearButtonTitle()()});
            $wnd.isc.ComboBoxItem.addProperties({searchStringTooShortMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_searchStringTooShortMessage()()});
            $wnd.isc.ComboBoxItem.addProperties({pickerSearchOrNewValueFieldHint: messages.@com.smartgwt.client.i18n.SmartGwtMessages::comboBoxItem_pickerSearchOrNewValueFieldHint()()});
        }
        if($wnd.isc.PickListMenu) {
            $wnd.isc.PickListMenu.addProperties({emptyMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::pickListMenu_emptyMessage()()});
        }
        if($wnd.isc.Portlet) {
            $wnd.isc.Portlet.addProperties({closeConfirmationMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::portlet_closeConfirmationMessage()()});
        }
        
        if($wnd.isc.Menu) {
            $wnd.isc.Menu.addProperties({emptyMessage: messages.@com.smartgwt.client.i18n.SmartGwtMessages::menu_emptyMessage()()});
            $wnd.isc.Menu.addProperties({cancelButtonTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::menu_cancelButtonTitle()()});
        }
        if($wnd.isc.IMenuButton) {
            $wnd.isc.IMenuButton.addProperties({title: messages.@com.smartgwt.client.i18n.SmartGwtMessages::iMenuButton_title()()});   
        }
        
        if($wnd.isc.PresetCriteriaItem) {
            $wnd.isc.PresetCriteriaItem.addProperties({customOptionTitle: messages.@com.smartgwt.client.i18n.SmartGwtMessages::presetCriteriaItem_customOptionTitle()()});   
        }

        if ($wnd.isc.NumberUtil) {
            $wnd.isc.NumberUtil.addClassProperties({ currencySymbol: messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberUtil_currencySymbol()() });
            $wnd.isc.NumberUtil.addClassProperties({ groupingSymbol: messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberUtil_groupingSymbol()() });
            $wnd.isc.NumberUtil.addClassProperties({ decimalSymbol: messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberUtil_decimalSymbol()() });
            $wnd.isc.NumberUtil.addClassProperties({ negativeSymbol: messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberUtil_negativeSymbol()() });
        }

        if($wnd.isc.TabSet) {
            $wnd.isc.TabSet.addProperties({ariaCloseableSuffix: messages.@com.smartgwt.client.i18n.SmartGwtMessages::tabSet_ariaCloseableSuffix()()});
        }

        if($wnd.isc.SplitPane) {
            $wnd.isc.SplitPane.addProperties({listPaneTitleTemplate: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::splitPane_listPaneTitleTemplate()()).replace(/(\$titleField)/g, '${titleField}')});
            $wnd.isc.SplitPane.addProperties({detailPaneTitleTemplate: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::splitPane_detailPaneTitleTemplate()()).replace(/(\$titleField)/g, '${titleField}')});
        }



        //  Generated on Mon May 24 00:54:06 2021

        if($wnd.isc.DeploymentEditor) {
            $wnd.isc.DeploymentEditor.addProperties({deploymentNameTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_deploymentNameTitle()())});
        }


        //  Generated on Mon May 24 01:48:08 2021

        if($wnd.isc.DeploymentEditor) {
            $wnd.isc.DeploymentEditor.addProperties({deploymentTypeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_deploymentTypeTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({deploymentURLTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_deploymentURLTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({newDeploymentSuccess: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_newDeploymentSuccess()()).replace(/(\$type)/g, '${type}').replace(/(\$name)/g, '${name}')});
            $wnd.isc.DeploymentEditor.addProperties({redeploymentSuccess: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_redeploymentSuccess()()).replace(/(\$name)/g, '${name}').replace(/(\$type)/g, '${type}')});
            $wnd.isc.DeploymentEditor.addProperties({dsImportSelectTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_dsImportSelectTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({dsImportSelectInfo: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_dsImportSelectInfo()())});
            $wnd.isc.DeploymentEditor.addProperties({authenticationTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_authenticationTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({sampleUsersTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_sampleUsersTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({sampleUsersInfo: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_sampleUsersInfo()())});
            $wnd.isc.DeploymentEditor.addProperties({passwordTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_passwordTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({passwordConfirmTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_passwordConfirmTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({authShareUsersTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_authShareUsersTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({authShareUsersHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_authShareUsersHint()())});
            $wnd.isc.DeploymentEditor.addProperties({authDeploymentTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_authDeploymentTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({authDeploymentHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_authDeploymentHint()())});
            $wnd.isc.DeploymentEditor.addProperties({applyButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_applyButtonTitle()())});
            $wnd.isc.DeploymentEditor.addProperties({cancelButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentEditor_cancelButtonTitle()())});
        }
        if($wnd.isc.DeploymentManagerLauncher) {
            $wnd.isc.DeploymentManagerLauncher.addProperties({manageButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentManagerLauncher_manageButtonTitle()())});
            $wnd.isc.DeploymentManagerLauncher.addProperties({cancelButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentManagerLauncher_cancelButtonTitle()())});
        }


        //  Generated on Mon May 24 05:18:46 2021

        if($wnd.isc.SampleDataDSWizard) {
            $wnd.isc.SampleDataDSWizard.addProperties({formatHelpText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::sampleDataDSWizard_formatHelpText()())});
        }


        //  Generated on Mon May 24 05:20:26 2021

        if($wnd.isc.WorkflowEditor) {
            $wnd.isc.WorkflowEditor.addProperties({addElementTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_addElementTitle()())});
            $wnd.isc.WorkflowEditor.addProperties({addElementHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_addElementHint()())});
            $wnd.isc.WorkflowEditor.addProperties({canceledLinkPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_canceledLinkPrompt()())});
            $wnd.isc.WorkflowEditor.addProperties({failedLinkPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_failedLinkPrompt()())});
            $wnd.isc.WorkflowEditor.addProperties({continuationLinkPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_continuationLinkPrompt()())});
            $wnd.isc.WorkflowEditor.addProperties({startTaskLinkPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_startTaskLinkPrompt()())});
            $wnd.isc.WorkflowEditor.addProperties({unreferencedTaskLinkPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_unreferencedTaskLinkPrompt()())});
            $wnd.isc.WorkflowEditor.addProperties({taskScopeLastTaskOutputNodeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_taskScopeLastTaskOutputNodeTitle()()).replace(/(\$description)/g, '${description}')});
            $wnd.isc.WorkflowEditor.addProperties({warnOnRemovalMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_warnOnRemovalMessage()())});
            $wnd.isc.WorkflowEditor.addProperties({editIconPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowEditor_editIconPrompt()())});
        }
        if($wnd.isc.WorkflowValuesBindingEditor) {
            $wnd.isc.WorkflowValuesBindingEditor.addProperties({overwriteBindingsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowValuesBindingEditor_overwriteBindingsMessage()())});
            $wnd.isc.WorkflowValuesBindingEditor.addProperties({fixedValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowValuesBindingEditor_fixedValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.WorkflowValuesBindingEditor.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowValuesBindingEditor_dynamicValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.WorkflowValuesBindingEditor.addProperties({bindingFixedValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowValuesBindingEditor_bindingFixedValuePrompt()())});
            $wnd.isc.WorkflowValuesBindingEditor.addProperties({bindingDynamicValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowValuesBindingEditor_bindingDynamicValuePrompt()())});
        }
        if($wnd.isc.WorkflowDynamicValueItem) {
            $wnd.isc.WorkflowDynamicValueItem.addProperties({dynamicValuePrefix: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowDynamicValueItem_dynamicValuePrefix()())});
            $wnd.isc.WorkflowDynamicValueItem.addProperties({dynamicValueButtonPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowDynamicValueItem_dynamicValueButtonPrompt()())});
            $wnd.isc.WorkflowDynamicValueItem.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowDynamicValueItem_dynamicValueWindowTitle()()).replace(/(\$fieldTitle)/g, '${fieldTitle}')});
        }


        //  Generated on Mon May 24 05:30:31 2021

        if($wnd.isc.RuleEditor) {
            $wnd.isc.RuleEditor.addProperties({nameItemTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_nameItemTitle()())});
            $wnd.isc.RuleEditor.addProperties({descriptionItemTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_descriptionItemTitle()())});
            $wnd.isc.RuleEditor.addProperties({triggerEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_triggerEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({fieldPickerTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_fieldPickerTitle()())});
            $wnd.isc.RuleEditor.addProperties({applyWhenTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_applyWhenTitle()())});
            $wnd.isc.RuleEditor.addProperties({applyWhenPlaceholder: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_applyWhenPlaceholder()())});
            $wnd.isc.RuleEditor.addProperties({validatorTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_validatorTitle()())});
            $wnd.isc.RuleEditor.addProperties({errorMessageTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_errorMessageTitle()())});
            $wnd.isc.RuleEditor.addProperties({invalidFieldSelectionWarning: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_invalidFieldSelectionWarning()())});
            $wnd.isc.RuleEditor.addProperties({editStartEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_editStartEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({editStartAndChangedEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_editStartAndChangedEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({editorEnterEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_editorEnterEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({editorExitEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_editorExitEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({changedEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_changedEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({submitEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_submitEventTitle()())});
            $wnd.isc.RuleEditor.addProperties({manualEventTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::ruleEditor_manualEventTitle()())});
        }


        //  Generated on Mon May 24 05:32:32 2021

        if($wnd.isc.DeploymentManager) {
            $wnd.isc.DeploymentManager.addProperties({usersTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentManager_usersTitle()())});
            $wnd.isc.DeploymentManager.addProperties({dataTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentManager_dataTitle()())});
            $wnd.isc.DeploymentManager.addProperties({usageTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentManager_usageTitle()())});
        }
        if($wnd.isc.DeploymentDSNavigator) {
            $wnd.isc.DeploymentDSNavigator.addProperties({dsEnumerationSectionTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentDSNavigator_dsEnumerationSectionTitle()())});
            $wnd.isc.DeploymentDSNavigator.addProperties({dsContentSectionTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentDSNavigator_dsContentSectionTitle()()).replace(/(\$dsId)/g, '${dsId}')});
            $wnd.isc.DeploymentDSNavigator.addProperties({dsContentAuditedSectionTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentDSNavigator_dsContentAuditedSectionTitle()()).replace(/(\$dsId)/g, '${dsId}')});
            $wnd.isc.DeploymentDSNavigator.addProperties({dsContentRecordAuditSectionTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentDSNavigator_dsContentRecordAuditSectionTitle()()).replace(/(\$pkCrit)/g, '${pkCrit}').replace(/(\$dsId)/g, '${dsId}')});
        }
        if($wnd.isc.DeploymentUsageViewer) {
            $wnd.isc.DeploymentUsageViewer.addProperties({sessionsOverviewGridTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentUsageViewer_sessionsOverviewGridTitle()())});
            $wnd.isc.DeploymentUsageViewer.addProperties({sessionAuditPickerTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentUsageViewer_sessionAuditPickerTitle()()).replace(/(\$userId)/g, '${userId}')});
        }
        if($wnd.isc.DeploymentSessionAuditGrid) {
            $wnd.isc.DeploymentSessionAuditGrid.addProperties({relatedDataFieldPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentSessionAuditGrid_relatedDataFieldPrompt()())});
            $wnd.isc.DeploymentSessionAuditGrid.addProperties({relatedDataMenuInfoText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentSessionAuditGrid_relatedDataMenuInfoText()())});
            $wnd.isc.DeploymentSessionAuditGrid.addProperties({relatedDataMenuRecordText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentSessionAuditGrid_relatedDataMenuRecordText()())});
            $wnd.isc.DeploymentSessionAuditGrid.addProperties({relatedDataMenuDataSourceText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::deploymentSessionAuditGrid_relatedDataMenuDataSourceText()()).replace(/(\$dsId)/g, '${dsId}')});
        }


        //  Generated on Mon May 24 05:35:28 2021

        if($wnd.isc.ParsedDataDSEditor) {
            $wnd.isc.ParsedDataDSEditor.addProperties({instructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::parsedDataDSEditor_instructions()())});
        }
        if($wnd.isc.ValidatorsEditor) {
            $wnd.isc.ValidatorsEditor.addProperties({addButtonDisabledHoverText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validatorsEditor_addButtonDisabledHoverText()())});
        }
        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({showFilterEditorTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_showFilterEditorTitle()())});
            $wnd.isc.ListGrid.addProperties({hideFilterEditorTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_hideFilterEditorTitle()())});
        }
        if($wnd.isc.ProcessElementEditor) {
            $wnd.isc.ProcessElementEditor.addProperties({taskScopeLastTaskOutputNodeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::processElementEditor_taskScopeLastTaskOutputNodeTitle()()).replace(/(\$description)/g, '${description}')});
        }
        if($wnd.isc.ServiceTaskEditor) {
            $wnd.isc.ServiceTaskEditor.addProperties({editorTitleFixedOperationType: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_editorTitleFixedOperationType()()).replace(/(\$operationType)/g, '${operationType}')});
            $wnd.isc.ServiceTaskEditor.addProperties({addInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_addInstructions()())});
            $wnd.isc.ServiceTaskEditor.addProperties({removeInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_removeInstructions()())});
            $wnd.isc.ServiceTaskEditor.addProperties({fetchInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_fetchInstructions()())});
            $wnd.isc.ServiceTaskEditor.addProperties({exportInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_exportInstructions()())});
            $wnd.isc.ServiceTaskEditor.addProperties({overwriteBindingsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_overwriteBindingsMessage()())});
            $wnd.isc.ServiceTaskEditor.addProperties({missingPrimaryKeyMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_missingPrimaryKeyMessage()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.ServiceTaskEditor.addProperties({missingIdSourceMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_missingIdSourceMessage()())});
            $wnd.isc.ServiceTaskEditor.addProperties({fixedValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_fixedValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.ServiceTaskEditor.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_dynamicValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.ServiceTaskEditor.addProperties({bindingFixedValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_bindingFixedValuePrompt()())});
            $wnd.isc.ServiceTaskEditor.addProperties({bindingDynamicValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::serviceTaskEditor_bindingDynamicValuePrompt()())});
        }
        if($wnd.isc.DecisionTaskEditor) {
            $wnd.isc.DecisionTaskEditor.addProperties({instructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::decisionTaskEditor_instructions()())});
            $wnd.isc.DecisionTaskEditor.addProperties({missingCriteriaMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::decisionTaskEditor_missingCriteriaMessage()())});
        }
        if($wnd.isc.MultiDecisionTaskEditor) {
            $wnd.isc.MultiDecisionTaskEditor.addProperties({instructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::multiDecisionTaskEditor_instructions()())});
        }
        if($wnd.isc.GridEditRecordTaskEditor) {
            $wnd.isc.GridEditRecordTaskEditor.addProperties({criteriaInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_criteriaInstructions()())});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({valuesInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_valuesInstructions()())});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({overwriteBindingsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_overwriteBindingsMessage()())});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({fixedValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_fixedValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_dynamicValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({bindingFixedValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_bindingFixedValuePrompt()())});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({bindingDynamicValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_bindingDynamicValuePrompt()())});
            $wnd.isc.GridEditRecordTaskEditor.addProperties({missingCriteriaMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridEditRecordTaskEditor_missingCriteriaMessage()())});
        }
        if($wnd.isc.FormEditNewRecordTaskEditor) {
            $wnd.isc.FormEditNewRecordTaskEditor.addProperties({valuesInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formEditNewRecordTaskEditor_valuesInstructions()())});
            $wnd.isc.FormEditNewRecordTaskEditor.addProperties({overwriteBindingsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formEditNewRecordTaskEditor_overwriteBindingsMessage()())});
            $wnd.isc.FormEditNewRecordTaskEditor.addProperties({fixedValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formEditNewRecordTaskEditor_fixedValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.FormEditNewRecordTaskEditor.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formEditNewRecordTaskEditor_dynamicValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.FormEditNewRecordTaskEditor.addProperties({bindingFixedValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formEditNewRecordTaskEditor_bindingFixedValuePrompt()())});
            $wnd.isc.FormEditNewRecordTaskEditor.addProperties({bindingDynamicValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formEditNewRecordTaskEditor_bindingDynamicValuePrompt()())});
        }
        if($wnd.isc.FormSetValuesTaskEditor) {
            $wnd.isc.FormSetValuesTaskEditor.addProperties({valuesInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSetValuesTaskEditor_valuesInstructions()())});
            $wnd.isc.FormSetValuesTaskEditor.addProperties({overwriteBindingsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSetValuesTaskEditor_overwriteBindingsMessage()())});
            $wnd.isc.FormSetValuesTaskEditor.addProperties({fixedValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSetValuesTaskEditor_fixedValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.FormSetValuesTaskEditor.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSetValuesTaskEditor_dynamicValueWindowTitle()()).replace(/(\$fieldName)/g, '${fieldName}')});
            $wnd.isc.FormSetValuesTaskEditor.addProperties({bindingFixedValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSetValuesTaskEditor_bindingFixedValuePrompt()())});
            $wnd.isc.FormSetValuesTaskEditor.addProperties({bindingDynamicValuePrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSetValuesTaskEditor_bindingDynamicValuePrompt()())});
        }
        if($wnd.isc.DecisionBranchEditor) {
            $wnd.isc.DecisionBranchEditor.addProperties({criteriaNotComplete: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::decisionBranchEditor_criteriaNotComplete()())});
            $wnd.isc.DecisionBranchEditor.addProperties({criteriaMissingMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::decisionBranchEditor_criteriaMissingMessage()())});
        }
        if($wnd.isc.DsBindingEditor) {
            $wnd.isc.DsBindingEditor.addProperties({availableFieldsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_availableFieldsTitle()())});
            $wnd.isc.DsBindingEditor.addProperties({currentFieldsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_currentFieldsTitle()())});
            $wnd.isc.DsBindingEditor.addProperties({availableTitleTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_availableTitleTitle()())});
            $wnd.isc.DsBindingEditor.addProperties({currentTitleTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_currentTitleTitle()())});
            $wnd.isc.DsBindingEditor.addProperties({saveAndExitButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_saveAndExitButtonTitle()())});
            $wnd.isc.DsBindingEditor.addProperties({cancelButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_cancelButtonTitle()())});
            $wnd.isc.DsBindingEditor.addProperties({removeItemTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditor_removeItemTitle()())});
        }
        if($wnd.isc.DsBindingEditorWindow) {
            $wnd.isc.DsBindingEditorWindow.addProperties({title: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dsBindingEditorWindow_title()()).replace(/(\$componentInfo)/g, '${componentInfo}').replace(/(\$dsId)/g, '${dsId}')});
        }
        if($wnd.isc.DynamicPropertyEditorItem) {
            $wnd.isc.DynamicPropertyEditorItem.addProperties({cancelButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dynamicPropertyEditorItem_cancelButtonTitle()())});
            $wnd.isc.DynamicPropertyEditorItem.addProperties({saveButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dynamicPropertyEditorItem_saveButtonTitle()())});
        }


        //  Generated on Mon May 24 06:02:38 2021

        if($wnd.isc.DatetimeFormatEditor) {
            $wnd.isc.DatetimeFormatEditor.addClassProperties({sampleValueTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_sampleValueTitle()())});
            $wnd.isc.DatetimeFormatEditor.addClassProperties({sampleOutputTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_sampleOutputTitle()())});
            $wnd.isc.DatetimeFormatEditor.addClassProperties({formatCodeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_formatCodeTitle()())});
            $wnd.isc.DatetimeFormatEditor.addClassProperties({generalFormatErrorMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_generalFormatErrorMessage()())});
            $wnd.isc.DatetimeFormatEditor.addClassProperties({formatLooksInvalidConfirmationMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_formatLooksInvalidConfirmationMessage()())});
        }
        if($wnd.isc.NumberFormatEditor) {
            $wnd.isc.NumberFormatEditor.addClassProperties({sampleValueTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_sampleValueTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({sampleOutputTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_sampleOutputTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({decimalPlacesTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_decimalPlacesTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({showSeparatorsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_showSeparatorsTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({negativeValuesTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_negativeValuesTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({currencySymbolTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_currencySymbolTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({currencySymbolLastTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_currencySymbolLastTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({percentageTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_percentageTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({formatCodeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_formatCodeTitle()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({formatCodeHover: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_formatCodeHover()())});
        }


        //  Generated on Mon May 24 06:05:58 2021

        if($wnd.isc.BaseDatetimeFormats) {
            $wnd.isc.BaseDatetimeFormats.addClassProperties({usShortDateTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_usShortDateTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({usShortDatetimeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_usShortDatetimeTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({europeShortDateTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_europeShortDateTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({europeShortDatetimeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_europeShortDatetimeTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({asiaDateTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_asiaDateTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({asiaDatetimeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_asiaDatetimeTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({hoursMinutesTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_hoursMinutesTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({hoursMinutesSecondsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_hoursMinutesSecondsTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({fullTimeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_fullTimeTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({dateShortWordsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_dateShortWordsTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({dateLongWordsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_dateLongWordsTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({fullDatetimeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_fullDatetimeTitle()())});
            $wnd.isc.BaseDatetimeFormats.addClassProperties({customTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseDatetimeFormats_customTitle()())});
        }
        if($wnd.isc.BaseNumberFormats) {
            $wnd.isc.BaseNumberFormats.addClassProperties({wholeNumberTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseNumberFormats_wholeNumberTitle()())});
            $wnd.isc.BaseNumberFormats.addClassProperties({decimalNumberTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseNumberFormats_decimalNumberTitle()())});
            $wnd.isc.BaseNumberFormats.addClassProperties({currencyTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseNumberFormats_currencyTitle()())});
            $wnd.isc.BaseNumberFormats.addClassProperties({percentageTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseNumberFormats_percentageTitle()())});
            $wnd.isc.BaseNumberFormats.addClassProperties({customTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::baseNumberFormats_customTitle()())});
        }


        //  Generated on Mon May 24 06:31:07 2021

        if($wnd.isc.ImagePicker) {
            $wnd.isc.ImagePicker.addProperties({actionIconsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imagePicker_actionIconsTitle()())});
            $wnd.isc.ImagePicker.addProperties({headerIconsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imagePicker_headerIconsTitle()())});
            $wnd.isc.ImagePicker.addProperties({customImagesTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imagePicker_customImagesTitle()())});
            $wnd.isc.ImagePicker.addProperties({tipText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imagePicker_tipText()())});
            $wnd.isc.ImagePicker.addProperties({okButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imagePicker_okButtonTitle()())});
            $wnd.isc.ImagePicker.addProperties({cancelButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imagePicker_cancelButtonTitle()())});
        }


        //  Generated on Mon May 24 06:37:03 2021

        if($wnd.isc.TileGrid) {
        }
        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({advancedFilteringText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_advancedFilteringText()())});
            $wnd.isc.ListGrid.addProperties({filterWindowInstructions: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_filterWindowInstructions()())});
            $wnd.isc.ListGrid.addProperties({fieldCriteriaText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_fieldCriteriaText()())});
            $wnd.isc.ListGrid.addProperties({gridAdditionalCriteriaText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_gridAdditionalCriteriaText()())});
        }
        if($wnd.isc.GridRenderer) {
            $wnd.isc.GridRenderer.addProperties({emptyCellValue: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridRenderer_emptyCellValue()())});
        }


        //  Generated on Mon May 24 06:49:00 2021

        if($wnd.isc.FilterBuilder) {
            $wnd.isc.FilterBuilder.addProperties({dynamicValuePrefix: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_dynamicValuePrefix()())});
            $wnd.isc.FilterBuilder.addProperties({dynamicValueButtonPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_dynamicValueButtonPrompt()())});
            $wnd.isc.FilterBuilder.addProperties({dynamicValueWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_dynamicValueWindowTitle()()).replace(/(\$fieldTitle)/g, '${fieldTitle}')});
            $wnd.isc.FilterBuilder.addProperties({dynamicValueClearValueText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterBuilder_dynamicValueClearValueText()())});
        }


        //  Generated on Mon May 24 07:10:33 2021

        if($wnd.isc.RPCManager) {
            $wnd.isc.RPCManager.addClassProperties({reloginCommFailureMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::rPCManager_reloginCommFailureMessage()())});
        }
        if($wnd.isc.DSRecordAuditPreview) {
            $wnd.isc.DSRecordAuditPreview.addProperties({recordAuditHeaderTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dSRecordAuditPreview_recordAuditHeaderTitle()()).replace(/(\$dsId)/g, '${dsId}')});
            $wnd.isc.DSRecordAuditPreview.addProperties({recordAuditInfoTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dSRecordAuditPreview_recordAuditInfoTitle()())});
        }
        if($wnd.isc.SampleDataDSWizard) {
            $wnd.isc.SampleDataDSWizard.addProperties({importFileTooLargeMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::sampleDataDSWizard_importFileTooLargeMessage()())});
        }
        if($wnd.isc.XmlCodeDSWizard) {
            $wnd.isc.XmlCodeDSWizard.addProperties({importFileTooLargeMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::xmlCodeDSWizard_importFileTooLargeMessage()())});
        }
        if($wnd.isc.FacetChart) {
            $wnd.isc.FacetChart.addProperties({proportionalAxisLabel: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::facetChart_proportionalAxisLabel()())});
        }
        if($wnd.isc.DynamicValuePicker) {
            $wnd.isc.DynamicValuePicker.addProperties({clearValueText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dynamicValuePicker_clearValueText()())});
        }
        if($wnd.isc.ImageChooserItem) {
            $wnd.isc.ImageChooserItem.addProperties({pickerTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::imageChooserItem_pickerTitle()())});
        }
        if($wnd.isc.StatefulImageChooser) {
            $wnd.isc.StatefulImageChooser.addProperties({instructionText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::statefulImageChooser_instructionText()())});
        }



        //  Generated on Tue May 25 00:11:23 2021

        if($wnd.isc.TourStep) {
            $wnd.isc.TourStep.addProperties({inputValidationNotifyMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::tourStep_inputValidationNotifyMessage()()).replace(/(\$expectedValue)/g, '${expectedValue}')});
        }
        if($wnd.isc.FormulaBuilder) {
            $wnd.isc.FormulaBuilder.addProperties({nearbyComponentFieldPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_nearbyComponentFieldPrompt()()).replace(/(\$fieldName)/g, '${fieldName}').replace(/(\$componentName)/g, '${componentName}')});
            $wnd.isc.FormulaBuilder.addProperties({currentComponentFieldPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_currentComponentFieldPrompt()()).replace(/(\$fieldName)/g, '${fieldName}').replace(/(\$componentName)/g, '${componentName}')});
            $wnd.isc.FormulaBuilder.addProperties({dataSourceFieldPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_dataSourceFieldPrompt()()).replace(/(\$fieldName)/g, '${fieldName}').replace(/(\$dataSource)/g, '${dataSource}')});
        }
        if($wnd.isc.DatetimeFormatEditor) {
            $wnd.isc.DatetimeFormatEditor.addClassProperties({timeContainsDateFormattingErrorMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_timeContainsDateFormattingErrorMessage()())});
            $wnd.isc.DatetimeFormatEditor.addClassProperties({dateContainsTimeFormattingErrorMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::datetimeFormatEditor_dateContainsTimeFormattingErrorMessage()())});
        }
        if($wnd.isc.NumberFormatEditor) {
            $wnd.isc.NumberFormatEditor.addClassProperties({userLocaleCurrencySymbolDescription: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_userLocaleCurrencySymbolDescription()())});
            $wnd.isc.NumberFormatEditor.addClassProperties({formatCodeNotApplicableMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::numberFormatEditor_formatCodeNotApplicableMessage()())});
        }




        //  Generated on Tue May 25 00:47:23 2021

        if($wnd.isc.Validator) {
            $wnd.isc.Validator.addClassProperties({notAMeasure: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notAMeasure()())});
        }


        //  Generated on Wed May 26 10:29:25 2021

        if($wnd.isc.CubeGrid) {
            $wnd.isc.CubeGrid.addProperties({fieldVisibilitySubmenuTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_fieldVisibilitySubmenuTitle()())});
            $wnd.isc.CubeGrid.addProperties({highlightSelectionTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_highlightSelectionTitle()())});
            $wnd.isc.CubeGrid.addProperties({highlightCellTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_highlightCellTitle()())});
            $wnd.isc.CubeGrid.addProperties({highlightTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_highlightTitle()())});
            $wnd.isc.CubeGrid.addProperties({noHighlightsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_noHighlightsTitle()())});
            $wnd.isc.CubeGrid.addProperties({showHighlightsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_showHighlightsTitle()())});
            $wnd.isc.CubeGrid.addProperties({showAllHighlightsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_showAllHighlightsTitle()())});
            $wnd.isc.CubeGrid.addProperties({hideAllHighlightsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_hideAllHighlightsTitle()())});
            $wnd.isc.CubeGrid.addProperties({showHoverTipsTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_showHoverTipsTitle()())});
            $wnd.isc.CubeGrid.addProperties({chartItemTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_chartItemTitle()())});
            $wnd.isc.CubeGrid.addProperties({chartDialogTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_chartDialogTitle()())});
            $wnd.isc.CubeGrid.addProperties({autoFitColumnTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_autoFitColumnTitle()())});
            $wnd.isc.CubeGrid.addProperties({maximizeColumnTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_maximizeColumnTitle()())});
            $wnd.isc.CubeGrid.addProperties({minimizeColumnTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_minimizeColumnTitle()())});
            $wnd.isc.CubeGrid.addProperties({renameFacetValueTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_renameFacetValueTitle()())});
            $wnd.isc.CubeGrid.addProperties({controlReorderHandleTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_controlReorderHandleTitle()())});
            $wnd.isc.CubeGrid.addProperties({controlMinimizeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_controlMinimizeTitle()())});
            $wnd.isc.CubeGrid.addProperties({controlMaximizeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_controlMaximizeTitle()())});
            $wnd.isc.CubeGrid.addProperties({controlSortUpTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_controlSortUpTitle()())});
            $wnd.isc.CubeGrid.addProperties({controlCloseTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_controlCloseTitle()())});
            $wnd.isc.CubeGrid.addProperties({chartTypeTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_chartTypeTitle()())});
            $wnd.isc.CubeGrid.addProperties({chartStackedTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_chartStackedTitle()())});
        }


        //  Generated on Wed May 26 10:48:48 2021

        if($wnd.isc.CubeGrid) {
            $wnd.isc.CubeGrid.addProperties({controlSortDownTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_controlSortDownTitle()())});
        }


        //  Generated on Thu May 27 08:25:37 2021

        if($wnd.isc.LearningCenterDock) {
            $wnd.isc.LearningCenterDock.addProperties({buttonPromptToShow: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::learningCenterDock_buttonPromptToShow()())});
            $wnd.isc.LearningCenterDock.addProperties({buttonPromptToHide: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::learningCenterDock_buttonPromptToHide()())});
        }
        if($wnd.isc.CubeGrid) {
            $wnd.isc.CubeGrid.addProperties({renameFacetValueMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::cubeGrid_renameFacetValueMessage()())});
        }


        //  Generated on Wed Jun  2 12:45:10 2021

        if($wnd.isc.DateChooser) {
            $wnd.isc.DateChooser.addProperties({previousYearButtonAriaLabel: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_previousYearButtonAriaLabel()())});
            $wnd.isc.DateChooser.addProperties({previousMonthButtonAriaLabel: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_previousMonthButtonAriaLabel()())});
            $wnd.isc.DateChooser.addProperties({nextMonthButtonAriaLabel: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_nextMonthButtonAriaLabel()())});
        }


        //  Generated on Wed Jun  2 22:32:46 2021

        if($wnd.isc.DateChooser) {
            $wnd.isc.DateChooser.addProperties({nextYearButtonAriaLabel: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dateChooser_nextYearButtonAriaLabel()())});
        }


        //  Generated on Fri Jun 18 04:54:14 2021

        if($wnd.isc.Calendar) {
            $wnd.isc.Calendar.addProperties({newEventWindowTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::calendar_newEventWindowTitle()())});
        }
        if($wnd.isc.TreeGrid) {
            $wnd.isc.TreeGrid.addProperties({cantDragMultipleNodeOccurencesMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::treeGrid_cantDragMultipleNodeOccurencesMessage()())});
        }


        //  Generated on Tue Sep 14 04:47:13 2021

        if($wnd.isc.WorkflowValuesBindingEditor) {
            $wnd.isc.WorkflowValuesBindingEditor.addProperties({clearBindingPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::workflowValuesBindingEditor_clearBindingPrompt()())});
        }


        //  Generated on Thu Oct 14 21:50:37 2021

        if($wnd.isc.FormSaveDataTask) {
            $wnd.isc.FormSaveDataTask.addProperties({boundNotifyMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSaveDataTask_boundNotifyMessage()())});
            $wnd.isc.FormSaveDataTask.addProperties({unboundNotifyMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formSaveDataTask_unboundNotifyMessage()())});
        }
        if($wnd.isc.GridRemoveSelectedDataTask) {
            $wnd.isc.GridRemoveSelectedDataTask.addProperties({refuseMultiRemoveMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridRemoveSelectedDataTask_refuseMultiRemoveMessage()())});
            $wnd.isc.GridRemoveSelectedDataTask.addProperties({confirmationMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridRemoveSelectedDataTask_confirmationMessage()()).replace(/(\$dsTitle)/g, '${dsTitle}').replace(/(\$recordTitle)/g, '${recordTitle}')});
            $wnd.isc.GridRemoveSelectedDataTask.addProperties({unboundConfirmationMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridRemoveSelectedDataTask_unboundConfirmationMessage()())});
            $wnd.isc.GridRemoveSelectedDataTask.addProperties({multipleConfirmationMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridRemoveSelectedDataTask_multipleConfirmationMessage()()).replace(/(\$dsPluralTitle)/g, '${dsPluralTitle}')});
            $wnd.isc.GridRemoveSelectedDataTask.addProperties({unboundMultipleConfirmationMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::gridRemoveSelectedDataTask_unboundMultipleConfirmationMessage()())});
        }
        if($wnd.isc.SavedSearchEditor) {
            $wnd.isc.SavedSearchEditor.addProperties({sharedSearchTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchEditor_sharedSearchTitle()())});
            $wnd.isc.SavedSearchEditor.addProperties({defaultSearchTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchEditor_defaultSearchTitle()())});
            $wnd.isc.SavedSearchEditor.addProperties({addSearchText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchEditor_addSearchText()())});
            $wnd.isc.SavedSearchEditor.addProperties({gridAddSearchText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchEditor_gridAddSearchText()())});
            $wnd.isc.SavedSearchEditor.addProperties({editSearchText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchEditor_editSearchText()())});
        }
        if($wnd.isc.EditSearchWindow) {
            $wnd.isc.EditSearchWindow.addProperties({title: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::editSearchWindow_title()())});
        }
        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({noSavedSearchesText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_noSavedSearchesText()())});
        }
        if($wnd.isc.SavedSearchItem) {
            $wnd.isc.SavedSearchItem.addProperties({editSearchHoverText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_editSearchHoverText()())});
            $wnd.isc.SavedSearchItem.addProperties({removeSearchHoverText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_removeSearchHoverText()())});
            $wnd.isc.SavedSearchItem.addProperties({copySearchHoverText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_copySearchHoverText()())});
            $wnd.isc.SavedSearchItem.addProperties({markAsDefaultHoverText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_markAsDefaultHoverText()())});
            $wnd.isc.SavedSearchItem.addProperties({title: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_title()())});
            $wnd.isc.SavedSearchItem.addProperties({hint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_hint()())});
        }


        //  Generated on Mon Dec  6 11:32:22 2021

        if($wnd.isc.SendEmailTask) {
            $wnd.isc.SendEmailTask.addProperties({mockModeNotifyMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::sendEmailTask_mockModeNotifyMessage()()).replace(/(\$to)/g, '${to}').replace(/(\$subject)/g, '${subject}').replace(/(\$message)/g, '${message}')});
        }
        if($wnd.isc.SendSMSTask) {
            $wnd.isc.SendSMSTask.addProperties({mockModeNotifyMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::sendSMSTask_mockModeNotifyMessage()()).replace(/(\$to)/g, '${to}').replace(/(\$subject)/g, '${subject}').replace(/(\$message)/g, '${message}')});
        }
        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({savedSearchText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_savedSearchText()())});
        }
        if($wnd.isc.FieldValidatorsItem) {
            $wnd.isc.FieldValidatorsItem.addProperties({cancelButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldValidatorsItem_cancelButtonTitle()())});
            $wnd.isc.FieldValidatorsItem.addProperties({saveButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::fieldValidatorsItem_saveButtonTitle()())});
        }


        //  Generated on Thu Jan  6 09:53:31 2022

        if($wnd.isc.Canvas) {
        }
        if($wnd.isc.DataSource) {
            $wnd.isc.DataSource.addClassProperties({requiredFileMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataSource_requiredFileMessage()()).replace(/(\$uploadedFileName)/g, '${uploadedFileName}')});
        }
        if($wnd.isc.Operators) {
            $wnd.isc.Operators.addClassProperties({valueSetUsageHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_valueSetUsageHint()())});
        }
        if($wnd.isc.BatchUploader) {
            $wnd.isc.BatchUploader.addProperties({errorMessageRowsNotParsed: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_errorMessageRowsNotParsed()()).replace(/(\$goodRowCount)/g, '${goodRowCount}').replace(/(\$totalRows)/g, '${totalRows}').replace(/(\$firstBadRow)/g, '${firstBadRow}')});
            $wnd.isc.BatchUploader.addProperties({previousButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_previousButtonTitle()())});
            $wnd.isc.BatchUploader.addProperties({nextButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::batchUploader_nextButtonTitle()())});
        }
        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({newSearchText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_newSearchText()())});
            $wnd.isc.ListGrid.addProperties({cancelEditingConfirmationMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_cancelEditingConfirmationMessage()())});
            $wnd.isc.ListGrid.addProperties({confirmDiscardEditsMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_confirmDiscardEditsMessage()())});
        }
        if($wnd.isc.RichTextEditor) {
            $wnd.isc.RichTextEditor.addProperties({colorPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_colorPrompt()())});
            $wnd.isc.RichTextEditor.addProperties({linkPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::richTextEditor_linkPrompt()())});
        }
        if($wnd.isc.FormulaBuilder) {
            $wnd.isc.FormulaBuilder.addProperties({helpTextIntro: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_helpTextIntro()())});
            $wnd.isc.FormulaBuilder.addProperties({saveAddAnotherButtonTitle: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::formulaBuilder_saveAddAnotherButtonTitle()())});
        }
        if($wnd.isc.Validator) {
            $wnd.isc.Validator.addClassProperties({notAString: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::validator_notAString()())});
        }
        if($wnd.isc.DynamicForm) {
            $wnd.isc.DynamicForm.addProperties({errorsPreamble: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dynamicForm_errorsPreamble()())});
        }
        if($wnd.isc.FilterClause) {
            $wnd.isc.FilterClause.addProperties({valueItemListHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_valueItemListHint()())});
            $wnd.isc.FilterClause.addProperties({valueItemFieldHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::filterClause_valueItemFieldHint()())});
        }
        if($wnd.isc.SavedSearchItem) {
            $wnd.isc.SavedSearchItem.addProperties({confirmRemovalMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_confirmRemovalMessage()()).replace(/(\$title)/g, '${title}')});
        }


        //  Generated on Fri Jan  7 05:11:03 2022

        if($wnd.isc.Canvas) {
            $wnd.isc.Canvas.addProperties({removeSummaryFieldText: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::dataBoundComponent_removeSummaryFieldText()())});
        }
        if($wnd.isc.Operators) {
            $wnd.isc.Operators.addClassProperties({valueRangeUsageHint: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::operators_valueRangeUsageHint()())});
        }


        //  Generated on Thu Jan 27 01:09:05 2022

        if($wnd.isc.ListGrid) {
            $wnd.isc.ListGrid.addProperties({asynchGroupingPrompt: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_asynchGroupingPrompt()()).replace(/(\$loadingImage)/g, '${loadingImage}')});
            $wnd.isc.ListGrid.addProperties({loadingDataMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::listGrid_loadingDataMessage()()).replace(/(\$loadingImage)/g, '${loadingImage}')});
        }
        if($wnd.isc.TileGrid) {
            $wnd.isc.TileGrid.addProperties({loadingDataMessage: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::tileGrid_loadingDataMessage()()).replace(/(\$loadingImage)/g, '${loadingImage}')});
        }
        if($wnd.isc.SavedSearchItem) {
            $wnd.isc.SavedSearchItem.addProperties({defaultSearchNameSuffix: (messages.@com.smartgwt.client.i18n.SmartGwtMessages::savedSearchItem_defaultSearchNameSuffix()())});
        }
//<localeGenerator -- SC locale parser will process whatever's inside these tags

        $wnd.isc.addProperties($wnd.Date, {dayNames: [
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_1()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_2()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_3()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_4()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_5()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_6()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_dayNames_7()()]
        });

        $wnd.isc.addProperties($wnd.Date, {shortDayNames: [
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_1()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_2()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_3()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_4()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_5()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_6()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortDayNames_7()()]
        });

        $wnd.isc.addProperties($wnd.Date, {monthNames: [
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_1()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_2()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_3()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_4()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_5()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_6()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_7()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_8()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_9()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_10()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_11()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_monthNames_12()()]
        });

        $wnd.isc.addProperties($wnd.Date, {shortMonthNames: [
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_1()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_2()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_3()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_4()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_5()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_6()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_7()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_8()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_9()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_10()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_11()(),
            messages.@com.smartgwt.client.i18n.SmartGwtMessages::date_shortMonthNames_12()()]
        });

        if (!normalDateFormat && !normalDatetimeFormat && 
                !shortDateFormat && !shortDatetimeFormat &&
                !inputFormat)
        {
            // no formats were supplied - this should never happen, but autoDetect if it does
            @com.smartgwt.client.util.DateUtil::autoDetectFormats()();
        }

        @com.smartgwt.client.util.I18nUtil::initialized = true;
    }-*/;
}
