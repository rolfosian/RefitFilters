package org.starficz.refitfilters

import com.fs.starfarer.api.Global
import com.fs.starfarer.api.ui.UIComponentAPI
import com.fs.starfarer.api.ui.UIPanelAPI
import com.fs.starfarer.coreui.refit.FighterPickerDialog
import com.fs.starfarer.coreui.refit.WeaponPickerDialog
import org.starficz.UIFramework.*
import rolflectionlib.ui.UiUtil

object PickerPanelHelpers {
    fun filtersChanged(pickerPanel: UIPanelAPI) {
        when (pickerPanel) {
            is FighterPickerDialog -> pickerPanel.notifyFilterChanged()
            is WeaponPickerDialog -> pickerPanel.notifyFilterChanged()
        }
    }

    fun setPickerPanelHeight(height: Float, pickerPanel: UIPanelAPI, type: PickerPanelType) {
        val holoHeightHandle = if (type == PickerPanelType.Fighters) {
            UiUtil.fighterPickerHeightVarHandle
        } else UiUtil.weaponPickerHeightVarHandle

        holoHeightHandle.set(pickerPanel, height)
        pickerPanel.height = height

        // pin the weapons list in place
        pinPickerPanelYPos(pickerPanel)
    }

    fun pinPickerPanelYPos(pickerPanel: UIPanelAPI) {
        val lowRange = 40f + pickerPanel.height
        val highRange = Global.getSettings().screenHeight - 40f
        val pickerFixedTop = if(lowRange < highRange) (pickerPanel.centerY + 350f).coerceIn(lowRange, highRange)
                             else Global.getSettings().screenHeight/2 + 350f
        pickerPanel.yAlignOffset += pickerFixedTop - pickerPanel.top
    }

    fun <T: Any, R: FilterData> sortAndFilterList(
        type: PickerPanelType,
        uiList: UIComponentAPI,
        filterFunction: (T, R) -> Boolean,
        filterData: R,
        comparator: Comparator<Pair<Any, T>>,
        searchTerm: String,
        searchBehaviour: String // e.g., "Filter", "SortAndFilter", etc.
    ): List<Pair<Any, T>> {
        val individualItems = UiUtil.utils.listPanelGetItems(uiList)

        val handle = when (type) {
            PickerPanelType.Fighters -> UiUtil.tooltipFighterSpecVarHandle
            PickerPanelType.Weapons  -> UiUtil.tooltipWeaponSpecVarHandle
        }

        val specPairs = individualItems.map { item ->
            val tooltip = UiUtil.utils.uiComponentGetTooltip(item!!)
            item to handle.get(tooltip) as T
        }

        var processedSpecPairs = specPairs.filter { (_, spec) ->!filterFunction(spec, filterData) }

        if (searchBehaviour != "Filter" && searchTerm.isNotBlank()) {
            processedSpecPairs = processedSpecPairs.sortedWith(comparator)
        }

        UiUtil.utils.listPanelClear(uiList)
        for (pair in processedSpecPairs) {
            UiUtil.utils.listPanelAddItem(uiList, pair.first as UIComponentAPI)
        }

        return processedSpecPairs
    }
}