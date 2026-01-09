package org.starficz.UIFramework

import com.fs.graphics.Sprite
import com.fs.graphics.util.Fader
import com.fs.starfarer.api.Global
import com.fs.starfarer.api.campaign.BaseCustomUIPanelPlugin
import com.fs.starfarer.api.campaign.CustomUIPanelPlugin
import com.fs.starfarer.api.ui.*
import com.fs.starfarer.api.ui.TooltipMakerAPI.TooltipLocation
import com.fs.starfarer.ui.impl.StandardTooltipV2Expandable

import rolflectionlib.ui.UiUtil
import java.awt.Color

internal var BoxedUIElement.fader: Fader?
    get() = UiUtil.utils.uiComponentGetFader(this.wrappedComponent)
    set(fader) { UiUtil.utils.uiComponentSetFader(this.wrappedComponent, fader) }

internal var BoxedUIElement.opacity: Float
    get() = UiUtil.utils.getOpacity(this.wrappedComponent)
    set(alpha) { UiUtil.utils.setOpacity(this.wrappedComponent, alpha) }

internal var BoxedUIElement.parent: UIPanelAPI?
    get() = UiUtil.utils.getParent(this.wrappedComponent)
    set(parent) { UiUtil.utils.setParent(this.wrappedComponent, parent) }

internal fun BoxedUIElement.setMouseOverPad(pad1: Float, pad2: Float, pad3: Float, pad4: Float) {
    UiUtil.utils.setMouseOverPad(this.wrappedComponent, pad1, pad2, pad3, pad4)
}

internal val BoxedUIElement.mouseoverHighlightFader: Fader?
    get() = UiUtil.utils.getMouseoverHighlightFader(this.wrappedComponent)

internal val BoxedUIElement.topAncestor: UIPanelAPI?
    get() = UiUtil.utils.findTopAncestor(this.wrappedComponent)

internal fun BoxedUIElement.setTooltipOffsetFromCenter(xPad: Float, yPad: Float){
    UiUtil.utils.setTooltipOffsetFromCenter(this.wrappedComponent, xPad, yPad)
}

internal fun BoxedUIElement.setTooltipPositionRelativeToAnchor(xPad: Float, yPad: Float, anchor: UIComponentAPI){
    UiUtil.utils.setTooltipPositionRelativeToAnchor(this.wrappedComponent, xPad, yPad, anchor)
}

internal fun BoxedUIElement.setSlideData(xOffset: Float, yOffset: Float, durationIn: Float, durationOut: Float){
    UiUtil.utils.setSlideData(this.wrappedComponent, xOffset, yOffset, durationIn, durationOut)
}

internal fun BoxedUIElement.slideIn(){
    UiUtil.utils.slideIn(this.wrappedComponent)
}

internal fun BoxedUIElement.slideOut(){
    UiUtil.utils.slideOut(this.wrappedComponent)
}

internal fun BoxedUIElement.forceSlideIn(){
    UiUtil.utils.forceSlideIn(this.wrappedComponent)
}

internal fun BoxedUIElement.forceSlideOut(){
    UiUtil.utils.forceSlideOut(this.wrappedComponent)
}

internal val BoxedUIElement.sliding: Boolean
    get() = UiUtil.utils.isSliding(this.wrappedComponent)

internal val BoxedUIElement.slidIn: Boolean
    get() = UiUtil.utils.isSlidIn(this.wrappedComponent)

internal val BoxedUIElement.slidOut: Boolean
    get() = UiUtil.utils.isSlidOut(this.wrappedComponent)

internal val BoxedUIElement.slidingIn: Boolean
    get() = UiUtil.utils.isSlidingIn(this.wrappedComponent)

internal var BoxedUIElement.enabled: Boolean
    get() = UiUtil.utils.isEnabled(this.wrappedComponent)
    set(enabled) {
        UiUtil.utils.setEnabled(this.wrappedComponent, enabled)
    }

internal var BoxedUIElement.width
    get() = position.width
    set(width) { position.setSize(width, position.height) }

internal var BoxedUIElement.height
    get() = position.height
    set(height) { position.setSize(position.width, height) }

internal fun BoxedUIElement.setSize(width: Float, height: Float){
    position.setSize(width, height)
}

internal val BoxedUIElement.x
    get() = position.x

internal val BoxedUIElement.y
    get() = position.y

internal val BoxedUIElement.left
    get() = x

internal val BoxedUIElement.bottom
    get() = y

internal val BoxedUIElement.top
    get() = y + height

internal val BoxedUIElement.right
    get() = x + width

internal fun BoxedUIElement.setLocation(x: Float, y: Float){
    position.setLocation(x, y)
}

internal val BoxedUIElement.centerX
    get() = position.centerX

internal val BoxedUIElement.centerY
    get() = position.centerY

internal var BoxedUIElement.xAlignOffset: Float
    get() = UiUtil.utils.positionGetXAlignOffset(this.position)
    set(xOffset) { UiUtil.utils.positionSetXAlignOffset(this.position, xOffset) }

internal var BoxedUIElement.yAlignOffset: Float
    get() = UiUtil.utils.positionGetYAlignOffset(this.position)
    set(yOffset) { UiUtil.utils.positionSetYAlignOffset(this.position, yOffset) }

internal fun BoxedUIElement.anchorInTopLeftOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inTL(xPad, yPad)
}
internal fun BoxedUIElement.anchorInTopRightOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inTR(xPad, yPad)
}
internal fun BoxedUIElement.anchorInTopMiddleOfParent(yPad: Float = 0f) {
    this.position.inTMid(yPad)
}
internal fun BoxedUIElement.anchorInBottomLeftOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inBL(xPad, yPad)
}
internal fun BoxedUIElement.anchorInBottomMiddleOfParent(yPad: Float = 0f) {
    this.position.inBMid(yPad)
}
internal fun BoxedUIElement.anchorInBottomRightOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inBR(xPad, yPad)
}
internal fun BoxedUIElement.anchorInLeftMiddleOfParent(xPad: Float = 0f) {
    this.position.inLMid(xPad)
}
internal fun BoxedUIElement.anchorInRightMiddleOfParent(xPad: Float = 0f) {
    this.position.inRMid(xPad)
}
internal fun BoxedUIElement.anchorInCenterOfParent() {
    UiUtil.utils.positionRelativeTo(this.position, null, 0.5f, 0.5f, -0.5f, -0.5f, 0f, 0f)
}

internal val BoxedUIElement.previousComponent
    get() = UiUtil.utils.getChildrenCopy(this.wrappedComponent as UIPanelAPI).lastOrNull()

internal fun BoxedUIElement.anchorRightOfPreviousMatchingTop(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.rightOfTop(it, padding) }
}
internal fun BoxedUIElement.anchorLeftOfPreviousMatchingTop(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.leftOfTop(it, padding) }
}
internal fun BoxedUIElement.anchorLeftOfPreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.leftOfMid(it, padding) }
}
internal fun BoxedUIElement.anchorLeftOfPreviousMatchingBottom(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.leftOfBottom(it, padding) }
}
internal fun BoxedUIElement.anchorRightOfPreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.rightOfMid(it, padding) }
}
internal fun BoxedUIElement.anchorRightOfPreviousMatchingBottom(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.rightOfBottom(it, padding) }
}
internal fun BoxedUIElement.anchorAbovePreviousMatchingLeft(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.aboveLeft(it, padding) }
}
internal fun BoxedUIElement.anchorAbovePreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.aboveMid(it, padding) }
}
internal fun BoxedUIElement.anchorAbovePreviousMatchingRight(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.aboveRight(it, padding) }
}
internal fun BoxedUIElement.anchorBelowPreviousMatchingLeft(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.belowLeft(it, padding) }
}
internal fun BoxedUIElement.anchorBelowPreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.belowMid(it, padding) }
}
internal fun BoxedUIElement.anchorBelowPreviousMatchingRight(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.belowRight(it, padding) }
}
internal fun BoxedUIElement.anchorToPreviousMatchingCenter(xPad: Float = 0f, yPad: Float = 0f) {
    val parent = this.parent ?: return; val children = parent.getChildrenCopy(); if (children.size <= 1) return
    val anchor = children.dropLast(1).lastOrNull()
    anchor?.let { nonNullAnchor ->
        UiUtil.utils.positionRelativeTo(this.position, nonNullAnchor.position, 0.5f, 0.5f, -0.5f, -0.5f, xPad, yPad)
    }
}

internal fun BoxedUIElement.addTooltip(
    location: TooltipLocation,
    width: Float,
    padding: Float? = null,
    lambda: (TooltipMakerAPI) -> Unit) {
    val tooltip = object: StandardTooltipV2Expandable(width, false, true) {
        override fun createImpl(p0: Boolean) {
            lambda(this)
        }
    }

    val tooltipClass = StandardTooltipV2Expandable::class.java
    if(padding == null){
        when(location){
            TooltipLocation.LEFT -> UiUtil.utils.addTooltipLeft(this.wrappedComponent, tooltip)
            TooltipLocation.RIGHT -> UiUtil.utils.addTooltipRight(this.wrappedComponent, tooltip)
            TooltipLocation.ABOVE -> UiUtil.utils.addTooltipAbove(this.wrappedComponent, tooltip)
            TooltipLocation.BELOW -> UiUtil.utils.addTooltipBelow(this.wrappedComponent, tooltip)
        }
    }
    else{
        when(location){
            TooltipLocation.LEFT -> UiUtil.utils.addTooltipLeft(this.wrappedComponent, tooltip, padding)
            TooltipLocation.RIGHT -> UiUtil.utils.addTooltipRight(this.wrappedComponent, tooltip, padding)
            TooltipLocation.ABOVE -> UiUtil.utils.addTooltipAbove(this.wrappedComponent, tooltip, padding)
            TooltipLocation.BELOW -> UiUtil.utils.addTooltipBelow(this.wrappedComponent, tooltip, padding)
        }
    }
}

// UIComponentAPI extensions that expose UIComponent fields/methods
internal var UIComponentAPI.fader: Fader?
    get() = UiUtil.utils.uiComponentGetFader(this)
    set(fader) { UiUtil.utils.uiComponentSetFader(this, fader) }

internal var UIComponentAPI.opacity: Float
    get() = UiUtil.utils.getOpacity(this)
    set(alpha) { UiUtil.utils.setOpacity(this, alpha) }

internal var UIComponentAPI.parent: UIPanelAPI?
    get() = UiUtil.utils.getParent(this)
    set(parent) { UiUtil.utils.setParent(this, parent) }

internal fun UIComponentAPI.setMouseOverPad(pad1: Float, pad2: Float, pad3: Float, pad4: Float) {
    UiUtil.utils.setMouseOverPad(this, pad1, pad2, pad3, pad4)
}

internal val UIComponentAPI.mouseoverHighlightFader: Fader?
    get() = UiUtil.utils.getMouseoverHighlightFader(this)

internal val UIComponentAPI.topAncestor: UIPanelAPI?
    get() = UiUtil.utils.findTopAncestor(this)

internal fun UIComponentAPI.setTooltipOffsetFromCenter(xPad: Float, yPad: Float){
    UiUtil.utils.setTooltipOffsetFromCenter(this, xPad, yPad)
}

internal fun UIComponentAPI.setTooltipPositionRelativeToAnchor(xPad: Float, yPad: Float, anchor: UIComponentAPI){
    UiUtil.utils.setTooltipPositionRelativeToAnchor(this, xPad, yPad, anchor)
}

internal fun UIComponentAPI.setSlideData(xOffset: Float, yOffset: Float, durationIn: Float, durationOut: Float){
    UiUtil.utils.setSlideData(this, xOffset, yOffset, durationIn, durationOut)
}

internal fun UIComponentAPI.slideIn(){
    UiUtil.utils.slideIn(this)
}

internal fun UIComponentAPI.slideOut(){
    UiUtil.utils.slideOut(this)
}

internal fun UIComponentAPI.forceSlideIn(){
    UiUtil.utils.forceSlideIn(this)
}

internal fun UIComponentAPI.forceSlideOut(){
    UiUtil.utils.forceSlideOut(this)
}

internal val UIComponentAPI.sliding: Boolean
    get() = UiUtil.utils.isSliding(this)

internal val UIComponentAPI.slidIn: Boolean
    get() = UiUtil.utils.isSlidIn(this)

internal val UIComponentAPI.slidOut: Boolean
    get() = UiUtil.utils.isSlidOut(this)

internal val UIComponentAPI.slidingIn: Boolean
    get() = UiUtil.utils.isSlidingIn(this)

internal var UIComponentAPI.enabled: Boolean
    get() = UiUtil.utils.isEnabled(this)
    set(enabled) {
        UiUtil.utils.setEnabled(this, enabled)
    }

internal var UIComponentAPI.width
    get() = position.width
    set(width) { position.setSize(width, position.height) }

internal var UIComponentAPI.height
    get() = position.height
    set(height) { position.setSize(position.width, height) }

internal fun UIComponentAPI.setSize(width: Float, height: Float){
    position.setSize(width, height)
}

internal val UIComponentAPI.x
    get() = position.x

internal val UIComponentAPI.y
    get() = position.y

internal val UIComponentAPI.left
    get() = x

internal val UIComponentAPI.bottom
    get() = y

internal val UIComponentAPI.top
    get() = y + height

internal val UIComponentAPI.right
    get() = x + width

internal fun UIComponentAPI.setLocation(x: Float, y: Float){
    position.setLocation(x, y)
}

internal val UIComponentAPI.centerX
    get() = position.centerX

internal val UIComponentAPI.centerY
    get() = position.centerY

internal var UIComponentAPI.xAlignOffset: Float
    get() = UiUtil.utils.positionGetXAlignOffset(this.position)
    set(xOffset) { UiUtil.utils.positionSetXAlignOffset(this.position, xOffset) }

internal var UIComponentAPI.yAlignOffset: Float
    get() = UiUtil.utils.positionGetYAlignOffset(this.position)
    set(yOffset) { UiUtil.utils.positionSetYAlignOffset(this.position, yOffset) }

internal fun UIComponentAPI.anchorInTopLeftOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inTL(xPad, yPad)
}
internal fun UIComponentAPI.anchorInTopRightOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inTR(xPad, yPad)
}
internal fun UIComponentAPI.anchorInTopMiddleOfParent(yPad: Float = 0f) {
    this.position.inTMid(yPad)
}
internal fun UIComponentAPI.anchorInBottomLeftOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inBL(xPad, yPad)
}
internal fun UIComponentAPI.anchorInBottomMiddleOfParent(yPad: Float = 0f) {
    this.position.inBMid(yPad)
}
internal fun UIComponentAPI.anchorInBottomRightOfParent(xPad: Float = 0f, yPad: Float = 0f) {
    this.position.inBR(xPad, yPad)
}
internal fun UIComponentAPI.anchorInLeftMiddleOfParent(xPad: Float = 0f) {
    this.position.inLMid(xPad)
}
internal fun UIComponentAPI.anchorInRightMiddleOfParent(xPad: Float = 0f) {
    this.position.inRMid(xPad)
}
internal fun UIComponentAPI.anchorInCenterOfParent() {
    val floatType = Float::class.javaPrimitiveType!!
    val paramTypes = listOf<Class<*>?>(this.position::class.java,
        floatType, floatType, floatType, floatType, floatType, floatType).toTypedArray()

    UiUtil.utils.positionRelativeTo(this.position, null, 0.5f, 0.5f, -0.5f, -0.5f, 0f, 0f)
}

internal val UIPanelAPI.previousComponent
    get() = getChildrenCopy().lastOrNull()

internal fun UIComponentAPI.anchorRightOfPreviousMatchingTop(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.rightOfTop(it, padding) }
}
internal fun UIComponentAPI.anchorLeftOfPreviousMatchingTop(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.leftOfTop(it, padding) }
}
internal fun UIComponentAPI.anchorLeftOfPreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.leftOfMid(it, padding) }
}
internal fun UIComponentAPI.anchorLeftOfPreviousMatchingBottom(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.leftOfBottom(it, padding) }
}
internal fun UIComponentAPI.anchorRightOfPreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.rightOfMid(it, padding) }
}
internal fun UIComponentAPI.anchorRightOfPreviousMatchingBottom(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.rightOfBottom(it, padding) }
}
internal fun UIComponentAPI.anchorAbovePreviousMatchingLeft(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.aboveLeft(it, padding) }
}
internal fun UIComponentAPI.anchorAbovePreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.aboveMid(it, padding) }
}
internal fun UIComponentAPI.anchorAbovePreviousMatchingRight(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.aboveRight(it, padding) }
}
internal fun UIComponentAPI.anchorBelowPreviousMatchingLeft(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.belowLeft(it, padding) }
}
internal fun UIComponentAPI.anchorBelowPreviousMatchingMid(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.belowMid(it, padding) }
}
internal fun UIComponentAPI.anchorBelowPreviousMatchingRight(padding: Float = 0f) {
    UiUtil.utils.getChildrenCopy(parent)?.dropLast(1)?.lastOrNull()?.let { this.position.belowRight(it, padding) }
}
internal fun UIComponentAPI.anchorToPreviousMatchingCenter(xPad: Float = 0f, yPad: Float = 0f) {
    val parent = this.parent ?: return; val children = parent.getChildrenCopy(); if (children.size <= 1) return
    val anchor = children.dropLast(1).lastOrNull()
    anchor?.let { nonNullAnchor ->
        UiUtil.utils.positionRelativeTo(this.position, nonNullAnchor.position, 0.5f, 0.5f, -0.5f, -0.5f, xPad, yPad)
    }
}

internal fun UIComponentAPI.addTooltip(
    location: TooltipLocation,
    width: Float,
    padding: Float? = null,
    lambda: (TooltipMakerAPI) -> Unit) {
    val tooltip = object: StandardTooltipV2Expandable(width, false, true) {
        override fun createImpl(p0: Boolean) {
            lambda(this)
        }
    }

    val tooltipClass = StandardTooltipV2Expandable::class.java
    if(padding == null){
        when(location){
            TooltipLocation.LEFT -> UiUtil.utils.addTooltipLeft(this, tooltip)
            TooltipLocation.RIGHT -> UiUtil.utils.addTooltipRight(this, tooltip)
            TooltipLocation.ABOVE -> UiUtil.utils.addTooltipAbove(this, tooltip)
            TooltipLocation.BELOW -> UiUtil.utils.addTooltipBelow(this, tooltip)
        }
    }
    else{
        when(location){
            TooltipLocation.LEFT -> UiUtil.utils.addTooltipLeft(this, tooltip, padding)
            TooltipLocation.RIGHT -> UiUtil.utils.addTooltipRight(this, tooltip, padding)
            TooltipLocation.ABOVE -> UiUtil.utils.addTooltipAbove(this, tooltip, padding)
            TooltipLocation.BELOW -> UiUtil.utils.addTooltipBelow(this, tooltip, padding)
        }
    }
}

// UIPanelAPI extensions that expose UIPanel methods
internal fun UIPanelAPI.getChildrenCopy(): List<UIComponentAPI> {
    return UiUtil.utils.getChildrenCopy(this)
}

internal fun UIPanelAPI.getChildrenNonCopy(): List<UIComponentAPI> {
    return UiUtil.utils.getChildrenNonCopy(this)
}

internal fun UIPanelAPI.clearChildren() {
    UiUtil.utils.clearChildren(this)
}

class BoxedUILabel(val uiLabel: LabelAPI): BoxedUIElement(uiLabel as UIComponentAPI),
    UIComponentAPI by (uiLabel as UIComponentAPI), LabelAPI by uiLabel {
    override fun advance(amount: Float) { uiLabel.advance(amount) }
    override fun getOpacity() = uiLabel.opacity
    override fun setOpacity(opacity: Float) { uiLabel.opacity = opacity }
    override fun render(alphaMult: Float) { uiLabel.render(alphaMult) }
    override fun getPosition(): PositionAPI? = uiLabel.position
    override fun getParent(): UIPanelAPI? = UiUtil.utils.labelGetParent(this.wrappedComponent)
}

class BoxedUIImage(val uiImage: UIComponentAPI): BoxedUIElement(uiImage), UIComponentAPI by uiImage {
    var spriteName = UiUtil.utils.imagePanelGetSpriteName(uiImage)
        set(newSpriteName) { UiUtil.utils.imagePanelSetSprite(uiImage, newSpriteName, true) }
    var sprite = UiUtil.utils.imagePanelGetSprite(uiImage)
        set(newSprite) { UiUtil.utils.imagePanelSetSprite(uiImage, newSprite, true) }

    var borderColor = UiUtil.utils.imagePanelGetBorderColor(uiImage)
        set(newColor) { UiUtil.utils.imagePanelSetBorderColor(uiImage, newColor) }

    var outline = UiUtil.utils.imagePanelIsWithOutline(uiImage)
        set(withOutline) { UiUtil.utils.imagePanelSetWithOutline(uiImage, withOutline) }

    var textureClamp = UiUtil.utils.imagePanelIsTexClamp(uiImage)
        set(texClamp) { UiUtil.utils.imagePanelSetTexClamp(uiImage, texClamp) }

    var forceNoRounding = UiUtil.utils.imagePanelIsForceNoRounding(uiImage)
        set(noRounding) { UiUtil.utils.imagePanelSetForceNoRounding(uiImage, noRounding) }

    val originalAspectRatio = UiUtil.utils.imagePanelGetOriginalAR(uiImage)

    fun setStretch(stretch: Boolean) { UiUtil.utils.imagePanelSetStretch(uiImage, stretch) }
    fun setRenderSchematic(renderSchematic: Boolean) { UiUtil.utils.imagePanelSetRenderSchematic(uiImage, renderSchematic) }
    fun sizeToOriginalSpriteSize() {  }
    fun sizeToOriginalAspectRatioWithWidth(width: Float) { UiUtil.utils.imagePanelAutoSizeToWidth(uiImage, width) }
    fun sizeToOriginalAspectRatioWithHeight(height: Float) { UiUtil.utils.imagePanelAutoSizeToHeight(uiImage, height) }
}

internal fun UIPanelAPI.addPara(text: String, font: Font? = null, color: Color? = null,
                                highlightedText: Collection<Pair<String, Color>>? = null): BoxedUILabel {
    val tempPanel = Global.getSettings().createCustom(width, height, null)
    val tempTMAPI = tempPanel.createUIElement(width, height, false)
    color?.let { tempTMAPI.setParaFontColor(it) }
    font?.let { tempTMAPI.setParaFont(getFontPath(font)) }

    val para = if(highlightedText != null) {
        val (highlights, highlightColors) = highlightedText.unzip()
        tempTMAPI.addPara(text, 0f, highlightColors.toTypedArray(), *highlights.toTypedArray())
    } else {
        tempTMAPI.addPara(text, 0f)
    }

    this.addComponent(para as UIComponentAPI)
    UiUtil.utils.labelAutoSize(para)

    return BoxedUILabel(para)
}

internal fun UIPanelAPI.addImage(imageSpritePath: String, width: Float, height: Float): BoxedUIImage {
    val tempPanel = Global.getSettings().createCustom(width, height, null)
    val tempTMAPI = tempPanel.createUIElement(width, height, false)
    tempTMAPI.addImage(imageSpritePath, width, height, 0f)
    val tempTMAPIsUIPanel = UiUtil.utils.getChildrenCopy(tempTMAPI)[0] as UIPanelAPI
    val image = UiUtil.utils.getChildrenCopy(tempTMAPIsUIPanel)[0]

    this.addComponent(image)
    return BoxedUIImage(image)
}

internal fun UIPanelAPI.addLabelledValue(label: String, value: String, labelColor: Color, valueColor: Color, width: Float): UIComponentAPI {
    val tempPanel = Global.getSettings().createCustom(width, height, null)
    val tempTMAPI = tempPanel.createUIElement(width, height, false)
    val labelledValue = tempTMAPI.addLabelledValue(label, value, labelColor, valueColor, width, 0f)
    this.addComponent(labelledValue)
    return BoxedUIImage(labelledValue)
}

internal fun UIPanelAPI.addTextField(width: Float, height: Float, font: Font): TextFieldAPI {
    val tempPanel = Global.getSettings().createCustom(width, height, null)
    val tempTMAPI = tempPanel.createUIElement(width, height, false)
    val textField = tempTMAPI.addTextField(width, height, getFontPath(font), 0f)
    this.addComponent(textField)
    return textField
}

internal fun UIPanelAPI.addButton(
    text: String, data: Any?, baseColor: Color, bgColor: Color, align: Alignment, style: CutStyle,
    width: Float, height: Float, font: Font? = null): ButtonAPI {
    // make a button in a temp panel/element
    val tempPanel = Global.getSettings().createCustom(width, height, null)
    val tempTMAPI = tempPanel.createUIElement(width, height, false)
    when(font){
        Font.VICTOR_10 -> tempTMAPI.setButtonFontVictor10()
        Font.VICTOR_14 -> tempTMAPI.setButtonFontVictor14()
        Font.ORBITRON_20 -> tempTMAPI.setButtonFontOrbitron20()
        Font.ORBITRON_20_BOLD -> tempTMAPI.setButtonFontOrbitron20Bold()
        Font.ORBITRON_24 -> tempTMAPI.setButtonFontOrbitron24()
        Font.ORBITRON_24_BOLD -> tempTMAPI.setButtonFontOrbitron24Bold()
        null -> tempTMAPI.setButtonFontDefault()
    }
    val button = tempTMAPI.addButton(text, data, baseColor, bgColor, align, style, width, height, 0f)

    // hijack button and move it to UIPanel
    this.addComponent(button)
    UiUtil.utils.positionSetXAlignOffset(button.position, 0f)
    UiUtil.utils.positionSetYAlignOffset(button.position, 0f)
    return button
}

internal fun UIPanelAPI.addAreaCheckbox(
    text: String, data: Any?, baseColor: Color, bgColor: Color, brightColor: Color,
    width: Float, height: Float, font: Font? = null, leftAlign: Boolean = false, flag: Flag? = null): ButtonAPI {
    // make a button in a temp panel/element
    val tempPanel = Global.getSettings().createCustom(width, height, null)
    val tempTMAPI = tempPanel.createUIElement(width, height, false)
    font?.let { tempTMAPI.setAreaCheckboxFont(getFontPath(font)) }

    val button = tempTMAPI.addAreaCheckbox(
        text, data, baseColor, bgColor, brightColor, width, height, 0f, leftAlign)

    this.addComponent(button)
    if (flag != null) {
        button.isChecked = flag.isEnabled
        button.onClick { flag.isEnabled = button.isChecked  }
    }
    UiUtil.utils.positionSetXAlignOffset(button.position, 0f)
    UiUtil.utils.positionSetYAlignOffset(button.position, 0f)
    return button
}


// CustomPanelAPI implements the same Listener that a ButtonAPI requires,
// A CustomPanel then happens to trigger its CustomUIPanelPlugin buttonPressed() method
// thus we can map our functions into a CustomUIPanelPlugin, and have them be triggered
internal class ButtonListener(button: ButtonAPI) : BaseCustomUIPanelPlugin() {
    private val onClickFunctions = mutableListOf<() -> Unit>()

    init {
        val buttonListener = Global.getSettings().createCustom(0f, 0f, this)
        UiUtil.utils.buttonSetListener(button, buttonListener)
    }
    override fun buttonPressed(buttonId: Any?) { onClickFunctions.forEach { it() } }
    fun addOnClick(function: () -> Unit) { onClickFunctions.add(function) }
    fun clearOnClickFunctions() { onClickFunctions.clear() }
}

// Extension function for ButtonAPI
internal fun ButtonAPI.onClick(function: () -> Unit) {
    // Use reflection to check if this button already has a listener
    val existingListener = UiUtil.utils.buttonGetListener(this)
    if (existingListener is CustomPanelAPI && existingListener.plugin is ButtonListener) {
        (existingListener.plugin as ButtonListener).addOnClick(function)
    } else {
        // if not, make one
        val listener = ButtonListener(this)
        listener.addOnClick(function)
    }
}

// Custom CustomUIPanelPlugin extensions that map the plugin to the panel
internal val ExtendableCustomUIPanelPlugin.width
    get() = customPanel.position.width

internal val ExtendableCustomUIPanelPlugin.height
    get() = customPanel.position.height

internal val ExtendableCustomUIPanelPlugin.x
    get() = customPanel.position.x

internal val ExtendableCustomUIPanelPlugin.y
    get() = customPanel.position.y

internal val ExtendableCustomUIPanelPlugin.left
    get() = x

internal val ExtendableCustomUIPanelPlugin.bottom
    get() = y

internal val ExtendableCustomUIPanelPlugin.top
    get() = y + height

internal val ExtendableCustomUIPanelPlugin.right
    get() = x + width

internal val ExtendableCustomUIPanelPlugin.centerX
    get() = customPanel.position.centerX

internal val ExtendableCustomUIPanelPlugin.centerY
    get() = customPanel.position.centerY

internal val ExtendableCustomUIPanelPlugin.xAlignOffset
    get() = UiUtil.utils.positionGetXAlignOffset(customPanel.position)

internal val ExtendableCustomUIPanelPlugin.yAlignOffset
    get() = UiUtil.utils.positionGetYAlignOffset(customPanel.position)

internal fun CustomPanelAPI.setPlugin(plugin: CustomUIPanelPlugin) {
    UiUtil.customPanelPluginVarHandle.set(this, plugin)
}
