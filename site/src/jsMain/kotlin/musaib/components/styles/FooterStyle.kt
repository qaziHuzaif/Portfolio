package musaib.components.styles

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent


val FooterStyle = CssStyle {
    base {
        Modifier
            //.backgroundColor(colorMode.toSitePalette().nearBackground)
            .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)

    }

}

val FooterTextStyle = CssStyle {

    Breakpoint.ZERO {

        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.SM {

        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.MD {

        Modifier
            .fontSize(FontSize.Large)
    }

    Breakpoint.XL {

        Modifier
            .fontSize(FontSize.Medium)
    }

    Breakpoint.LG {

        Modifier
            .fontSize(FontSize.Medium)
    }


}

