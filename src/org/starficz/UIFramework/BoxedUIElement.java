package org.starficz.UIFramework;

import com.fs.graphics.util.Fader;
import com.fs.starfarer.api.ui.PositionAPI;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.ui.UIComponentAPI;
import com.fs.starfarer.api.ui.UIPanelAPI;
import com.fs.starfarer.ui.impl.StandardTooltipV2Expandable;

import java.util.List;

import rolflectionlib.ui.UiUtil;

public abstract class BoxedUIElement implements UIComponentAPI {

    protected final UIComponentAPI boxedElement;

    protected BoxedUIElement(UIComponentAPI boxedElement) {
        this.boxedElement = boxedElement;
    }

    @Override
    public PositionAPI getPosition() {
        return boxedElement.getPosition();
    }

    public Fader getFader() {
        return UiUtil.utils.uiComponentGetFader(boxedElement);
    }

    public void setFader(Fader value) {
        UiUtil.utils.uiComponentSetFader(boxedElement, value);
    }

    public float getOpacity() {
        return UiUtil.utils.getOpacity(boxedElement);
    }

    public void setOpacity(float value) {
        UiUtil.utils.setOpacity(boxedElement, value);
    }

    public UIPanelAPI getParent() {
        return UiUtil.utils.getParent(boxedElement);
    }

    public void setParent(UIPanelAPI value) {
        UiUtil.utils.setParent(boxedElement, value);
    }

    public Fader getMouseoverHighlightFader() {
        return UiUtil.utils.getMouseoverHighlightFader(boxedElement);
    }

    public UIPanelAPI getTopAncestor() {
        return UiUtil.utils.findTopAncestor(boxedElement);
    }

    public void setMouseOverPad(float p1, float p2, float p3, float p4) {
        UiUtil.utils.setMouseOverPad(boxedElement, p1, p2, p3, p4);
    }

    public void setTooltipOffsetFromCenter(float xPad, float yPad) {
        UiUtil.utils.setTooltipOffsetFromCenter(boxedElement, xPad, yPad);
    }

    public void setTooltipPositionRelativeToAnchor(float xPad, float yPad, UIComponentAPI anchor) {
        UiUtil.utils.setTooltipPositionRelativeToAnchor(boxedElement, xPad, yPad, anchor);
    }

    public void addTooltip(
            TooltipMakerAPI.TooltipLocation location,
            float width,
            Float padding,
            TooltipBuilder lambda
    ) {
        StandardTooltipV2Expandable tooltip = new StandardTooltipV2Expandable(width, false, true) {
            @Override
            public void createImpl(boolean expanded) {
                lambda.build(this);
            }
        };

        if (padding == null) {
            switch (location) {
                case LEFT -> UiUtil.utils.addTooltipLeft(boxedElement, tooltip);
                case RIGHT -> UiUtil.utils.addTooltipRight(boxedElement, tooltip);
                case ABOVE -> UiUtil.utils.addTooltipAbove(boxedElement, tooltip);
                case BELOW -> UiUtil.utils.addTooltipBelow(boxedElement, tooltip);
            }
        } else {
            switch (location) {
                case LEFT -> UiUtil.utils.addTooltipLeft(boxedElement, tooltip, padding);
                case RIGHT -> UiUtil.utils.addTooltipRight(boxedElement, tooltip, padding);
                case ABOVE -> UiUtil.utils.addTooltipAbove(boxedElement, tooltip, padding);
                case BELOW -> UiUtil.utils.addTooltipBelow(boxedElement, tooltip, padding);
            }
        }
    }

    public void setSlideData(float xOffset, float yOffset, float durationIn, float durationOut) {
        UiUtil.utils.setSlideData(boxedElement, xOffset, yOffset, durationIn, durationOut);
    }

    public void slideIn() {
        UiUtil.utils.slideIn(boxedElement);
    }

    public void slideOut() {
        UiUtil.utils.slideOut(boxedElement);
    }

    public void forceSlideIn() {
        UiUtil.utils.forceSlideIn(boxedElement);
    }

    public void forceSlideOut() {
        UiUtil.utils.forceSlideOut(boxedElement);
    }

    public boolean isSliding() {
        return UiUtil.utils.isSliding(boxedElement);
    }

    public boolean isSlidIn() {
        return UiUtil.utils.isSlidIn(boxedElement);
    }

    public boolean isSlidOut() {
        return UiUtil.utils.isSlidOut(boxedElement);
    }

    public boolean isSlidingIn() {
        return UiUtil.utils.isSlidingIn(boxedElement);
    }

    public boolean isEnabled() {
        return UiUtil.utils.isEnabled(boxedElement);
    }

    public void setEnabled(boolean value) {
        UiUtil.utils.setEnabled(boxedElement, value);
    }

    public float getWidth() {
        return getPosition().getWidth();
    }

    public void setWidth(float value) {
        getPosition().setSize(value, getPosition().getHeight());
    }

    public float getHeight() {
        return getPosition().getHeight();
    }

    public void setHeight(float value) {
        getPosition().setSize(getPosition().getWidth(), value);
    }

    public void setSize(float width, float height) {
        getPosition().setSize(width, height);
    }

    public float getX() {
        return getPosition().getX();
    }

    public float getY() {
        return getPosition().getY();
    }

    public float getLeft() {
        return getX();
    }

    public float getBottom() {
        return getY();
    }

    public float getTop() {
        return getY() + getHeight();
    }

    public float getRight() {
        return getX() + getWidth();
    }

    public void setLocation(float x, float y) {
        getPosition().setLocation(x, y);
    }

    public float getCenterX() {
        return getPosition().getCenterX();
    }

    public float getCenterY() {
        return getPosition().getCenterY();
    }

    public float getXAlignOffset() {
        return UiUtil.utils.positionGetXAlignOffset(getPosition());
    }

    public void setXAlignOffset(float value) {
        getPosition().setXAlignOffset(value);
    }

    public float getYAlignOffset() {
        return UiUtil.utils.positionGetYAlignOffset(getPosition());
    }

    public void setYAlignOffset(float value) {
        getPosition().setYAlignOffset(value);
    }

    public void anchorInTopLeftOfParent(float xPad, float yPad) {
        getPosition().inTL(xPad, yPad);
    }

    public void anchorInTopRightOfParent(float xPad, float yPad) {
        getPosition().inTR(xPad, yPad);
    }

    public void anchorInTopMiddleOfParent(float yPad) {
        getPosition().inTMid(yPad);
    }

    public void anchorInBottomLeftOfParent(float xPad, float yPad) {
        getPosition().inBL(xPad, yPad);
    }

    public void anchorInBottomMiddleOfParent(float yPad) {
        getPosition().inBMid(yPad);
    }

    public void anchorInBottomRightOfParent(float xPad, float yPad) {
        getPosition().inBR(xPad, yPad);
    }

    public void anchorInLeftMiddleOfParent(float xPad) {
        getPosition().inLMid(xPad);
    }

    public void anchorInRightMiddleOfParent(float xPad) {
        getPosition().inRMid(xPad);
    }

    public void anchorInCenterOfParent() {
        UiUtil.utils.positionRelativeTo(
                getPosition(),
                null,
                0.5f,
                0.5f,
                -0.5f,
                -0.5f,
                0f,
                0f
        );
    }

    public UIComponentAPI getPreviousComponent() {
        List<UIComponentAPI> children = UiUtil.utils.getChildrenCopy(getParent());
        return children == null || children.isEmpty() ? null : children.get(children.size() - 1);
    }

    public List<UIComponentAPI> getChildrenCopy() {
        return boxedElement instanceof UIPanelAPI ? UiUtil.utils.getChildrenCopy((UIPanelAPI) boxedElement) : null;
    }

    public List<UIComponentAPI> getChildrenNonCopy() {
        return UiUtil.utils.getChildrenNonCopy(boxedElement);
    }

    public void clearChildren() {
        if (boxedElement instanceof UIPanelAPI panel) {
            UiUtil.utils.clearChildren(panel);
        }
    }

    public UIComponentAPI getWrappedComponent() {
        return boxedElement;
    }

    public interface TooltipBuilder {
        void build(TooltipMakerAPI tooltip);
    }
}
