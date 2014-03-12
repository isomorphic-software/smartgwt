
package com.smartgwt.client.docs;

/**
 * <h3>Localized Number Formatting</h3>
 * Use the special {@link com.smartgwt.client.data.DataSourceField#getType field types}
 * "localeInt", "localeFloat" and "localeCurrency" to have locale-specific formatting applied to
 * numeric values, as well as automatic parsing of user inputs that use locale-specific decimal
 * and grouping separators. <p>   These special types automatically use GWT's NumberFormat logic,
 * using the default locale. Additional {@link com.smartgwt.client.data.SimpleType SimpleTypes}
 * can be created that call GWT's NumberFormat if more variations are needed. <p> Note that
 * language packs shipped with SmartGWT contain properties such as "decimalSymbol" that seemingly
 * would control localized number formatting.  These are inactive for SmartGWT and should be
 * ignored. <p> See {@link com.smartgwt.client.docs.I18n} for more background on
 * internationalization.
 */
public interface LocalizedNumberFormatting {
}
