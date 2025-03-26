package org.musaibshabir.portfolio.components.sections.about.style

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.ImageStyle
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh
import musaib.components.styles.SectionContainerStyle

val AboutStyle = SectionContainerStyle.extendedBy {

    base {
        Modifier
            .height(auto)
            .padding { bottom(5.cssRem) }

    }

}

val SkillItemImageVariant = ImageStyle.addVariant {
    Breakpoint.ZERO {
        Modifier.size(1.65.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(1.75.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(2.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(2.25.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(2.25.cssRem)
    }
}

val SkillsSectionStyle = CssStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .height(30.vh)
    }
    Breakpoint.ZERO {
        Modifier
            .maxWidth(100.percent)
//            .backgroundImage(
//                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
//                    //add(colorPalette.brand.primary.toRgb().copyf(alpha = if (colorMode.isDark) 0.1f else 0.2f))
//                    add(Colors.Transparent, 50.percent)
//                }
//            )
    }
    Breakpoint.SM {
        Modifier.maxWidth(100.percent)
    }
    Breakpoint.MD {
        Modifier
            .maxWidth(100.percent)
//            .backgroundImage(
//                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 50.percent)) {
//                    //add(colorPalette.brand.primary.toRgb().copyf(alpha = if (colorMode.isDark) 0.1f else 0.2f))
//                    add(Colors.Transparent, 63.percent)
//                }
//            )
    }
    Breakpoint.LG {
        Modifier.maxWidth(100.percent)
    }
    Breakpoint.XL {
        Modifier.maxWidth(70.percent)
    }
}

val SkillsGridStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(top = 6.5.cssRem, left = 2.25.cssRem)
            .gridAutoRows { size(1.fr) }
    }
    Breakpoint.ZERO {
        Modifier.gap(
            columnGap = 1.cssRem,
            rowGap = 1.5.cssRem
        )
    }
    Breakpoint.LG {
        Modifier.gap(
            columnGap = 1.5.cssRem,
            rowGap = 2.5.cssRem
        )
    }
}




