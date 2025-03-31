package musaib.components.sections.navHeader.ui

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.document
import kotlinx.browser.window
import musaib.components.widgets.IconButton
import musaib.toSitePalette
import org.jetbrains.compose.web.css.*

val NavHeaderStyle = CssStyle.base {
    val colorPalette = colorMode.toPalette()
    Modifier
        .fillMaxWidth()
        .padding(1.cssRem)
        .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
        .position(Position.Sticky)
        .top(0.percent)
        .backdropFilter(saturate(180.percent), blur(8.px))
        .display(DisplayStyle.Flex)
}

val SideMenuStyle = CssStyle.base {

    val colorPalette = colorMode.toPalette()
    Modifier
        .fillMaxHeight()
        .width(clamp(8.cssRem, 33.percent, 10.cssRem))
        .padding(top = 1.cssRem, leftRight = 1.cssRem)
        .gap(1.5.cssRem)
        .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
        .backdropFilter(saturate(180.percent), blur(8.px))
}

val MenuStyle = CssStyle{

    hover {
        Modifier.opacity(.5)
    }
}





@Composable
private fun NavLink(path: String, text: String, isActive: Boolean) {
    Link(
        path,
        text,
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        modifier = MenuStyle.toModifier()

            .then(if (isActive) Modifier.color(ColorMode.current.toSitePalette().subHeadLine)
             else Modifier
            )
    )
}


@Composable
private fun MenuItems(activeSection: String) {
    NavLink("#home", "Home", activeSection == "home")
    NavLink("#about", "About", activeSection == "about")
    NavLink("#projects", "Projects", activeSection == "projects")
    NavLink("#contact", "Contact", activeSection == "contact")
}


@Composable
private fun ColorModeButton() {
    var colorMode by ColorMode.currentState
    IconButton(onClick = { colorMode = colorMode.opposite },) {
        if (colorMode.isLight) MoonIcon() else SunIcon()
    }

}

@Composable
private fun HamburgerButton(onClick: () -> Unit) {
    IconButton(onClick) {
        HamburgerIcon()
    }
}

@Composable
private fun CloseButton(onClick: () -> Unit) {
    IconButton(onClick) {
        CloseIcon()
    }
}

val SideMenuSlideInAnim = Keyframes {
    from {
        Modifier.translateX((-100).percent)
    }

    to {
        Modifier
    }
}

// Note: When the user closes the side menu, we don't immediately stop rendering it (at which point it would disappear
// abruptly). Instead, we start animating it out and only stop rendering it when the animation is complete.
enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}

@Composable
fun NavHeader() {
    var activeSection by remember { mutableStateOf("home") }

    // Side effect to listen to scroll events and update active section
    SideEffect {
        window.onscroll =  {
            val sections = listOf("home", "about", "projects", "contact")
            sections.forEach { section ->
                val element = document.getElementById(section)
                if (element != null) {
                    val rect = element.getBoundingClientRect()
                    if (rect.top <= window.innerHeight / 2 && rect.bottom >= window.innerHeight / 2) {
                        activeSection = section
                    }


                }
            }
        }
    }

    Row(
        NavHeaderStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .gap(1.5.cssRem)
                .displayIfAtLeast(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MenuItems(activeSection)
        }

        Row(
            Modifier
                .gap(1.5.cssRem)
                .displayIfAtLeast(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ColorModeButton()
        }

        Row(
            Modifier
                .fillMaxWidth()
                .fontSize(1.5.cssRem)
                .gap(1.cssRem)
                .displayUntil(Breakpoint.MD),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

            HamburgerButton(onClick = { menuState = SideMenuState.OPEN })

            if (menuState != SideMenuState.CLOSED) {
                SideMenu(
                    menuState,
                    activeSection = activeSection,
                    close = { menuState = menuState.close() },
                    onAnimationEnd = { if (menuState == SideMenuState.CLOSING) menuState = SideMenuState.CLOSED }
                )
            }

            ColorModeButton()
        }
    }
}


@Composable
private fun SideMenu(
    menuState: SideMenuState,
    close: () -> Unit,
    onAnimationEnd: () -> Unit,
    activeSection: String
) {

    Overlay(
        Modifier
            .setVariable(OverlayVars.BackgroundColor, Colors.Transparent)
            .onClick { close() }
    ) {
        key(menuState) { // Force recompute animation parameters when close button is clicked
            Column(

                SideMenuStyle.toModifier()
                    .align(Alignment.CenterStart)
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .borderRadius(topRight = 2.cssRem)
                    .onClick { it.stopPropagation() }
                    .onAnimationEnd { onAnimationEnd() },
                horizontalAlignment = Alignment.Start
            ) {
                CloseButton(onClick = { close() })
                Column(Modifier.padding(right = 0.75.cssRem).gap(1.5.cssRem).fontSize(1.4.cssRem), horizontalAlignment = Alignment.Start) {
                    MenuItems(activeSection)
                }
            }
        }
    }
}
