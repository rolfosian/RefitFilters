package org.starficz.refitfilters

import rolflectionlib.ui.UiUtil

import com.fs.starfarer.api.EveryFrameScript
import com.fs.starfarer.api.Global
import com.fs.starfarer.api.campaign.CoreUITabId

class CampaignUIAdderScript : EveryFrameScript{

    override fun isDone(): Boolean {
        return false
    }

    override fun runWhilePaused(): Boolean {
        return true
    }

    override fun advance(amount: Float) {
        if (!Global.getSector().isPaused) return //Return if not paused

        val campaignUI = Global.getSector().campaignUI
        if (campaignUI.currentCoreTab != CoreUITabId.REFIT) return //Return if not Refit

        var docked = false

        //Try to check if a dialog is open, and grab the CoreUI from it (Relevant for when refit is opened while docked to a colony, etc)
        val dialog = campaignUI.currentInteractionDialog
        val core = if (dialog != null) {
            docked = true
            UiUtil.utils.interactionDialogGetCore(dialog)
        }
        else { UiUtil.utils.campaignUIgetCore(campaignUI) } ?: return

        FilterPanelCreator.modifyFilterPanels(core, true, docked)
    }
}